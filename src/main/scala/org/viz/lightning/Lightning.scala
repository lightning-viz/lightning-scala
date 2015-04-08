package org.viz.lightning

import org.viz.lightning.types.{Three, Plots}

import org.json4s._
import org.json4s.native.JsonMethods._
import org.json4s.native.Serialization
import scalaj.http._

class Lightning (var host: String) extends Plots with Three {

  var session: Int = -1
  var auth: Option[(String, String)] = None

  def this() = this("http://localhost:3000")

  def createSession(sessionName: String = "") {

    val url = host + "/sessions/"

    implicit val formats = DefaultFormats

    val payload = sessionName match {
      case "" => "{}"
      case _ => Serialization.write( Map("name" -> sessionName) )
    }

    val id = post(url, payload)

    session = id

  }

  def plot(name: String, data: Map[String, Any]): Visualization = {

    this.checkSession()

    val url = host + "/sessions/" + session + "/visualizations/"

    val id = postData(url, data, name)

    new Visualization(this, id.toInt, name)

  }

  def useSession(id: Int): this.type = {
    this.session = id
    this
  }

  def useHost(host: String): this.type = {
    this.host = host
    this
  }

  def checkSession() {
    if (session == -1) {
      this.createSession()
    }
  }

  def post(url: String, payload: String, method: String = "POST"): Int = {

    var request = Http(url).postData(payload).method(method)
      .header("content-type", "application/json")
      .header("accept", "text/plain")

    if (auth.nonEmpty) {
      request = request.auth(auth.get._1, auth.get._2)
    }

    implicit val formats = DefaultFormats

    val response = request.asString
    response.body.toLowerCase match {
      case "unauthorized" => throw new Exception("Unauthorized. Check username and/or password.")
      case _ => {
        val json = parse(response.body)
        (json \ "id").extract[Int]
      }
    }
  }

  def postData(url: String, data: Map[String, Any], name: String, method: String = "POST"): Int = {

    implicit val formats = DefaultFormats

    val blob = Map("data" -> data, "type" -> name)
    val payload = Serialization.write(blob)

    post(url, payload, method)

  }

}

object Lightning {

  def apply(host: String = ""): Lightning = {
    host match {
      case "" => new Lightning()
      case _ => new Lightning(host)
    }
  }

}
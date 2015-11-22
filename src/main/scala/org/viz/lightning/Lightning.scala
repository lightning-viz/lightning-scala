package org.viz.lightning

import org.viz.lightning.types.{Three, Plots, Linked}

import org.json4s._
import org.json4s.native.JsonMethods._
import org.json4s.native.Serialization
import scalaj.http._

class Lightning (var host: String) extends Plots with Three with Linked {

  var session: String = ""
  var auth: Option[(String, String)] = None
  var isNotebook: Boolean = false

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

    new Visualization(this, id, name)

  }

  def useSession(id: String): this.type = {
    this.session = id
    this
  }

  def useHost(host: String): this.type = {
    this.host = host
    this
  }

  def enableNotebook(): this.type = {
    this.isNotebook = true
    //implicit val HTMLViz = org.refptr.iscala.display.HTMLDisplay[Visualization] { viz =>
    //  viz.getHTML
    //}
    this
  }

  def checkSession() {
    if (session == "") {
      this.createSession()
    }
  }

  def post(url: String, payload: String, method: String = "POST"): String = {

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
        (json \ "id").extract[String]
      }
    }
  }

  def postData(url: String, data: Map[String, Any], name: String, method: String = "POST"): String = {

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

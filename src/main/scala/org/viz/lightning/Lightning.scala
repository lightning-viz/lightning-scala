package org.viz.lightning

import scalaj.http._
import org.json4s._
import org.json4s.JsonDSL.WithDouble._
import org.json4s.native.JsonMethods._

class Lightning (var host: String) {

  var session: Option[Int] = None
  var auth: Option[(String, String)] = None

  def this() = this("http://localhost:3000")

  def createSession(name: Option[String] = None) {

    val url = host + "/sessions/"

    val data = name.isEmpty match {
      case false => compact(render("name" -> name))
      case true => "{}"
    }

    val request = Http(url).postData(data)
      .header("content-type", "application/json")
      .header("accept", "text/plain")

    if (auth.nonEmpty) {
      request.auth(auth.get._1, auth.get._2)
    }

    implicit val formats = DefaultFormats

    val response = request.asString
    val json = parse(response.body)
    val id = (json \ "id").extract[Int]

    session = Some(id)

  }

}
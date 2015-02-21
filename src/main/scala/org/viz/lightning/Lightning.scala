package org.viz.lightning

import scalaj.http._
import nl.typeset.sonofjson._

class Lightning (private var host: String) {

  var session: Option[Int] = None
  var auth: Option[(String, String)] = None

  def this() = this("http://localhost:3000")

  def createSession(sessionName: Option[String] = None) {

    val url = host + "/sessions/"

    val data = sessionName.isEmpty match {
      case false => render(parse("""{ "name" : "name" }"""))
      case true => "{}"
    }

    val request = Http(url).postData(data)
      .header("content-type", "application/json")
      .header("accept", "text/plain")

    if (auth.nonEmpty) {
      request.auth(auth.get._1, auth.get._2)
    }

    val response = request.asString
    val json = parse(response.body)
    val id : String = json.id

    session = Some(id.toInt)

  }

  def setSession(id: Int): this.type = {
    this.session = Some(id)
    this
  }

  def setHost(host: String): this.type = {
    this.host = host
    this
  }

}
package org.viz.lightning

class Visualization(lightning: Lightning, id: Int) {



}

  def formatURL(url: String): String = {
    val out = url.last.toString match {
      case "/" => url
      case _ => url + "/"
    }
    out + "?host=" + lgn.host
  }

  def getPermalinkURL: String = {
    lgn.host + "/visualizations/" + id
  }

  def getEmbedLink: String = {
    formatURL(this.getPermalinkURL + "/embed")
  }

  def getDataLink: String = {
    formatURL(lgn.host + "/sessions/" + lgn.session + "/visualizations/" + id + "/data/")
  }

  def getHTML: String = {
    val url = getEmbedLink
    val request = Http(url).method("GET")
    if (lgn.auth.nonEmpty) {
      request.auth(lgn.auth.get._1, lgn.auth.get._2)
    }
    request.asString.body
  }

}
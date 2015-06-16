package org.viz.lightning.types

class Settings(var map: Map[String, Any]) {

  def this() = this(Map[String, Any]())

  def append(style: Style): this.type = {
    if (style.defined) {
      style.validate
      map += style.name -> style.contents
    }
    this
  }

  def append(styles: List[Style]): this.type = {
    styles.foreach{ style =>
      this.append(style)
    }
    this
  }

  def toMap: Map[String, Any] = {
    map
  }

}
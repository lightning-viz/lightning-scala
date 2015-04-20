package org.viz.lightning.types

class Styles(var values: Map[String, Any]) {

  def this() = this(Map[String, Any]())

  def append(value: Array[Double], name: String): this.type = {

    if (value.length > 0) {
      values += name -> value.toList
    }
    this
  }

  def append(value: Array[Int], name: String): this.type = {

    if (value.length > 0) {
      values += name -> value.toList
    }
    this
  }

  def append(value: String, name: String): this.type = {

    if (value != "") {
      values += name -> value
    }

    this
  }

  def toMap: Map[String, Any] = {
    values
  }

}
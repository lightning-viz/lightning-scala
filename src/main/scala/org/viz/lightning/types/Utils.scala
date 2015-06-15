package org.viz.lightning.types

object Utils {

  def getLinks(conn: Array[Array[Double]]): Array[Array[Double]] = {

    if (conn.length == conn(0).length) {

      conn.zipWithIndex
        .flatMap{case (row, i) => row.zipWithIndex
        .filter{case (x, j) => x != 0}.map{case (x, j) => Array(i, j, x)}}

    } else {

      conn(0).length match {
        case 2 => conn
        case 3 => conn.map(l => Array(l(0), l(1), 1.0))
        case _ => throw new IllegalArgumentException("Elements per link must be 2 or 3")
      }

    }
  }

  def getNodes(conn: Array[Array[Double]]): Array[Int] = {

    if (conn.length == conn(0).length) {
      Range(0, conn.length).toArray
    } else {
      val n = conn.map(l => l.max).max.toInt + 1
      Range(0, n).toArray
    }

  }

  def getPoints(x: Array[Double], y: Array[Double]): Array[Array[Double]] = {
    (x, y).zipped.map((x, y) => Array(x, y))
  }

}

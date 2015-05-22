package org.viz.lightning.types

object Utils {

  def getLinks(mat: Array[Array[Double]]): Array[Array[Double]] = {

    mat.zipWithIndex
      .flatMap{case (row, i) => row.zipWithIndex
        .filter{case (x, j) => x != 0}.map{case (x, j) => Array(i, j, x)}}

  }

  def getPoints(x: Array[Double], y: Array[Double]): Array[Array[Double]] = {
    (x, y).zipped.map((x, y) => Array(x, y))
  }

}

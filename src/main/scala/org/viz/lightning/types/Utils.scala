package org.viz.lightning.types

object Utils {

  def getLinks(mat: Array[Array[Double]]): Array[Array[Double]] = {

    mat.zipWithIndex
      .flatMap{case (row, i) => row.zipWithIndex
        .filter{case (x, j) => x != 0}.map{case (x, j) => Array(i, j, x)}}

  }

}

package org.viz.lightning.types

class Plots {

  def line(series: Array[Double]) = {
    Map("series" -> series.toList)
  }

  def scatter(x: Array[Double], y: Array[Double]) = {
    Map("points" -> x.zip(y).toList)
  }

}
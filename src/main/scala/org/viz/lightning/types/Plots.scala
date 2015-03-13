package org.viz.lightning.types

import org.viz.lightning.Visualization

trait Plots extends Base {

  def line(series: Array[Array[Double]], label: Array[Int] = Array[Int]()): Visualization = {
    var payload = Map[String, Any]()
    payload += "series" -> series.toList
    if (label.length > 0) {
      payload += "label" -> label.toList
    }
    plot("line", payload)
  }

  def scatter(x: Array[Double], y: Array[Double], label: Array[Int] = Array[Int]()): Visualization = {
    var payload = Map[String, Any]()
    payload += "points" -> (x, y).zipped.map((x, y) => List(x, y)).toList
    if (label.length > 0) {
      payload += "label" -> label.toList
    }
    plot("scatter", payload)
  }

}

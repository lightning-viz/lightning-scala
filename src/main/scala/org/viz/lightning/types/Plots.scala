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

  def matrix(mat: Array[Array[Double]],
             colormap: String = ""): Visualization = {

    val data = Map("matrix" -> mat.toList)

    val styles = new Styles()
      .append(colormap, "colormap")

    plot("matrix", data ++ styles.toMap)
  }

}

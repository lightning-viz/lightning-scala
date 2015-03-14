package org.viz.lightning.types

import org.viz.lightning.Visualization

trait Three extends Base {

  def scatter3(x: Array[Double],
      y: Array[Double],
      z: Array[Double],
      label: Array[Int] = Array[Int]()
      size: Array[Int] = Array[Int]()): Visualization = {
    val out = (x, y, z).zipped.map((x, y, z) => List(x, y, z)).toList
    var payload = Map[String, Any]()
    payload += "points" -> out
    if (label.length > 0) {
      payload += "label" -> label.toList
    }
    if (size.length > 0) {
      payload += "size" -> size.toList
    }
    plot("scatter3", payload)
  }

}

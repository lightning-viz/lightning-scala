package org.viz.lightning.types

import org.viz.lightning.Visualization

trait Three extends Base {

  def scatter3(x: Array[Double], y: Array[Double], z: Array[Double]): Visualization = {
    val out = (x, y, z).zipped.map((x, y, z) => List(x, y, z)).toList
    val payload = Map("points" -> out)
    plot("scatter3", payload)
  }

}

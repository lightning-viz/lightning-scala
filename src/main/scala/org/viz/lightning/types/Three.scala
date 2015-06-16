package org.viz.lightning.types

import org.viz.lightning.Visualization

trait Three extends Base {

  /**
   * Three-dimensional data as spheres.
   */
  def scatter3(x: Array[Double],
               y: Array[Double],
               z: Array[Double],
               label: Array[Int] = Array[Int](),
               size: Array[Double] = Array[Double]()): Visualization = {

    val points = (x, y, z).zipped.map((x, y, z) => List(x, y, z)).toList
    val data = Map("points" -> points)

    val settings = new Settings()
      .append(List(Label(label), Size(size)))

    plot("scatter-3", data ++ settings.toMap)
  }

}

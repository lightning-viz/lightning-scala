package org.viz.lightning.types

import org.viz.lightning.Visualization

trait Linked extends Base {

  /**
   * Linked scatter and line plot
   */
  def scatterLine(x: Array[Double],
                  y: Array[Double],
                  series: Array[Array[Double]],
                  label: Array[Int] = Array[Int](),
                  size: Array[Double] = Array[Double](),
                  alpha: Array[Double] = Array[Double]()): Visualization = {

    val points = Utils.getPoints(x, y)
    val data = Map("series" -> series.toList, "points" -> points.toList)

    val settings = new Settings()
      .append(List(Label(label), Size(size), Alpha(alpha)))

    plot("scatter-line", data ++ settings.toMap)

  }

}

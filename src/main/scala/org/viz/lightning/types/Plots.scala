package org.viz.lightning.types

import org.viz.lightning.Visualization

trait Plots extends Base {

  /**
   * One or more one-dimensional series data as lines.
   */
  def line(series: Array[Array[Double]],
           label: Array[Int] = Array[Int](),
           size: Array[Double] = Array[Double](),
           alpha: Array[Double] = Array[Double](),
           xaxis: String = "",
           yaxis: String = ""): Visualization = {

    val data = Map("series" -> series.toList)

    val settings = new Settings()
      .append(List(Label(label), Size(size), Alpha(alpha)))
      .append(List(Axis(xaxis, "xaxis"), Axis(yaxis, "yaxis")))

    plot("line", data ++ settings.toMap)

  }

  /**
   * Browsable array of line plots.
   */
  def lineStacked(series: Array[Array[Double]],
                  label: Array[Int] = Array[Int](),
                  size: Array[Double] = Array[Double](),
                  alpha: Array[Double] = Array[Double](),
                  xaxis: String = "",
                  yaxis: String = ""): Visualization = {

    val data = Map("series" -> series.toList)

    val settings = new Settings()
      .append(List(Label(label), Size(size)))

    plot("line-stacked", data ++ settings.toMap)

  }

  /**
   * Force-directed network from a connectivity matrix.
   */
  def force(mat: Array[Array[Double]],
            label: Array[Int] = Array[Int](),
            size: Array[Double] = Array[Double]()): Visualization = {

    val links = Utils.getLinks(mat)
    val nodes = Range(0, mat.length)

    val data = Map("links" -> links.toList, "nodes" -> nodes.toList)

    val settings = new Settings()
      .append(List(Label(label), Size(size)))

    plot("force", data ++ settings.toMap)

  }

  /**
   *  Two-dimensional data as points.
   */
  def scatter(x: Array[Double],
              y: Array[Double],
              label: Array[Int] = Array[Int](),
              size: Array[Double] = Array[Double](),
              alpha: Array[Double] = Array[Double](),
              xaxis: String = "",
              yaxis: String = ""): Visualization = {

    val data = Map("points" -> (x, y).zipped.map((x, y) => List(x, y)).toList)

    val settings = new Settings()
      .append(List(Label(label), Size(size), Alpha(alpha)))
      .append(List(Axis(xaxis, "xaxis"), Axis(yaxis, "yaxis")))

    plot("scatter", data ++ settings.toMap)
  }

  /**
   * Dense matrix or a table as a heat map.
   */
  def matrix(mat: Array[Array[Double]],
             colormap: String = ""): Visualization = {

    val data = Map("matrix" -> mat.toList)

    val settings = new Settings()
      .append(Colormap(colormap))

    plot("matrix", data ++ settings.toMap)
  }

}

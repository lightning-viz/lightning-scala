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

    val styles = new Styles()
      .append(label, "label")
      .append(size, "size")
      .append(alpha, "alpha")
      .append(xaxis, "xaxis")
      .append(yaxis, "yaxis")

    plot("line", data ++ styles.toMap)

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

    val styles = new Styles()
      .append(label, "label")
      .append(size, "size")

    plot("line-stacked", data ++ styles.toMap)

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

    val styles = new Styles()
      .append(label, "label")
      .append(size, "size")

    plot("force", data ++ styles.toMap)

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

    val styles = new Styles()
      .append(label, "label")
      .append(size, "size")
      .append(alpha, "alpha")
      .append(xaxis, "xaxis")
      .append(yaxis, "yaxis")

    plot("scatter", data ++ styles.toMap)
  }

  /**
   * Dense matrix or a table as a heat map.
   */
  def matrix(mat: Array[Array[Double]],
             colormap: String = ""): Visualization = {

    val data = Map("matrix" -> mat.toList)

    val styles = new Styles()
      .append(colormap, "colormap")

    plot("matrix", data ++ styles.toMap)
  }

}

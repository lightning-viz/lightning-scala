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
  def force(matrix: Array[Array[Double]],
            label: Array[Int] = Array[Int](),
            size: Array[Double] = Array[Double]()): Visualization = {

    val links = Utils.getLinks(matrix)
    val nodes = Range(0, matrix.length)

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

    val points = Utils.getPoints(x, y)
    val data = Map("points" -> points.toList)

    val settings = new Settings()
      .append(List(Label(label), Size(size), Alpha(alpha)))
      .append(List(Axis(xaxis, "xaxis"), Axis(yaxis, "yaxis")))

    plot("scatter", data ++ settings.toMap)
  }

  /**
   * Dense matrix or a table as a heat map.
   */
  def matrix(matrix: Array[Array[Double]],
             colormap: String = ""): Visualization = {

    val data = Map("matrix" -> matrix.toList)

    val settings = new Settings()
      .append(Colormap(colormap))

    plot("matrix", data ++ settings.toMap)
  }

  /**
   * Sparse adjacency matrix with labels.
   */
  def adjacency(matrix: Array[Array[Double]],
                label: Array[Int] = Array[Int]()): Visualization = {

    val links = Utils.getLinks(matrix)
    val nodes = Range(0, matrix.length)

    val data = Map("links" -> links.toList, "nodes" -> nodes.toList)

    val settings = new Settings()
      .append(Label(label))

    plot("adjacency", data ++ settings.toMap)

  }

  /**
   * Chloropleth map of the world or united states.
   */
  def map(regions: Array[String],
          values: Array[Double],
          colormap: String = ""): Visualization = {

    if (!(regions.forall(s => s.length == 2) | regions.forall(s => s.length == 3))) {
      throw new IllegalArgumentException("Region names must have 2 or 3 characters")
    }

    val data = Map("regions" -> regions.toList, "values" -> values.toList)

    val settings = new Settings()
      .append(Colormap(colormap))

    plot("map", data ++ settings.toMap)

  }

  /**
   * Node-link graph from spatial points and a connectivity matrix.
   */
  def graph(x: Array[Double],
            y: Array[Double],
            matrix: Array[Array[Double]],
            label: Array[Int] = Array[Int](),
            size: Array[Double] = Array[Double]()): Visualization = {

    val links = Utils.getLinks(matrix)
    val nodes = Utils.getPoints(x, y)
    val data = Map("links" -> links, "nodes" -> nodes.toList)

    val settings = new Settings()
      .append(List(Label(label), Size(size)))

    plot("graph", data ++ settings.toMap)

  }

  /**
   * Node-link graph with bundled edges from spatial points and a connectivity matrix.
   */
  def graphBundled(x: Array[Double],
                   y: Array[Double],
                   matrix: Array[Array[Double]],
                   label: Array[Int] = Array[Int](),
                   size: Array[Double] = Array[Double]()): Visualization = {

    val links = Utils.getLinks(matrix)
    val nodes = Utils.getPoints(x, y)
    val data = Map("links" -> links, "nodes" -> nodes.toList)

    val settings = new Settings()
      .append(List(Label(label), Size(size)))

    plot("graph-bundled", data ++ settings.toMap)

  }

}

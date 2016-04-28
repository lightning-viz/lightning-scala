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
   * One or more one-dimensional series data streamed as lines.
   */
  def lineStreaming(series: Array[Array[Double]],
                    size: Array[Double] = Array[Double](),
                    color: Array[Array[Double]] = Array[Array[Double]](),
                    alpha: Array[Double] = Array[Double] (),
                    label: Array[Int] = Array[Int](),
                    xaxis: String = "",
                    yaxis: String = "",
                    viz: Visualization = null): Visualization = {

    val data = Map("series" -> series.toList, "color" -> color.toList)

    val settings = new Settings()
      .append(List(Label(label), Size(size), Alpha(alpha)))
      .append(List(Axis(xaxis, "xaxis"), Axis(yaxis, "yaxis")))

    val payload = data ++ settings.toMap

    if (viz == null) {
      plot("line-streaming", payload)

    } else {
      viz.append(payload)
    }

  }

  /**
   * Force-directed network from connectivity.
   */
  def force(conn: Array[Array[Double]],
            label: Array[Int] = Array[Int](),
            value: Array[Double] = Array[Double](),
            colormap: String = "",
            size: Array[Double] = Array[Double]()): Visualization = {

    val links = Utils.getLinks(conn)
    val nodes = Utils.getNodes(conn)

    val data = Map("links" -> links.toList, "nodes" -> nodes.toList)

    val settings = new Settings()
      .append(List(Label(label), Value(value), Colormap(colormap), Size(size)))

    plot("force", data ++ settings.toMap)

  }

  /**
   *  Two-dimensional data as points.
   */
  def scatterStreaming(x: Array[Double],
              y: Array[Double],
              label: Array[Int] = Array[Int](),
              value: Array[Double] = Array[Double](),
              colormap: String = "",
              size: Array[Double] = Array[Double](),
              alpha: Array[Double] = Array[Double](),
              xaxis: String = "",
              yaxis: String = "",
              viz: Visualization = null): Visualization = {

    val points = Utils.getPoints(x, y)
    val data = Map("points" -> points.toList)

    val settings = new Settings()
      .append(List(Label(label), Value(value), Colormap(colormap), Size(size), Alpha(alpha)))
      .append(List(Axis(xaxis, "xaxis"), Axis(yaxis, "yaxis")))

    val payload = data ++ settings.toMap

    if (viz == null) {
      plot("scatter-streaming", payload)
    } else {
      viz.append(payload)
    }

  }

  /**
   *  Streaming two-dimensional data as points.
   */
  def scatter(x: Array[Double],
              y: Array[Double],
              label: Array[Int] = Array[Int](),
              value: Array[Double] = Array[Double](),
              colormap: String = "",
              size: Array[Double] = Array[Double](),
              alpha: Array[Double] = Array[Double](),
              xaxis: String = "",
              yaxis: String = ""): Visualization = {

    val points = Utils.getPoints(x, y)
    val data = Map("points" -> points.toList)

    val settings = new Settings()
      .append(List(Label(label), Value(value), Colormap(colormap), Size(size), Alpha(alpha)))
      .append(List(Axis(xaxis, "xaxis"), Axis(yaxis, "yaxis")))

    plot("scatter", data ++ settings.toMap)
  }


  /**
   * Dense matrix or a table as a heat map.
   */
  def matrix(matrix: Array[Array[Double]],
             colormap: String = "",
             rowLabels: Array[String] = Array[String](),
             colLabels: Array[String] = Array[String]()): Visualization = {

    val data = Map("matrix" -> matrix.toList, "rowLabels" -> rowLabels.toList,"columnLabels" -> colLabels.toList)

    val settings = new Settings()
      .append(Colormap(colormap))

    plot("matrix", data ++ settings.toMap)
  }

  /**
   * Sparse adjacency matrix with labels from connectivity.
   */
  def adjacency(conn: Array[Array[Double]],
                label: Array[Int] = Array[Int](),
                labels: Array[String] = Array[String]()): Visualization = {

    val links = Utils.getLinks(conn)
    val nodes = Utils.getNodes(conn)

    val data = Map("links" -> links.toList, "nodes" -> nodes.toList, "labels" -> labels.toList)

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
   * Node-link graph from spatial points and connectivity.
   */
  def graph(x: Array[Double],
            y: Array[Double],
            conn: Array[Array[Double]],
            label: Array[Int] = Array[Int](),
            value: Array[Double] = Array[Double](),
            colormap: String = "",
            size: Array[Double] = Array[Double]()): Visualization = {

    val links = Utils.getLinks(conn)
    val nodes = Utils.getPoints(x, y)
    val data = Map("links" -> links, "nodes" -> nodes.toList)

    val settings = new Settings()
      .append(List(Label(label), Value(value), Colormap(colormap), Size(size)))

    plot("graph", data ++ settings.toMap)

  }

  /**
   * Node-link graph with bundled edges from spatial points and connectivity.
   */
  def graphBundled(x: Array[Double],
                   y: Array[Double],
                   conn: Array[Array[Double]],
                   label: Array[Int] = Array[Int](),
                   value: Array[Double] = Array[Double](),
                   colormap: String = "",
                   size: Array[Double] = Array[Double]()): Visualization = {

    val links = Utils.getLinks(conn)
    val nodes = Utils.getPoints(x, y)
    val data = Map("links" -> links, "nodes" -> nodes.toList)

    val settings = new Settings()
      .append(List(Label(label), Value(value), Colormap(colormap), Size(size)))

    plot("graph-bundled", data ++ settings.toMap)

  }

}

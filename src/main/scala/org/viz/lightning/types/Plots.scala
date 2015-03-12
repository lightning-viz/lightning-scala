package org.viz.lightning.types

import org.viz.lightning.{Visualization, Lightning}


object Plots {

  object line {

    def apply(data: Array[Array[Double]], label: Option[Array[Int]] = None)
             (implicit lgn: Lightning): Visualization = {

      var out = Map[String, Any]()
      out += "series" -> data.map(l => l.toList).toList
      if (label.nonEmpty) {
        out += "label" -> label.get.toList
      }
      lgn.plot("line", out)

    }
  }

  object scatter {

    def apply(x: Array[Double], y: Array[Double], label: Option[Array[Int]] = None)
             (implicit lgn: Lightning): Visualization = {

      var out = Map[String, Any]()
      out += "points" -> (x, y).zipped.map((x, y) => List(x, y)).toList
      if (label.nonEmpty) {
        out += "label" -> label.get.toList
      }
      lgn.plot("scatter", out)
    }

  }

}

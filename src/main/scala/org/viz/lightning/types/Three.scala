package org.viz.lightning.types

import org.viz.lightning.{Visualization, Lightning}

object Three {

  object scatter3 {

    def apply(x: Array[Double], y: Array[Double], z: Array[Double], label: Option[Array[Int]] = None)
             (implicit lgn: Lightning): Visualization = {

      var out = Map[String, Any]()
      out += "points" -> (x, y, z).zipped.map((x, y, z) => List(x, y, z)).toList
      if (label.nonEmpty) {
        out += "label" -> label.get.toList
      }
      lgn.plot("line", out)
    }

  }

}

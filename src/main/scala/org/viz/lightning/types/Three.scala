package org.viz.lightning.types

import org.viz.lightning.types.utils.Cleaner

object Three {

  val lookup = Map(

    /** Three-dimensional scatter plot */
    "scatter3" -> new Cleaner[(Array[Double], Array[Double], Array[Double])](data =>
      Map(
        "points" -> (data._1, data._2, data._3).zipped.map((x, y, z) => List(x, y, z)).toList
      )
    )

  )

}

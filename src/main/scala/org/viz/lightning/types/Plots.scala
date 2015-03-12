package org.viz.lightning.types

import org.viz.lightning.types.utils.Cleaner

object Plots {

  val lookup = Map(

    /** Line plot */
    "line" -> new Cleaner[Array[Array[Double]]](data =>
      Map(
        "series" -> data.toList
      )
    ),

    /** Scatter plot */
     "scatter" -> new Cleaner[(Array[Double], Array[Double])](data =>
      Map(
        "points" -> (data._1, data._2).zipped.map((x, y) => List(x, y)).toList
      )
    )

  )

}

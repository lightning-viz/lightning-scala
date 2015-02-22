package org.viz.lightning.types

import org.viz.lightning.types.utils.DataValidator

object Plots {

  val lookup = Map({

    "line" -> new DataValidator[Array[Double]](data =>
      Map(
        "series" -> data.toList
      )
    )

    "scatter" -> new DataValidator[(Array[Double], Array[Double])](data =>
      Map(
        "points" -> (data._1, data._2).zipped.map((x, y) => List(x, y)).toList
      )
    )

  })

}

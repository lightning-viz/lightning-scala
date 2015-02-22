package org.viz.lightning.types

import org.viz.lightning.types.utils.DataValidator

object Three {

  val lookup = Map({

    "scatter3" -> new DataValidator[(Array[Double], Array[Double], Array[Double])](data =>
      Map(
        "points" -> (data._1, data._2, data._3).zipped.map((x, y, z) => List(x, y, z)).toList
      )
    )

  })

}

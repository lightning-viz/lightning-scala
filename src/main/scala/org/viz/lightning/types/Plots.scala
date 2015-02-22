package org.viz.lightning.types

import org.viz.lightning.types.utils.DataValidator

object Plots {

  val line = new DataValidator[Array[Double]](data =>
    Map("series" -> data.toList)
  )

  val scatter = new DataValidator[(Array[Double], Array[Double])](data =>
    Map(
      "points" -> data._1.zip(data._2).map(x => List(x._1, x._2)).toList
    )
  )

}

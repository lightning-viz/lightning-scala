package org.viz.lightning.types

import org.viz.lightning.types.utils.Cleaner

object Plots {

  val lookup = Map(

    /** Line plot */
    "line" -> new Cleaner[Array[Double]](data =>
      Map(
        "series" -> data.toList
      )
    ),

    /** Scatter plot
      * @param x array of x values
      * @param y array of y values
      * @param label array of labels for coloring (optional)
      * @param size array of sizes (optional)
      * */
     "scatter" -> new Cleaner[(Array[Double], Array[Double], Option[Array[Int]], Option[Array[Double]])](
      data => {
        val nargs = data.productIterator.toList.length
        var map = Map[String, Any]()
        map += "points" -> (data._1, data._2).zipped.map((x, y) => List(x, y)).toList
        if ((nargs > 2) & data._3.nonEmpty) {
          map += "label" -> data._3.get.toList
        }
        if ((nargs > 3) & data._4.nonEmpty) {
          map += "size" -> data._4.get.toList
        }
        map
      }
    )

  )

}

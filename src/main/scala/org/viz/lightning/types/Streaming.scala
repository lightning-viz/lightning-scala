package smart.util.lightning.types

import org.viz.lightning.Visualization
import org.viz.lightning.types._


trait Streaming extends Base {

  def lineStreaming(series: Array[Array[Double]],
                    size: Array[Double],
                    color: Array[Array[Double]] = Array[Array[Double]](),
                    alpha: Array[Double] = Array[Double] (),
                    label: Array[Int] = Array[Int](),
                    xaxis: String = "",
                    yaxis: String = ""): Visualization = {

    val data = Map("series" -> series.toList)
    val colorMap = Map ("color" -> color.toList)
    val settings = new Settings()
      .append(List(Label(label), Size(size), Alpha(alpha)))
      .append(List(Axis(xaxis, "xaxis"), Axis(yaxis, "yaxis")))

    plot("line-streaming", data ++ settings.toMap ++ colorMap )
  }

}

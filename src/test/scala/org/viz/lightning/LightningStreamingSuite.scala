package org.viz.lightning

import org.scalatest.{BeforeAndAfterAll, FunSuite}
import org.viz.lightning.types.Make

class LightningStreamingSuite extends FunSuite with BeforeAndAfterAll {

  var lgn: Lightning = _

  override def beforeAll() {
    lgn = Lightning("http://public.lightning-viz.org")
    lgn.createSession("test-streaming")
  }

  test("line streaming") {
    val viz = lgn.lineStreaming(series = Make.series(n = 5, t = 20))
    lgn.lineStreaming(series = Make.series(n = 5, t = 20), viz=viz)
  }
  test("scatter streaming") {
    val viz = lgn.scatterStreaming(x = Make.gaussian(n = 50, scale = 5),
      y = Make.gaussian(n = 50, scale = 5),
      label = Make.labels(n = 50),
      size = Make.sizes(n = 50),
      alpha = Make.alphas(n = 50))

    lgn.scatterStreaming(x = Make.gaussian(n = 50, scale = 5),
      y = Make.gaussian(n = 50, scale = 5), viz=viz)
  }

}

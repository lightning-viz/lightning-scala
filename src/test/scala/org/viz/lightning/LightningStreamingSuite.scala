package org.viz.lightning

import org.scalatest.{BeforeAndAfterAll, FunSuite}
import org.viz.lightning.types.Make

class LightningStreamingSuite extends FunSuite with BeforeAndAfterAll {

  var lgn: Lightning = _

  override def beforeAll() {
    lgn = Lightning("http://localhost:3000")
    lgn.createSession("test-streaming")
  }

  test("line streaming") {
    val viz = lgn.lineStreaming(series = Make.series(n = 5, t = 20))
    lgn.lineStreaming(series = Make.series(n = 5, t = 20), viz=viz)
  }

}

package org.viz.lightning

import org.scalatest.{BeforeAndAfterAll, FunSuite}
import org.viz.lightning.types.Make

class LightningLinkedSuite extends FunSuite with BeforeAndAfterAll {

  var lgn: Lightning = _

  override def beforeAll() {
    lgn = Lightning("http://localhost:3000")
    lgn.createSession("test-linked")
  }

  test("scatter-line") {
    lgn.scatterLine(x = Make.values(n = 20, scale = 5),
                    y = Make.values(n = 20, scale = 5),
                    series = Make.series(n = 20, t = 50),
                    label = Make.labels(n = 20),
                    size = Make.sizes(n = 20))
  }

}
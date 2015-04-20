package org.viz.lightning

import org.scalatest.{BeforeAndAfter, FunSuite}

class LightningPlotsSuite extends FunSuite with BeforeAndAfter {

  var lgn: Lightning = _

  before {
    lgn = Lightning("http://localhost:3000")
    lgn.createSession("test")
  }

  test("line") {
    lgn.line(Array(Array(1.0, 2.0), Array(2.0, 1.0)))
  }

  test("matrix") {
    lgn.matrix(Array(Array(1.0, 2.0), Array(2.0, 1.0)))
  }

  test("scatter") {
    lgn.scatter(Array(1.0, 2.0), Array(2.0, 1.0))
  }



}

package org.viz.lightning

import org.scalatest.{BeforeAndAfterAll, FunSuite}

import org.viz.lightning.types.Make

class LightningImplicitsSuite extends FunSuite with BeforeAndAfterAll {

  var lgn: Lightning = _

  override def beforeAll() {
    lgn = Lightning("http://public.lightning-viz.org")
    lgn.createSession("test-implicits")
  }

  test("line (flat)") {
    lgn.line(series = Make.line(t = 50))
  }

  test("line (flat int)") {
    lgn.line(series = Make.lineInt(t = 50))
  }

  test("line (nested int)") {
    lgn.line(series = Make.seriesInt(n = 5, t = 50))
  }


}

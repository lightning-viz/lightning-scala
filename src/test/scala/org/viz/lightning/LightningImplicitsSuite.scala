package org.viz.lightning

import org.scalatest.{BeforeAndAfterAll, FunSuite}

class LightningImplicitsSuite extends FunSuite with BeforeAndAfterAll {

  var lgn: Lightning = _

  override def beforeAll() {
    lgn = Lightning("http://localhost:3000")
    lgn.createSession("test-implicits")
  }

  test("line (flat)") {
    lgn.line(Array(1.0, 2.0))
  }

  test("line (flat int)") {
    lgn.line(Array(1, 2))
  }

  test("line (nested int)") {
    lgn.line(Array(Array(1, 2), Array(3, 4)))
  }


}

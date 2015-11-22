package org.viz.lightning

import org.scalatest.FunSuite

class LightningSuite extends FunSuite {

  test("create session") {
    val lgn = Lightning("http://localhost:3000")
    lgn.createSession("test-session")
    assert(!lgn.session.isEmpty)
  }

}


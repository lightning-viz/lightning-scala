package org.viz.lightning

import org.scalatest.FunSuite

class LightningSuite extends FunSuite {

  test("create session") {
    val lgn = Lightning("http://public.lightning-viz.org")
    lgn.createSession("test-session")
    assert(!lgn.session.isEmpty)
  }

}


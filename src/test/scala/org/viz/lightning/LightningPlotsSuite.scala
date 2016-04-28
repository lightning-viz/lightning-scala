package org.viz.lightning

import org.scalatest.{BeforeAndAfterAll, FunSuite}
import org.viz.lightning.types.Make

class LightningPlotsSuite extends FunSuite with BeforeAndAfterAll {

  var lgn: Lightning = _

  override def beforeAll() {
    lgn = Lightning("http://public.lightning-viz.org")
    lgn.createSession("test-plots")
  }

  test("line") {
    lgn.line(series = Make.series(n = 5, t = 20),
      label = Make.labels(n = 5),
      size = Make.sizes(n = 5, scale = 7, min = 3))
  }

  test("line (single)") {
    lgn.line(series = Make.line(t = 20))
  }

  test("force") {
    lgn.force(conn = Make.sparseMatrix(n = 30, threshold = 0.95),
              label = Make.labels(n = 30))
  }

  test("force (links)") {
    lgn.force(conn = Make.sparseLinks(n = 30, threshold = 0.95),
      label = Make.labels(n = 30))
  }

  test("force (links and value)") {
    lgn.force(conn = Make.sparseLinks(n = 30, threshold = 0.95),
      value = Make.values(n = 30), colormap="Purples")
  }

  test("matrix") {
    lgn.matrix(matrix = Make.matrix(n = 10))
  }

  test("adjacency") {
    lgn.adjacency(conn = Make.sparseMatrix(n = 10),
      label = Make.labels(n = 10))
  }

  test("map (states)") {
    lgn.map(regions = Array("NY", "CA", "VA"),
      values = Make.values(n = 3))
  }

  test("map (countries)") {
    lgn.map(regions = Array("USA", "ENG", "IND"),
      values = Make.values(n = 3))
  }

  test("scatter") {
    lgn.scatter(x = Make.gaussian(n = 50, scale = 5),
      y = Make.gaussian(n = 50, scale = 5),
      label = Make.labels(n = 50),
      size = Make.sizes(n = 50),
      alpha = Make.alphas(n = 50))
  }

  test("graph") {
    lgn.graph(x = Make.gaussian(n = 50),
      y = Make.gaussian(n = 50),
      conn = Make.sparseMatrix(n = 50),
      label = Make.labels(n = 50))
  }

  test("graph bundled") {
    lgn.graphBundled(x = Make.gaussian(n = 50),
      y = Make.gaussian(n = 50),
      conn = Make.sparseMatrix(n = 50),
      label = Make.labels(n = 50))
  }

}

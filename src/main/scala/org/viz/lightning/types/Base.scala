package org.viz.lightning.types

import org.viz.lightning.Visualization

trait Base {

  def plot(name: String, payload: Map[String, Any]): Visualization

}

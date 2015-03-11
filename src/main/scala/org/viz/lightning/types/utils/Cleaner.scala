package org.viz.lightning.types.utils

import scala.reflect.runtime.universe._

class Cleaner[T: TypeTag](func: T => Map[String, Any]) {

  def apply[K: TypeTag](data: K): Map[String, Any] = {
    func(data.asInstanceOf[T])
  }

}

package org.viz.lightning.types.utils

import scala.reflect.runtime.universe._

class Cleaner[T: TypeTag](func: T => Map[String, Any]) {

  def check[K: TypeTag](): Unit = {
    if (!(typeOf[K] =:= typeOf[T])) {
      throw new Exception("Data type %s does not match expected type %s"
        .format(typeOf[K], typeOf[T]))
    }
  }

  def apply[K: TypeTag](data: K): Map[String, Any] = {
    check[K]()
    func(data.asInstanceOf[T])
  }

}

package org.viz

package object lightning {

  implicit def SingletonInt(value: Int): Array[Double] =
    Array(value.toDouble)

  implicit def SingletonDouble(value: Double): Array[Double] =
    Array(value)

  implicit def IntToDouble(value: Array[Int]): Array[Double] =
    value.map(_.toDouble)

  implicit def FlatToNestedInt(value : Array[Int]): Array[Array[Double]] =
    Array(value.map(_.toDouble))

  implicit def FlatToNestedDouble(value : Array[Double]): Array[Array[Double]] =
    Array(value)

}


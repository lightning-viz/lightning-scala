package org.viz.lightning.types

import scala.util.Random

object Make {

  def line(t: Int): Array[Double] = {
    Array.fill(t)(Random.nextDouble())
  }

  def lineInt(t: Int): Array[Int] = {
    Array.fill(t)(Random.nextInt(100))
  }

  def series(n: Int, t: Int): Array[Array[Double]] = {
    Array.fill(n)(Array.fill(t)(Random.nextDouble()))
  }

  def seriesInt(n: Int, t: Int): Array[Array[Int]] = {
    Array.fill(n)(Array.fill(t)(Random.nextInt(100)))
  }

  def labels(n: Int): Array[Int] = {
    Array.fill(n)(Random.nextInt(5))
  }

  def sizes(n: Int, scale: Double = 20, min: Double = 5): Array[Double] = {
    Array.fill(n)(Random.nextFloat() * scale + min)
  }

  def alphas(n: Int, min: Double = 0.3): Array[Double] = {
    Array.fill(n){
      val rnd = Random.nextDouble() + 0.3
      if (rnd > 1.0) {
        1.0
      } else {
        rnd
      }
    }
  }

  def values(n: Int, scale: Double = 1): Array[Double] = {
    Array.fill(n)(Random.nextDouble() * scale)
  }

  def gaussian(n: Int, scale: Double = 1): Array[Double] = {
    Array.fill(n)(Random.nextGaussian() * scale)
  }

  def matrix(n: Int): Array[Array[Double]] = {
    Array.fill(n)(Array.fill(n)(Random.nextDouble()))
  }

  def sparseLinks(n: Int, threshold: Double = 0.9): Array[Array[Int]] = {
    val conn = Array.fill(n)(Array.fill(n){
      val rnd = Random.nextDouble()
      if (rnd > threshold) {
        rnd
      } else {
        0.0
      }
    })
    conn.zipWithIndex
      .flatMap{case (row, i) => row.zipWithIndex
      .filter{case (x, j) => x != 0}.map{case (x, j) => Array(i, j, x).map(_.toInt)}}
  }

  def sparseMatrix(n: Int, threshold: Double = 0.9): Array[Array[Double]] = {
    Array.fill(n)(Array.fill(n){
      val rnd = Random.nextDouble()
      if (rnd > threshold) {
        rnd
      } else {
        0.0
      }
    })
  }

}
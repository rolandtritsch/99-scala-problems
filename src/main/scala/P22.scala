package org.tritsch.scala.ninetynine

/**
 * P22 - Create a list containing all integers within a given range.
 */

object P22 {
  final def range(from: Int, to: Int): List[Int] = {
    Range(from, to+1).toList
  }
}

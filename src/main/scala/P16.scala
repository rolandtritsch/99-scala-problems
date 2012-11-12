package org.tritsch.scala.ninetynine

/**
 * P16 - Drop every Nth element from a list.
 */

object P16 {
  final def drop(n: Int, l: List[Any]): List[Any] = {
    (for(i <- 1 until l.size+1; if i%n != 0) yield l(i-1)).toList
  }
}

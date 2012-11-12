package org.tritsch.scala.ninetynine

/**
 * P18 - Extract a slice from a list.
 */

object P18 {
  final def slice(from: Int, to: Int, l: List[Any]): List[Any] = {
    l.slice(from, to)
  }

  final def slice2(from: Int, to: Int, l: List[Any]): List[Any] = {
    (for(i <- 0 until l.size; if(i >= from && i < to)) yield l(i)).toList
  }
}

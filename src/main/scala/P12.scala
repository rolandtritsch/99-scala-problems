package org.tritsch.scala.ninetynine

/**
 * P12 - decode a run-length encoded list
 */

object P12 {
  final def encode(l: List[Any]): List[(Int, Any)] = {
    (for(i <- l.distinct) yield l.count(_ == i)).zip(l.distinct)
  }

  final def decode(l: List[(Int, Any)]): List[Any] = {
    (for(i <- l; c = i._1; e = i._2) yield List.fill(c)(e)).flatten
  }
}

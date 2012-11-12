package org.tritsch.scala.ninetynine

/**
 * P19 - Rotate a list N places to the left.
 */

object P19 {
  final def rotate(n: Int, l: List[Any]): List[Any] = {
    if(n >= 0) l.drop(n) ::: l.take(n)
    else l.drop(n + l.size) ::: l.take(n + l.size)
  }
}

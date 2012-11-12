package org.tritsch.scala.ninetynine

/**
 * P17 - Split a list into two parts.
 */

object P17 {
  final def split(n: Int, l: List[Any]): (List[Any], List[Any]) = {
    (l.take(n), l.drop(n))  
  }
}

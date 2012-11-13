package org.tritsch.scala.ninetynine

/**
 * P7 - flatten a (potentially nested) list of lists
 */

object P7 {
  final def flatten(nested: Any): List[Any] = {
    nested match {
      case Nil => Nil
      case head :: tail => flatten(head) ::: flatten(tail)
      case element => List(element)
    }
  }
}

package org.tritsch.scala.ninetynine

/**
 * P7 - flatten a (potentially nested) list of lists
 */

object P7 {
  final def flatten(l: List[List[Any]]): List[Any] = {
    l.flatten
  }
}

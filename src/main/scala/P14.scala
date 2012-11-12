package org.tritsch.scala.ninetynine

/**
 * P14 - Duplicate the elements of a list.
 */

object P14 {
  final def duplicate(l: List[Any]): List[Any] = {
    (for(e <- l) yield List(e, e)).flatten    
  }
}

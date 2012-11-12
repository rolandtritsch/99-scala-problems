package org.tritsch.scala.ninetynine

/**
 * P15 - Duplicate the elements of a list a given number of times.
 */

object P15 {
  final def duplicateN(n: Int, l: List[Any]): List[Any] = {
    (for(e <- l) yield List.fill(n)(e)).flatten    
  }
}

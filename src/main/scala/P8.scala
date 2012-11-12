package org.tritsch.scala.ninetynine

/**
 * P8 - remove the duplicates from a list
 */

object P8 {
  final def compress(l: List[Any]): List[Any] = {
    l.distinct
  }

  final def compress2(l: List[Symbol]): List[Symbol] = {    
    l.toSet.toList.sortWith(_.toString < _.toString)
  }
}

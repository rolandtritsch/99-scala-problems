package org.tritsch.scala.ninetynine

/**
 * P8 - remove the duplicates from a list
 */

object P8 {
  final def compress(l: List[Any]): List[Any] = {
    l.distinct
  }

  final def compress2(l: List[String]): List[String] = {    
    l.toSet.toList.sorted
  }
}

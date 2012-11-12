package org.tritsch.scala.ninetynine

/**
 * P9 - pack dublicates into sublists
 */

object P9 {
  final def pack(l: List[Any]): List[List[Any]] = {
      for(i <- l.distinct) yield l.filter(_ == i)
  }
}

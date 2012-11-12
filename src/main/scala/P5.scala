package org.tritsch.scala.ninetynine

/**
 * P5 - reverse a list.
 */

object P5 {
  final def reverse(l: List[String]): List[String] = {
    l.reverse
  }

  final def reverse2(l: List[String]): List[String] = {
    if(l.length == 1) List(l.head)
    else reverse2(l.tail) ::: List(l.head)
  }
}

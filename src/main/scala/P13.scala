package org.tritsch.scala.ninetynine

/**
 * P13 - Run-length encoding of a list (direct (recursive) solution).
 */

object P13 {
  final def encodeElement(rest: List[Any], original: List[Any]): List[(Int, Any)] = {
    val current = (original.count(rest.head == _), rest.head)
    if(rest.size == 1) List(current)
    else current :: encodeElement(rest.tail, original)
  }

  final def encodeDirect(l: List[Any]): List[(Int, Any)] = {
    encodeElement(l.distinct, l)
  }
}

package org.tritsch.scala.ninetynine

/**
 * P10 - run-length encoding of a list
 */

object P10 {
  final def encode(l: List[Any]): List[(Int, Any)] = {
    (for(i <- l.distinct) yield l.filter(_ == i).length).zip(l.distinct)
  }

  final def encode2(l: List[Any]): List[(Int, Any)] = {
    (for(i <- l.distinct) yield l.count(_ == i)).zip(l.distinct)
  }

  final def encode3(l: List[Any]): List[(Int, Any)] = {
    for(i <- l.distinct; c = l.count(_ == i)) yield (c, i)
  }
}

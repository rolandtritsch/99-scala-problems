package org.tritsch.scala.ninetynine

/**
 * P21 - Insert an element at a given position into a list.
 */

object P21 {
  final def insertAt(e: Any, n: Int, l: List[Any]): List[Any] = {
    l.take(n) ++ List(e) ++ l.takeRight(l.size - n)
  }

  final def insertAt2(e: Any, n: Int, l: List[Any]): List[Any] = {
    (for(i <- Range(0, l.size)) yield if(i != n) List(l.apply(i)) else List(e, l.apply(i))).toList.flatten
  }
}

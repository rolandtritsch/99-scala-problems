package org.tritsch.scala.ninetynine

import scala.util.Random

/**
 * P23 - Extract a given number of randomly selected elements from a list.
 */

object P23 {
  final def randomSelect(n: Int, l: List[Any]): List[Any] = {
    // the result might contain duplicates (like List(1, 1)) 
    (for(i <- 1 to n) yield l.apply(Random.nextInt(l.size))).toList     
  }

  final def randomSelect2(n: Int, l: List[Any]): List[Any] = {
    if(l.size == n) l
    else randomSelect2(n, P20.removeAt(Random.nextInt(l.size), l)._1)
  }
}

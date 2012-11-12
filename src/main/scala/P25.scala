package org.tritsch.scala.ninetynine

import scala.util.Random

/**
 * P25 - Generate a random permutation of the elements of a list.
 */

object P25 {
  final def randomPermute(l: List[Any]): List[Any] = {
    if(l.size == 1) l
    else {
      val next = P20.removeAt(Random.nextInt(l.size), l)
      next._2 +: randomPermute(next._1)
    }
  }
}

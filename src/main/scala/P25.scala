package org.tritsch.scala.ninetynine

import scala.util.Random

/**
 * P25 - Generate a random permutation of the elements of a list.
 */

object P25 {
  final def shuffle(l: List[Any]): List[Any] = {
    if(l.size == 1) l
    else {
      val next = P20.removeN2(Random.nextInt(l.size), l)
      next._2 +: shuffle(next._1)
    }
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length > 0, "Needs at least 1 parameter - Usage: P25 <list of numbers>")
    val l = args.toList
    assert(!l.isEmpty, "<l> cannot be empty")
    println(l.mkString(",") + " -> " + shuffle(l).toString)
  } 
}

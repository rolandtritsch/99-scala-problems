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

  final def main(args: Array[String]): Unit = {
    assert(args.length > 2, "Needs at least 2 parameters - Usage: P23 <n> <list of numbers>")
    val n = args(0).toInt; val l = args.takeRight(args.length - 1).toList
    assert(n >= 1 && n <= l.size, "<n> needs to be in range of 1 ... list.size")
    assert(!l.isEmpty, "<l> cannot be empty")
    println(n + ": " + l.mkString(",") + " -> " + randomSelect(n, l).toString)
    println(n + ": " + l.mkString(",") + " -> " + randomSelect2(n, l).toString)
  } 
}

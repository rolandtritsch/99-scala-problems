package org.tritsch.scala.nintynine

/**
 * P3 - find Nth element of a list.
 */

object P3 {
  final def nth(n: Int, l: List[String]): String = {
    l(n)
  }

  final def main(args: Array[String]): Unit = {
    assert(args.size > 1, "Need at least 2 parameter - Usage: P3 <n> <list of somthing>")
    val n = args(0).toInt
    val l = args.tail.toList
    println(nth(n, l))
  } 
}

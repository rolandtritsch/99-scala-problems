package org.tritsch.scala.ninetynine

/**
 * P1 - return the last element of the list.
 */

object P1 {
  final def last(l: List[String]): String = {
    l.last
  }

  final def main(args: Array[String]): Unit = {
    assert(args.size > 0, "Need at least 1 parameter - Usage: P1 <list of somthing>")
    println(last(args.toList))
  } 
}

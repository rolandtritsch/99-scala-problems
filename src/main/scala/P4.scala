package org.tritsch.scala.nintynine

/**
 * P4 - find the number of elements in the list.
 */

object P4 {
  final def length(l: List[String]): Int = {
    l.length
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length > 1, "Need at least 1 parameter - Usage: P4 <list of somthing>")
    println(length(args.toList))
  } 
}

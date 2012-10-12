package org.tritsch.scala.ninetynine

/**
 * P2 - return the last but one element of the list.
 */

object P2 {
  final def penultimate(l: List[String]): String = {
    l.take(l.length-1).last
    // l.apply(l.length-2)
  }

  final def main(args: Array[String]): Unit = {
    assert(args.size > 0, "Need at least 1 parameter - Usage: P2 <list of somthing>")
    println(penultimate(args.toList))
  } 
}

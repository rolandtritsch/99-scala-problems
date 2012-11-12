package org.tritsch.scala.ninetynine

/**
 * P14 - Duplicate the elements of a list.
 */

object P14 {
  final def duplicate(l: List[Any]): List[Any] = {
    (for(e <- l) yield List(e, e)).flatten    
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length > 0, "Need at least 1 parameter - Usage: P14 <list of numbers>")
    println(args.mkString(",") + " -> " + duplicate(args.toList).toString)
  } 
}

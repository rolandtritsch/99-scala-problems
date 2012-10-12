package org.tritsch.scala.ninetynine

/**
 * P15 - Duplicate the elements of a list a given number of times.
 */

object P15 {
  final def dublicateN(n: Int, l: List[Any]): List[Any] = {
    (for(e <- l) yield List.fill(n)(e)).flatten    
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length > 1, "Need at least 2 parameter - Usage: P15 <N> <list of numbers>")
    val count = args.head.toInt; val list = args.tail.toList
    assert(count > 0, "Count needs to be bigger than 0")
    assert(list.size > 0, "List needs to have at least 1 element")
    println(count + ": " + list.mkString(",") + " -> " + dublicateN(count, list).toString)
  } 
}

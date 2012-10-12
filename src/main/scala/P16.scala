package org.tritsch.scala.ninetynine

/**
 * P16 - Drop every Nth element from a list.
 */

object P16 {
  final def dropN(n: Int, l: List[Any]): List[Any] = {
    (for(i <- 1 until l.size+1; if i%n != 0) yield l(i-1)).toList
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length > 1, "Need at least 2 parameter - Usage: P16 <N> <list of numbers>")
    val count = args.head.toInt; val list = args.tail.toList
    assert(count > 0, "Count needs to be bigger than 0")
    assert(list.size > 0, "List needs to have at least 1 element")
    println(count + ": " + list.mkString(",") + " -> " + dropN(count, list).toString)
  } 
}

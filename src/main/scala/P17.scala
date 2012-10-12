package org.tritsch.scala.ninetynine

/**
 * P17 - Split a list into two parts.
 */

object P17 {
  final def split(n: Int, l: List[Any]): (List[Any], List[Any]) = {
    (l.take(n), l.drop(n))  
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length > 1, "Need at least 2 parameter - Usage: P17 <N> <list of numbers>")
    val count = args.head.toInt; val list = args.tail.toList
    assert(count > 0, "Count needs to be bigger than 0")
    assert(list.size > 0, "List needs to have at least 1 element")
    println(count + ": " + list.mkString(",") + " -> " + split(count, list).toString)
  } 
}

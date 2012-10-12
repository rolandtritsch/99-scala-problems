package org.tritsch.scala.ninetynine

/**
 * P19 - Rotate a list N places to the left.
 */

object P19 {
  final def rotate(n: Int, l: List[Any]): List[Any] = {
    if(n >= 0) l.drop(n) ::: l.take(n)
    else l.drop(n + l.size) ::: l.take(n + l.size)
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length > 1, "Need at least 2 parameters - Usage: P18 <n> <list of numbers>")
    val count = args(0).toInt; val list = args.drop(1).toList
    assert(list.size > 0, "List needs to have at least 1 element")
    println(count + ": " + list.mkString(",") + " -> " + rotate(count, list).toString)
  } 
}

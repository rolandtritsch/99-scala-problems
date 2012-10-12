package org.tritsch.scala.ninetynine

/**
 * P18 - Extract a slice from a list.
 */

object P18 {
  final def slice(from: Int, to: Int, l: List[Any]): List[Any] = {
    l.slice(from, to)
  }

  final def slice2(from: Int, to: Int, l: List[Any]): List[Any] = {
    (for(i <- 0 until l.size; if(i >= from && i < to)) yield l(i)).toList
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length > 2, "Need at least 3 parameters - Usage: P18 <from> <to> <list of numbers>")
    val from = args(0).toInt; val to = args(1).toInt; val list = args.drop(2).toList
    assert(from > 0 && to > 0 && to > from, "from/to need to be bigger than 0 and to > from")
    assert(list.size > 0, "List needs to have at least 1 element")
    println(from + "/" +  to + ": " + list.mkString(",") + " -> " + slice(from, to, list).toString)
    println(from + "/" +  to + ": " + list.mkString(",") + " -> " + slice2(from, to, list).toString)
  } 
}

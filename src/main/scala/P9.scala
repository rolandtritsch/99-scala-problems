package org.tritsch.scala.ninetynine

/**
 * P9 - pack dublicates into sublists
 */

object P9 {
  final def pack(l: List[Any]): List[List[Any]] = {
      for(i <- l.distinct) yield l.filter(_ == i)
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length > 0, "Need at least 1 parameter - Usage: P9 <list with duplicates>")
    println(args.mkString(",") + " -> " + pack(args.toList).toString)
  } 
}

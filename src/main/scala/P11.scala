package org.tritsch.scala.nintynine

/**
 * P11 - decode a run-length encoded list
 */

object P11 {
  final def encode(l: List[Any]): List[(Int, Any)] = {
    (for(i <- l.distinct) yield l.count(_ == i)).zip(l.distinct)
  }

  final def decode(l: List[(Int, Any)]): List[Any] = {
    (for(i <- l; c = i._1; e = i._2) yield List.fill(c)(e)).flatten
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length > 0, "Need at least 1 parameter - Usage: P11 <list with duplicates>")
    println(args.mkString(",") + " -> " + encode(args.toList).toString)
    println(encode(args.toList).toString + " -> " + decode(encode(args.toList)).toString)
  } 
}

package org.tritsch.scala.nintynine

/**
 * P10 - run-length encoding of a list
 */

object P10 {
  final def encode(l: List[Any]): List[(Int, Any)] = {
    (for(i <- l.distinct) yield l.filter(_ == i).length).zip(l.distinct)
  }

  final def encode2(l: List[Any]): List[(Int, Any)] = {
    (for(i <- l.distinct) yield l.count(_ == i)).zip(l.distinct)
  }

  final def encode3(l: List[Any]): List[(Int, Any)] = {
    for(i <- l.distinct; c = l.count(_ == i)) yield (c, i)
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length > 0, "Need at least 1 parameter - Usage: P10 <list with duplicates>")
    println(args.mkString(",") + " -> " + encode(args.toList).toString)
    println(args.mkString(",") + " -> " + encode2(args.toList).toString)
    println(args.mkString(",") + " -> " + encode3(args.toList).toString)
  } 
}

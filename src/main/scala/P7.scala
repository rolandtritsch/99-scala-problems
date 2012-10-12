package org.tritsch.scala.ninetynine

/**
 * P7 - flatten a list of lists
 */

object P7 {
  final def flatten(l: List[List[Any]]): List[Any] = {
    l.flatten
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length > 0, "Need at least 1 parameter - Usage: P7 <list of lists>")
    val lol = for(l <- args.toList) yield l.split(",").toList
    println(args.mkString(":") + " -> " + lol.mkString(":") + " -> " + flatten(lol).mkString(":"))
  } 
}

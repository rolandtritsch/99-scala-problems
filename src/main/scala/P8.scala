package org.tritsch.scala.nintynine

/**
 * P8 - remove the duplicates from a list
 */

object P8 {
  final def compress(l: List[Any]): List[Any] = {
    l.distinct
  }

  final def compress2(l: List[Symbol]): List[Symbol] = {    
    l.toSet.toList.sortWith(_.toString < _.toString)
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length > 0, "Need at least 1 parameter - Usage: P8 <list of symbols>")
    val los = for(l <- args.toList) yield Symbol(l)
    println(args.mkString(":") + " -> " + los.mkString(":") + " -> " + compress(los).mkString(":"))
    println(args.mkString(":") + " -> " + los.mkString(":") + " -> " + compress2(los).mkString(":"))
  } 
}

package org.tritsch.scala.ninetynine

/**
 * P5 - reverse a list.
 */

object P5 {
  final def reverse(l: List[String]): List[String] = {
    l.reverse
  }

  final def reverse2(l: List[String]): List[String] = {
    if(l.length == 1) List(l.head)
    else reverse2(l.tail) ::: List(l.head)
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length > 0, "Need at least 1 parameter - Usage: P5 <list of something>")
    println(reverse(args.toList).mkString(","))
    println(reverse2(args.toList).mkString(","))
  } 
}

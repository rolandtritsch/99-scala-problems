package org.tritsch.scala.ninetynine

/**
 * P22 - Create a list containing all integers within a given range.
 */

object P22 {
  final def range(from: Int, to: Int): List[Int] = {
    Range(from, to+1).toList
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length == 2, "Needs 2 parameters - Usage: P22 <from> <to>")
    val from = args(0).toInt; val to = args(1).toInt
    assert(to > from, "<to> needs to be larger than <from>")
    println(from + "/" + to + ": " + range(from, to).toString)
  } 
}

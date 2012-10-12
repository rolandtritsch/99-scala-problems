package org.tritsch.scala.ninetynine

/**
 * P24 - Lotto: Draw N different random numbers from the set 1..M.
 */

object P24 {
  final def lotto(n: Int, rangeSize: Int): List[Any] = {
    P23.randomSelect2(n, Range(1, rangeSize + 1).toList)
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length == 2, "Needs 2 parameters - Usage: P24 <n> <rangeSize>")
    val n = args(0).toInt; val rangeSize = args(1).toInt
    assert(n > 0, "<n> needs to be bigger than 0")
    assert(rangeSize > 0, "<rangeSize> needs to be bigger than 0")
    println(n + "/" + rangeSize + " -> " + lotto(n, rangeSize).toString)
  } 
}

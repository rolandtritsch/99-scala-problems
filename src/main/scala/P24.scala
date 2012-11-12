package org.tritsch.scala.ninetynine

/**
 * P24 - Lotto: Draw N different random numbers from the set 1..M.
 */

object P24 {
  final def lotto(n: Int, rangeSize: Int): List[Any] = {
    P23.randomSelect2(n, Range(1, rangeSize + 1).toList)
  }
}

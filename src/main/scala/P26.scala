package org.tritsch.scala.ninetynine

/**
 * P26  - Generate the combinations of K distinct objects chosen from the N elements of a list.
 */

object P26 {
  /**
   * Iterate over the list and remove one element at a time.
   * Do this K times recursivly and keep track on the elements that you take out.
   * When you have recursed N times into it you need to iterate over everything that is left over.
   */
  final def combinations(k: Int, l: List[Any]): List[List[Any]] = {
    combinations(k, l, List[Any]())
  }

  final def combinations(k: Int, tail: List[Any], head: List[Any]): List[List[Any]] = {
    assert(k >= 1, "Opps ... k can't go below 1")
    assert(!tail.isEmpty, "Opps ... tail can never be empty")

    // Just build the combinations of the head and the remaining elements.
    if(k == 1) for(e <- tail) yield head :+ e
    // otherwise remove another element from whats left over, add it to the head and do it again.
    else {
      var result: List[List[Any]] = List()
      for(i <- 0 until tail.size) {
        result = result ++ combinations(k - 1, removeAtIndex(i, tail), head :+ tail(i))
      }
      result
    }
  }

  final def removeAtIndex(index: Int, l: List[Any]): List[Any] = {
    val s = l.splitAt(index)
    s._1 ::: s._2.drop(1)
  }

  final def fac(n: Int, k: Int): Int = if (k==1) n else n * fac(n-1, k-1)

  final def main(args: Array[String]): Unit = {
    assert(args.length >= 2, "Needs at least 2 parameter - Usage: P26 <k> <list of numbers>")

    val k = args(0).toInt; val l = args.drop(1).toList
    assert(k >= 1 && k<= l.size, "<k> needs to be k >= 1 && k<= l.size")
    assert(!l.isEmpty, "<l> cannot be empty")

    val result = combinations(k, l)
    println(k + ": " + l.mkString(",") + " -> " + result.size + "/" + result.toString)
    assert(result.size == fac(l.size, k), "Wrong number of combinations")

    val distinctResult = result.map(_.toSet).distinct
    println(k + ": " + l.mkString(",") + " -> " + distinctResult.size + "/" + distinctResult.toString)
  } 
}

// k = 2: 2 -> 4; 3 -> 6; 4 -> 12; 5 -> 20; 
// k = 3;         3 -> 6; 4 -> 24; 5 -> 60; 
// k = 4;                 4 -> 24; 5 -> 120;
// k = 5;                          5 -> 120; 

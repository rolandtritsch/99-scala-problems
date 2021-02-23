package org.tritsch.scala.ninetynine

/** P26b  - Just having fun with combinations and permutations
  */

object P26b {

  /** Given there are K lists with N elements. The list might be of equal size.
    * Initially K is hardcoded to be 3, but I am also looking for a general solution.
    */
  final def product3(
      l1: List[Any],
      l2: List[Any],
      l3: List[Any]
  ): List[List[Any]] = {
    for (e1 <- l1; e2 <- l2; e3 <- l3) yield List(e1, e2, e3)
  }

  final def product3(l: List[Any]): List[List[Any]] = product3(l, l, l)

  final def product3unique(l: List[Any]): List[List[Any]] = {
    for (e1 <- l; e2 <- l; e3 <- l; if (e1 != e2 && e1 != e3 && e2 != e3))
      yield List(e1, e2, e3)
  }

  final def product3distinct(l: List[Any]): List[Set[Any]] = {
    (for (e1 <- l; e2 <- l; e3 <- l; if (e1 != e2 && e1 != e3 && e2 != e3))
      yield Set(e1, e2, e3)).distinct
  }

  final def product3distinct2(l: List[Any]): List[List[Any]] = {
    assert(
      l.size >= 3,
      "K is hard coded to be three. Can't process anything smaller"
    )
    if (l.size == 3) List(l)
    else {
      for (firstElement <- 0 until l.size) {
        val withoutTheFirst = l.drop(firstElement + 1)
        for (secondElement <- 0 until withoutTheFirst.size) {
          val theRest = withoutTheFirst.drop(secondElement + 1)
          val result =
            for (i <- 0 until theRest.size)
              yield List(l(firstElement + 1), l(secondElement + 1), l(i))
        }
      }
      List()
    }
  }

  // builds the combinations, but makes sure that 2 out of the 3 are neighbors
  final def product3distinct3(l: List[Any]): List[List[Any]] = {
    assert(
      l.size >= 3,
      "K is hard coded to be three. Can't process anything smaller"
    )
    if (l.size == 3) List(l)
    else {
      val s = l.splitAt(3 - 1); val head = s._1; val tail = s._2
      (for (e <- tail) yield head :+ e) ::: product3distinct3(l.drop(1))
    }
  }

  final def fac(n: Int): Int = if (n == 0) 1 else n * fac(n - 1)
  final def fac(n: Int, k: Int): Int = if (k == 1) n else n * fac(n - 1, k - 1)

  final def sum(n: Int): Int = if (n == 0) 0 else n + sum(n - 1)
}

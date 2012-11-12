package org.tritsch.scala.ninetynine

/**
 * P20 - Remove the Kth element from a list (index on 0)
 */

object P20 {
  final def removeAt(n: Int, l: List[Any]): (List[Any], Any) = {
    assert(l.size == l.distinct.size, "This only works with no dublicates")
    (l.filterNot(l(n) == _), l(n))
  }

  final def removeAt2(n: Int, l: List[Any]): (List[Any], Any) = {
    (l.take(n) ::: l.drop(n+1), l(n))  
  }

  final def removeAt3(n: Int, l: List[Any]): (List[Any], Any) = {
    ((for(i <- l.indices; if(i != n)) yield l(i)).toList, l(n))
  }

  final def removeAt4(n: Int, l: List[Any]): (List[Any], Any) = {
    assert(l.size == l.distinct.size, "This only works with no dublicates")
    (l.diff(List(l(n))), l(n))
  }

  final def removeAt5(n: Int, l: List[Any]): (List[Any], Any) = {
    assert(l.size == l.distinct.size, "This only works with no dublicates")
    (l.map(e => if(l(n) != e) e), l(n))
  }
}

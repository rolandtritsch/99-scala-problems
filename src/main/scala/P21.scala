package org.tritsch.scala.ninetynine

/**
 * P21 - Insert an element at a given position into a list.
 */

object P21 {
  final def insertAt(e: Any, n: Int, l: List[Any]): List[Any] = {
    l.take(n) ++ List(e) ++ l.takeRight(l.size - n)
  }

  final def insertAt2(e: Any, n: Int, l: List[Any]): List[Any] = {
    (for(i <- Range(0, l.size)) yield if(i != n) List(l.apply(i)) else List(e, l.apply(i))).toList.flatten
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length > 2, "Need at least 3 parameters - Usage: P21 <n> <new> <list of numbers>")
    val n = args(0).toInt; val e = args(1).toInt; val list = args.drop(2).toList
    assert(n > 0 && n <= list.size, "N needs to be greater 0 and less than list.size")
    assert(list.size > 0, "List needs to have at least 1 element")
    println(n + "/" + e + ": " + list.mkString(",") + " -> " + insertAt(e, n, list).toString)
    println(n + "/" + e + ": " + list.mkString(",") + " -> " + insertAt2(e, n, list).toString)
  } 
}

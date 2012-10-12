package org.tritsch.scala.ninetynine

/**
 * P26b  - Just having fun with combinations and permutations
 */

object P26b {
  /**
   * Given there are K lists with N elements. The list might be of equal size.
   * Initially K is hardcoded to be 3, but I am also looking for a general solution.
   */
  final def product3(l1: List[Any], l2: List[Any], l3: List[Any]): List[List[Any]] = {
    for(e1 <- l1; e2 <- l2; e3 <- l3) yield List(e1, e2, e3) 
  }

  final def product3(l: List[Any]): List[List[Any]] = product3(l, l, l) 

  final def product3unique(l: List[Any]): List[List[Any]] = {
    for(e1 <- l; e2 <- l; e3 <- l; if(e1 != e2 && e1 != e3 && e2 != e3)) yield List(e1, e2, e3) 
  }

  final def product3distinct(l: List[Any]): List[Set[Any]] = {
    (for(e1 <- l; e2 <- l; e3 <- l; if(e1 != e2 && e1 != e3 && e2 != e3)) yield Set(e1, e2, e3)).distinct
  }

  final def product3distinct2(l: List[Any]): List[List[Any]] = {
    assert(l.size >= 3, "K is hard coded to be three. Can't process anything smaller")
    if(l.size == 3) List(l)
    else {
      for(firstElement <- 0 until l.size) {
	println(firstElement + "/" + l.toString)
	val withoutTheFirst = l.drop(firstElement+1)
	println(withoutTheFirst.toString)
	for(secondElement <- 0 until withoutTheFirst.size) {
	  println(secondElement + "/" + withoutTheFirst.toString)
	  val theRest = withoutTheFirst.drop(secondElement+1)
	  println(theRest.toString)
	  val result = for(i <- 0 until theRest.size) yield List(l(firstElement+1), l(secondElement+1), l(i))
	  println("result: " + result.toString)
	}
      }
      List()
    }
  }

  // builds the combinations, but makes sure that 2 out of the 3 are neighbors
  final def product3distinct3(l: List[Any]): List[List[Any]] = {
    assert(l.size >= 3, "K is hard coded to be three. Can't process anything smaller")
    if(l.size == 3) List(l)
    else {
      val s = l.splitAt(3-1); val head = s._1; val tail = s._2
      (for(e <- tail) yield head :+ e) ::: product3distinct3(l.drop(1))
    }    
  }

  final def fac(n: Int): Int = if(n==0) 1 else n * fac(n-1)
  final def fac(n: Int, k: Int): Int = if(k==1) n else n * fac(n-1, k-1)

  final def sum(n: Int): Int = if(n == 0) 0 else n + sum(n-1)

  final def main(args: Array[String]): Unit = {
    assert(args.isEmpty, "Expects no parameters - Usage: P26b")

    // Three list of letters. Lets build all possible 3 letter words from it. 
    val l1 = List("A", "B")
    val l2 = List("x", "y", "z")
    val l3 = List("1", "2")
    val result = product3(l1, l2, l3)
    println(result.size + "/" + result.toString)
    assert(result.size == l1.size * l2.size * l3.size, "Wrong number of combinations")

    println("-----------------")

    // Build all possible combinations of throws for a set of 3 dices, means we are combining
    // 3 lists with 6 numbers each. 
    val dice = Range(1, 7).toList
    val result2 = product3(dice)
    println(result2.size + "/" + result2.toString)
    assert(result2.size == scala.math.pow(dice.size, 3), "Wrong number of combinations")

    println("-----------------")

    // Take 3 lists with N cities in it each. Build all possible combinations of trips between 
    // these cities. Do this for N in 1..5.
    for(n <- 1 to 5) {
      val l1 = (for(i <- 1 to n) yield "FRA-" + i).toList
      val l2 = (for(i <- 1 to n) yield "DUB-" + i).toList
      val l3 = (for(i <- 1 to n) yield "ATH-" + i).toList
      val result = product3(l1, l2, l3)
      println(n + "/" + result.size + "/" + result.toString)
      assert(result.size == scala.math.pow(l1.size, 3), "Wrong number of combinations")
    }

    println("-----------------")

    // Take a list of N cities and build all 3 hop trips from it. Do this for N 1..5.
    for(n <- 1 to 5) {
      val cities = (for(i <- 1 to n) yield "FRA-" + i).toList
      val result = product3(cities)
      println(n + "/" + result.size + "/" + result.toString)
      assert(result.size == scala.math.pow(cities.size, 3), "Wrong number of combinations")
    }

    println("-----------------")

    // Take a list of N cities and build all 3 hop trips from it, but make sure you do not visit
    // a city twice on a trip. Do this for N 1..5.
    for(n <- 1 to 5) {
      val cities = (for(i <- 1 to n) yield "DUB-" + i).toList
      val result = product3unique(cities)
      println(n + "/" + result.size + "/" + result.toString)

      /**
       * The assertion is (take all combinations n*n*n) - (the number of combinations that have a city twice or more)
       */
      assert(result.size == scala.math.pow(cities.size, 3) - (cities.size + (sum(3-1) * (cities.size-1)) * cities.size), "Wrong number of combinations")
    }

    println("-----------------")

    // Take a list of N cities and build all 3 hop trips from it, but make sure you do not visit
    // a city twice on a trip and do not care about the direction/order of the trip, 123 == 321 == 132 == ...
    // Do this for N 1..10. This is the binominal coefficient for K over N (distinctly combine K elements out of 
    // a group of N elements)
    for(n <- 3 to 6) {
      val cities = (for(i <- 1 to n) yield "DUB-" + i).toList

      val result = product3distinct(cities)
      // println(n + "/" + result.size)
      println(n + "/" + result.size + "/" + result.toString)
      //assert(result.size == scala.math.pow(cities.size, 3) - (cities.size + (sum(3-1) * (cities.size-1)) * cities.size) - (???), "Wrong number of combinations")

      val result2 = product3distinct2(cities)
      // println(n + "/" + result2.size)
      println(n + "/" + result2.size + "/" + result2.toString)
      // TODO assert(result2.size == (???), "Wrong number of combinations")

      val result3 = product3distinct3(cities)
      println(n + "/" + result3.size + "/" + result3.toString)
      // TODO assert(result3.size == (???), "Wrong number of combinations")
    }
  }
}

package org.tritsch.scala.ninetynine

import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._

class PSpec extends AnyFlatSpec with BeforeAndAfter with should.Matchers {
  before {}

  "P1" should "return the last element of the list" in {
    assert(P1.last(List("first", "last")) === "last")
  }

  "P2" should "return the last but one element of the list" in {
    assert(P2.penultimate(List("first", "middle", "last")) == "middle")
  }

  "P3" should "find Nth element of a list" in {
    P3.nth(2, List("first", "middle", "last")) should be("last")
  }

  "P4" should "find the number of elements in the list" in {
    P4.length(List("first", "middle", "last")) should equal(3)
  }

  "P5" should "reverse a list" in {
    val original = List("This", "is", "a", "test")
    val reverse = List("test", "a", "is", "This")

    P5.reverse(original) should equal(reverse)
    P5.reverse(reverse) should equal(original)

    val again = P5.reverse(original)
    P5.reverse(again) should equal(original)
  }

  "P5-extended" should "reverse a list" taggedAs (Tag("ExtendedTest")) in {
    val original = List("This", "is", "a", "test")
    val reverse = List("test", "a", "is", "This")

    P5.reverse2(original) should equal(reverse)
    P5.reverse2(reverse) should equal(original)

    val again = P5.reverse2(original)
    P5.reverse2(again) should equal(original)
  }

  "P6" should "find out if a word is a palindrom" in {
    assert(P6.isPalindrom("racecar"))
    assert(P6.isPalindrom("hannah"))
    assert(P6.isPalindrom("121"))
    assert(P6.isPalindrom("1221"))
    assert(P6.isPalindrom("1"))
    assert(P6.isPalindrom(""))
    assert(!P6.isPalindrom("xhannah"))
  }

  "P7" should "flatten a list of lists" in {
    P7.flatten(List(List(1, 1), 2, List(3, List(5, 8)))) should equal(
      List(1, 1, 2, 3, 5, 8)
    )
  }

  "P8" should "remove the duplicates from a list" ignore {
    // P8.compress(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")) should equal (List("a", "b", "c", "a", "d", "e"))
    P8.compress(
      List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")
    ) should equal(List("a", "b", "c", "d", "e"))
  }

  "P8-extended" should "remove the duplicates from a list" taggedAs (Tag(
    "ExtendedTest"
  )) ignore {
    // P8.compress2(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")) should equal (List("a", "b", "c", "a", "d", "e"))
    P8.compress2(
      List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")
    ) should equal(List("a", "b", "c", "d", "e"))
  }

  "P9" should "pack consecutive duplicates of list elements into sublists" ignore {

    /**    P9.pack(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")) should equal (
      *      List(List("a", "a", "a", "a"), List("b"), List("c", "c"), List("a", "a"), List("d"), List("e", "e", "e", "e"))
      *    )
      */
    P9.pack(
      List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")
    ) should equal(
      List(
        List("a", "a", "a", "a", "a", "a"),
        List("b"),
        List("c", "c"),
        List("d"),
        List("e", "e", "e", "e")
      )
    )
  }

  "P10" should "do a run-length encoding of a list" ignore {

    /**    P10.encode(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")) should equal (
      *      List((4,"a"), (1,"b"), (2,"c"), (2,"a"), (1,"d"), (4,"e"))
      *    )
      */
    P10.encode(
      List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")
    ) should equal(
      List((6, "a"), (1, "b"), (2, "c"), (1, "d"), (4, "e"))
    )
  }

  "P11" should "run a modified run-length encoding" ignore {
    P11.encodeModified(
      List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")
    ) should equal(
      List((4, "a"), "b", (2, "c"), (2, "a"), "d", (4, "e"))
    )
  }

  "P12" should "decode a run-length encoded list" in {
    val encoded =
      List((4, "a"), (1, "b"), (2, "c"), (2, "a"), (1, "d"), (4, "e"))
    val decoded =
      List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")

    P12.decode(encoded) should equal(decoded)
  }

  "P12-extended" should "decode a run-length encoded list" taggedAs (Tag(
    "ExtendedTest"
  )) ignore {
    val encoded =
      List((4, "a"), (1, "b"), (2, "c"), (2, "a"), (1, "d"), (4, "e"))
    val decoded =
      List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")

    P12.encode(decoded) should equal(encoded)

    val again = P12.encode(decoded)
    P12.decode(again) should equal(decoded)
  }

  "P13" should "do a run-length encoding of a list (direct solution)" ignore {
    val encoded =
      List((4, "a"), (1, "b"), (2, "c"), (2, "a"), (1, "d"), (4, "e"))
    val decoded =
      List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")

    P13.encodeDirect(decoded) should equal(encoded)
  }

  "P14" should "duplicate the elements of a list" in {
    P14.duplicate(List("a", "b", "c", "c", "d")) should equal(
      List("a", "a", "b", "b", "c", "c", "c", "c", "d", "d")
    )
  }

  "P15" should "duplicate the elements of a list a given number of times" in {
    P15.duplicateN(3, List("a", "b", "c", "c", "d")) should equal(
      List(
        "a",
        "a",
        "a",
        "b",
        "b",
        "b",
        "c",
        "c",
        "c",
        "c",
        "c",
        "c",
        "d",
        "d",
        "d"
      )
    )
  }

  "P16" should "drop every Nth element from a list" in {
    P16.drop(
      3,
      List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k")
    ) should equal(
      List("a", "b", "d", "e", "g", "h", "j", "k")
    )
  }

  "P17" should "split a list into two parts" in {
    P17.split(
      3,
      List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k")
    ) should equal(
      (List("a", "b", "c"), List("d", "e", "f", "g", "h", "i", "j", "k"))
    )
  }

  "P18" should "extract a slice from a list" in {
    P18.slice(
      3,
      7,
      List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k")
    ) should be(
      List("d", "e", "f", "g")
    )
  }

  "P19" should "rotate a list N places to the left" in {
    P19.rotate(
      3,
      List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k")
    ) should be(
      List("d", "e", "f", "g", "h", "i", "j", "k", "a", "b", "c")
    )
  }

  "P20" should "remove the Kth element from a list" in {
    val input = List("a", "b", "c", "d")
    val result = (List("a", "c", "d"), "b")

    P20.removeAt(1, input) should equal(result)
  }

  "P20-extended" should "remove the Kth element from a list" taggedAs (Tag(
    "Extended"
  )) in {
    val input = List("a", "b", "c", "d")
    val result = (List("a", "c", "d"), "b")

    P20.removeAt2(1, input) should equal(result)
    P20.removeAt3(1, input) should equal(result)
    P20.removeAt4(1, input) should equal(result)
    // P20.removeAt5(1, input) should equal (result)
  }

  "P21" should "insert an element at a given position into a list" in {
    val input = List("a", "b", "c", "d")
    val result = List("a", "new", "b", "c", "d")

    P21.insertAt("new", 1, input) should equal(result)
    P21.insertAt2("new", 1, input) should equal(result)
  }

  "P22" should "create a list containing all integers within a given range" in {
    P22.range(4, 9) should equal(List(4, 5, 6, 7, 8, 9))
  }

  "P23" should "extract a given number of randomly selected elements from a list" in {
    P23.randomSelect(
      3,
      List("a", "b", "c", "d", "f", "g", "h")
    ) should have size (3)
  }

  "P23-extended" should "extract a given number of randomly selected elements from a list" taggedAs (Tag(
    "ExtendedTest"
  )) in {
    P23.randomSelect2(
      3,
      List("a", "b", "c", "d", "f", "g", "h")
    ) should have size (3)
  }

  "P24" should "draw N different random numbers from the set 1..M" in {
    P24.lotto(6, 49) should have size (6)
  }

  "P25" should "generate a random permutation of the elements of a list" in {
    P25.randomPermute(List("a", "b", "c", "d", "e", "f")) should have size (6)
  }

  "P26" should "generate the combinations of K distinct objects chosen from the N elements of a list" in {
    P26.combinations(3, List("a", "b", "c", "d", "e")) should have size (60)
  }

  "P27" should "group the elements of a set into disjoint subsets" ignore {
    P27.group3(
      List(
        "Aldo",
        "Beat",
        "Carla",
        "David",
        "Evi",
        "Flip",
        "Gary",
        "Hugo",
        "Ida"
      )
    ) should equal(
      List(
        List(
          List("Aldo", "Beat"),
          List("Carla", "David"),
          List("Evi", "Flip", "Gary", "Hugo", "Ida")
        )
      )
    )

    P27.group(
      List(2, 2, 5),
      List(
        "Aldo",
        "Beat",
        "Carla",
        "David",
        "Evi",
        "Flip",
        "Gary",
        "Hugo",
        "Ida"
      )
    ) should equal(
      List(
        List(
          List("Aldo", "Beat"),
          List("Carla", "David"),
          List("Evi", "Flip", "Gary", "Hugo", "Ida")
        )
      )
    )
  }

  "P28" should "sort a list of lists according to length of sublists" ignore {
    P28.lsort(
      List(
        List("a", "b", "c"),
        List("d", "e"),
        List("f", "g", "h"),
        List("d", "e"),
        List("i", "j", "k", "l"),
        List("m", "n"),
        List("o")
      )
    ) should equal(
      List(
        List("o"),
        List("d", "e"),
        List("d", "e"),
        List("m", "n"),
        List("a", "b", "c"),
        List("f", "g", "h")
      )
    )

    P28.lsortFreq(
      List(
        List("a", "b", "c"),
        List("d", "e"),
        List("f", "g", "h"),
        List("d", "e"),
        List("i", "j", "k", "l"),
        List("m", "n")
      )
    ) should equal(
      List(
        List("i", "j", "k", "l"),
        List("o"),
        List("a", "b", "c"),
        List("f", "g", "h"),
        List("d", "e")
      )
    )
  }

  after {}
}

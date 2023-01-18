package com.rockthejvm

import scala.::

object _2_FunctionalProgramming extends App {


  // Scala is OO
  class Person(name: String) {
    def apply(age: Int): Unit = println(s"I have aged $age years")

    def apply(lastName: String): Unit = println(s"Last Name is: $lastName")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // invoking bob as a function
  bob("Dharmasiri")

  /**
   * Scala runs on the JVM.
   * In Functional Programming, functions must be first class citizens:
   *  - Compose Functions
   *  - Pass functions as args
   *  - Return functions as result
   *    JVM was not originally built for functional programming
   *
   * Conclusion: Scala built FunctionX
   */
  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }

  simpleIncrementer.apply(23)
  simpleIncrementer(23)

  /// ALL Scala Functions are instances for these Function_X Types
  // Function1, Function2, ... Function22

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  stringConcatenator("I Love", "Scala")

  // Syntax Sugars
  val doubler: Function1[Int, Int] = (x: Int) => 2 * x
  val doubler2: Int => Int = (x: Int) => 2 * x
  doubler(4)

  // Higher Order functions are those that take functions as arguments and/or return functions as results
  val aMappedist = List(1, 2, 3).map(x => x + 1) // map is a higher order function
  println(aMappedist)

  val aFlatMapped = List(1, 2, 3).flatMap(x => List(x, 2 * x))
  val aFlatMapped2 = List(1, 2, 3).flatMap { x =>
    List(x, 2 * x)
  }
  println(aFlatMapped)

  val aFilteredList = List(1,2,3,4,5).filter(x => x > 3)
  println(aFilteredList)
  val aFilteredList2 = List(1, 2, 3, 4, 5).filter(_ <= 3)

  // all pairs between the numbers 1,2,3 and the letters 'a', 'b', 'c'
  val allPairs = List(1,2,3).flatMap(x => List('a', 'b', 'c').map(y => s"$x$y"))
  println(allPairs)

  // for comprehensions
  val alternativePairs = for {
    number <- List(1,2,3)
    letter <- List('a', 'b', 'c')
  } yield s"$number - $letter" // equivalent to the map / flatMap chain above

  /**
   * Scala Collections
   */
  // lists
  val aList = List(1, 2, 3, 4, 5)
  val firstElement = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList
  println(aPrependedList)
  val anExtendedList = 0 +: aList :+ 6
  println(anExtendedList)

  // sequences
  val aSequence: Seq[Int] = Seq(1, 2, 3) // Seq.apply()
  // Seq is a trait. apply method will return a derived type for Seq
  val accessedElement = aSequence.apply(1) // element @ index 1
  println(accessedElement)

  // vectors - a fast sequence implementation
  val aVector = Vector(1,2,3,4,5)

  // sets
  val aSet = Set(1,2,3,4,1,2)
  println(aSet.contains(5))
  val anAddedSet = aSet + 5
  val aRemovedSet = aSet - 3

  // ranges
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(x => x * 2).toList // List(2,4,6..., 2000)

  // tuples
  val aTuple = ("Bon Jovi", "Rock", 1982)

  // maps
  val aPhoneBook: Map[String, Int] = Map(
    ("Daniel", 1234),
    ("Jane" -> 2423)
  )


}

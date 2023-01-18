package com.rockthejvm

object _4_PatternMatching extends App {

  // switch statement
  val anInteger = 55
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case _ => anInteger + "th"
  }
  println(order)

  // Pattern Match is an expression

  case class Person(name: String, age: Int)
  val bob = Person("Bob", 43) // Person.apply - companion with apply method

  val personGreeting = bob match {
    // matches the person structure
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "Something Else"
  }

  println(personGreeting)

  // Deconstructing tuples
  val aTuple = ("Bon Jovi", "Rock")
  val bandDescriptions = aTuple match {
    case (band, genre) => s"$band belongs to $genre"
    case _ => "Who is this"
  }

  // Decomposing Lists
  val aList = List(1,2,3)
  val listDescription = aList match {
    case List(_,2,_) => "List Contains 2"
    case _ => "Unknown list" // without _ case, it will throw an exception (Match Error)
  }

  // NOTE: Pattern Matching will try all cases in sequence

}

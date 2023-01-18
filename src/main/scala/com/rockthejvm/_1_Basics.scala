package com.rockthejvm

/**
 * Extending app means that the code becomes executable
 */
object _1_Basics extends App {

  // defining a value
  // val is constant - like in kotlin
  val meaningOfLife: Int = 42
  val aBoolean = false // type is inferred here
  // types: Int, Boolean, Char, Double, Float, String

  val aString = "I Love Scala"
  val aComposedString = "I" + " " + "love" + " " + "scala"
  // like in groovy
  val anInterpolatedString = s"The Meaning of Life $meaningOfLife"

  // expressions = structures that can be reduced to a value
  val anExpression = 2 + 3
  // In Scala, we think from values not by instructions
  val ifExpressions = if (meaningOfLife > 43) 56 else 999

  // Chained expression became a single expression
  val chainedIfExpression = {
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -1
    else 0
  }

  // code blocks
  val aCodeBlock = {
    // definitions
    val aLocalValue = 67
    aLocalValue + 3 // value of the entire block is the last expression of the code block
  }

  // define  a function
  def myFunction(x: Int, y: String): String = y + " " + x

  def myFunction2(x: Int, y: String): String = {
    y + " " + x
  }

  // recursive functions
  def factorial(n: Int): Int =
    if(n <= 1) 1
    else n * factorial(n - 1)

  // In scala, we don't use loops or iteration, we use RECURSION!!! Variables, iteration, loops are HEAVILY frowned upon.
  // Always think about functions and recursion

  // The Unit Type = no meaningful value  == equivalent of "void" in other languages
  // type of SIDE EFFECTs (Side Effects are very important concept in functional programming and in scala)
  println("I love scala")

  def myUnitReturningFunction(): Unit = println("No Return")
  val a = myUnitReturningFunction()
  println(a)

}

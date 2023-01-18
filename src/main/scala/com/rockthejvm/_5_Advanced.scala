package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object _5_Advanced extends App {

  /**
   * Lazy Evaluation
   */
  lazy val aLazyValue = 2
  lazy val aLazyValueWithSideEffect = {
    println("Lazy")
    43
  }
  val eager = aLazyValueWithSideEffect + 1
  // useful in infinite collections

  /**
   * pseudo-collections
   */
  // Option
  def methodWhichCanReturnNull(): String = "Hello Scala"

  if (methodWhichCanReturnNull() == null) {} // defensive code /...not need in scala
  val anOption = Option(methodWhichCanReturnNull()) // Some("Hello Scala") OR None if it was null
  // option = "Collection with atmost one element"

  val stringProcessed = anOption match {
    case Some(string) => s"I have obtained valid String $string"
    case _ => "I obtained nothing"
  }
  // Option -> map, flatMap, filter

  // Try collection
  def methodWhichCanThrowException(): String = throw new RuntimeException

  try {
    methodWhichCanThrowException()
  } catch {
    case e: Exception => "Defensive Code"
  }

  val aTry = Try(methodWhichCanThrowException()) match {
    case Success(string) => "Great"
    case Failure(exception) => "An exception"
  }


  /**
   * Evaluate something on another thread - AKA - Asynchronous Programming
   */
  val aFuture = Future({
    println("Loading")
    Thread.sleep(1000)
    println("I have computed a value")
    67
  })
  // future is a collection which contains a value when it's evaluated
  // future is composable with map, flatMap and filter

  // Future, Option and Try are called Monads in Functional Programming

  /**
   *
   *  Implicit Basics
   */
  // 1: Implicit Arguments
  def aMethodWithImplictArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt: Int = 46
  println(aMethodWithImplictArgs)

  // 2: Implicit conversions
  implicit class MyRichInteger(n: Int){
    def isEven() = n % 2
  }

  println(23.isEven()) // Compiler does new MyRichInteger(23).isEven() -- DANGEROUS!!!!

}

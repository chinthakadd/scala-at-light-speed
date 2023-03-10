package com.rockthejvm

/**
 *
 */
object _3_ObjectOrientation extends App {

  // class and instance
  class Animal {
    val age: Int = 0

    def eat() = println("I am eating")
  }

  val anAnimal = new Animal

  // inheritance
  class Dog(name: String) extends Animal // constructor definition

  val aDog = new Dog("Lassie")

  // constructor arguments are NOT fields
  // aDog.name - not compiling
  class AnotherDog(val name: String) extends Animal // constructor definition

  new AnotherDog("name").name // this works


  // Subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat()

  // Abstract class
  abstract class WalkingAnimal {
    val hasLegs = true

    def walk(): Unit // abstract
  }

  // NOTE: All fields by default are public. Can be restricted by using private, or protected

  // Interfaces
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait LivesInWater {}

  // Multi-trait mixing
  class Crocodile extends Animal with Carnivore with LivesInWater {
    override def eat(animal: Animal): Unit = println(s"eat $animal")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation = object method argument, only available for methods with ONE argument

  trait Philosoper {
    def ?!(thought: String): Unit // valid method name. Scala is very permissive of names used
  }

  class Fox extends Philosoper {
    override def ?!(thought: String): Unit = println(s"Thinking of: $thought")
  }

  val fox = new Fox
  fox ?! "How to Eat This Grape Bunch"

  // So - Operators in Scala is actually a method
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // + as a method

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println(s"Eat $animal like a Dinosaur")
  }

  // singleton object
  object MySingleton // the only instance of MySingleton type
  {
    val mySpecialValue = 4232
    def mySpecialMethod(): Int = 1212

    // special method - apply
    def apply(x: Int): Int = x + 1
  }
  MySingleton.mySpecialMethod()
  MySingleton.apply(12)
  MySingleton(65) // Interpreted by compiler as a apply call. Highly useful in functional programming

  object Animal { // companion object (for Animal Class)
    // companions can access each other's private fields or methods
    // Singleton Animal and instances of Animal class are DIFFERENT things
    val canLiveIndefinitely = false
  }
  // usage of companion objects
  val animalsCanLiveForever = Animal.canLiveIndefinitely // Similar to static values in Java (Kotlin uses the same)

  /**
   * Case Classes = lightweight data structures with some boilerplate
   * Compiler generates
   * - sensible equals and hashcode
   * - serialization
   * - companion with apply
   * - pattern matching
   */
  case class Person(name: String, age: Int)

  // new is dropped coz apply() is generated by companion in case class
  val bob = Person("Bob", 54) /// Person.apply

  // exceptions
  try {
    // code that can throw
    val x: String = null
    println(x.length)
  } catch {
    case e: Exception => "Some Faulty Error Message"
  } finally {
    println("Finally No Matter what")
  }

  // generics
  abstract class MyList[T] {
    val head: T
    val tail: MyList[T]
  }

  // using a generic with a concrete type
  val aList: List[Int] = List(1,2,3) // List.apply
  val first = aList.head
  val rest = aList.tail
  val aStringList = List("Hello", "World")
  val firstString = aStringList.head

  // Point #1: In Scala, we usually operate with IMMUTABLE values/objects
  // any mutation would result in another instance
  val reversedList = aList.reverse // returns a new list
  // This is beneficial in 2 ways:
  // 1. works miracles in multi-threaded / distributed env
  // 2. helps making sense of the code - reasoning about (I have come across this concept in functional/reactive prog)

  // Point #2: Scala is closest to the OO ideal

  // What is App? it has a main method already defined. Which executes the body of the object.
}

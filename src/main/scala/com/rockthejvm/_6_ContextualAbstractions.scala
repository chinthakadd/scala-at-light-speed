package com.rockthejvm

object _6_ContextualAbstractions {

  /**
   * 1 - context parameters/ arguments
   */
  val aList = List(2, 1, 3, 4)
  val anOrderedList = aList.sorted // sorted(ordering)

  // Ordering
  // given is magical. it becomes the default for sorted method. This is called a contextual argument for sorted method
  // above.
  given descendingOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _)

  // analogous to an implicit val. implicit will eventually be deprecated given instances will take over

  trait Combinator[A] {
    def combine(x: A, y: A): A
  }

  def combineAll[A](list: List[A], combinator: Combinator[A]): A = ???

  // Contextual argument "using"
  def combineAll2[A](list: List[A])(using combinator: Combinator[A]): A =
    list.reduce((a, b) => combinator.combine(a, b))

  given intCombinator: Combinator[Int] = new Combinator[Int] {
    override def combine(x: Int, y: Int): Int = x + y
  }

  // using intCombinator as the contextual combinator
  val theSum = combineAll2(aList)
  // Where does compiler look for given places
  // - local scope
  // - imported scope
  // - the companions of all the types involved in the call
  //    - companion of List
  //    - the companion of Int

  // context bounds
  def combineAll_v2[A](list: List[A])(using Combinator[A]): A = ???

  def combineAll_v3[A: Combinator](list: List[A]): A = ???

  /**
   * where context args are useful?
   * - type classes
   * - dependency injection
   * - context - dependent functionality
   * - type-level programming
   */

  /**
   * 2 - Extension Methods
   */
  case class Person(name: String) {
    def greet(): String = s"Hi My Name is $name"
  }

  extension (string: String)
    def greet(): String = new Person(string).greet()

  val chinthakaGreeting = "Daniel".greet()

  def main(args: Array[String]): Unit = {
    println(anOrderedList)
    println(theSum)
  }

}

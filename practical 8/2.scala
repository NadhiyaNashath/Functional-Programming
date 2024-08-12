import scala.io.StdIn._

object NumberCategorizer {

  def main(args: Array[String]): Unit = {
    println("Enter an integer:")
    val input = readInt()

    val isMultipleOfThree: Int => Boolean = _ % 3 == 0
    val isMultipleOfFive: Int => Boolean = _ % 5 == 0

    val message = (input match {
      case _ if isMultipleOfThree(input) && isMultipleOfFive(input) => "Multiple of Both Three and Five"
      case _ if isMultipleOfThree(input) => "Multiple of Three"
      case _ if isMultipleOfFive(input) => "Multiple of Five"
      case _ => "Not a Multiple of Three or Five"
    })

    println(message)
  }
}

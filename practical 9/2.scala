import scala.io.StdIn._

object NumberApp {

  def main(args: Array[String]): Unit = {

    println("Please enter an integer:")
    val input: Int = readInt()

    val classifyNumber: Int => String = (num: Int) => num match {
      case n if n < 0 => "The number is negative"
      case n if n == 0 => "The number is zero"
      case n if n % 2 == 0 => "The number is even"
      case _ => "The number is odd"
    }
    
    println(classifyNumber(input))
  }
}

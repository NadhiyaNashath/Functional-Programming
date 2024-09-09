import scala.io.StdIn.readInt

class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  val numerator: Int = n
  val denominator: Int = d

  def neg: Rational = new Rational(-numerator, denominator)

  override def toString: String = s"$numerator/$denominator"
}

object RationalApp extends App {

  def getValidDenominator(): Int = {
    var denominator: Int = 0
    while (denominator == 0) {
      println("Enter the denominator (cannot be zero):")
      denominator = readInt()
      if (denominator == 0) {
        println("Invalid input. Denominator cannot be zero. Please try again.")
      }
    }
    denominator
  }

  println("Enter the numerator:")
  val numerator = readInt()
  val denominator = getValidDenominator()

  val x = new Rational(numerator, denominator)
  println(s"Rational number : $x")
  println(s"Negation : ${x.neg}")
}

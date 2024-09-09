
class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be 0")
  
  private val gcdValue = gcd(n.abs, d.abs) 
  val numer: Int = n / gcdValue
  val denom: Int = d / gcdValue


  def subtract(that: Rational): Rational = {
    val newNumer = this.numer * that.denom - that.numer * this.denom
    val newDenom = this.denom * that.denom
    new Rational(newNumer, newDenom)
  }

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  override def toString: String = s"$numer/$denom"
}


object RationalSubtractionTest extends App {
  val x = new Rational(3, 4)
  val y = new Rational(5, 8)
  val z = new Rational(2, 7)

  val result = y.subtract(z)

  println(s"y - z = $result")
}

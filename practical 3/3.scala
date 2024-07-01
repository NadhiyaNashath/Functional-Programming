def average(num1: Int, num2: Int): Double = {
  val mean = (num1 + num2) / 2.0
  BigDecimal(mean).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
}

def main(input: Array[String]): Unit = {

    val num1 = 5
    val num2 = 10
    val result = average(num1, num2)

    println(result)
}

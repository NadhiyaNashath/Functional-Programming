object calculateSquareApp {

  def calculateSquare(numbers: List[Int]): List[Int] = {
    numbers.map(num => num * num)
  }

  def main(args: Array[String]): Unit = {
    val nums = List(1, 2, 3, 4, 5)
    val squaredNums = calculateSquare(nums)
    println(squaredNums)
  }
}

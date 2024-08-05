object filterPrimeApp {

  def isPrime(num: Int): Boolean = {
    if (num <= 1) false
    else if (num == 2) true
    else !(2 until num).exists(n => num % n == 0)
  }

  def filterPrime(numbers: List[Int]): List[Int] = {
    numbers.filter(num => isPrime(num))
  }

  def main(args: Array[String]): Unit = {
    val nums = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val primeNums = filterPrime(nums)
    println(primeNums)
  }
}

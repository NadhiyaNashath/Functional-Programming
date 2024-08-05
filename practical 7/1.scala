object filterEvenNumberApp {

    def filterEvenNumbers(numbers: List[Int]): List[Int] = {

    numbers.filter(num => num % 2 == 0)

    }

    def main(args: Array[String]):Unit = {

        val nums = List(1, 2, 3, 4, 5, 6)
        val evenNums = filterEvenNumbers(nums)
        println(evenNums)

    }
}

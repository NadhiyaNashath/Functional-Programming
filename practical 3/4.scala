import scala.io.StdIn

def sum(numbers: List[Int]): Int = {
  numbers.filter(_ % 2 == 0).sum
}

def main(input: Array[String]): Unit = {

    println("Enter the number of integers : ")
    val number = StdIn.readInt()
    val inputNumbers = (1 to number).map { _ =>
        println("Enter an integer: ")
        StdIn.readInt()
    }.toList

    val result = sum(inputNumbers)
    println(s"The total is : $result")
}

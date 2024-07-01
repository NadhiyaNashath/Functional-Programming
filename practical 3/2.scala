import scala.io.StdIn

def stringLength(strings: List[String]): List[String] = {
  strings.filter(_.length > 5)
}

def main(input: Array[String]): Unit = {

    println("Enter number of strings to be entered : ")
    val number = StdIn.readInt()
    val inputStrings = (1 to number).map { _ =>
      println("Enter a string : ")
      StdIn.readLine()
    }.toList
    val filteredStrings = stringLength(inputStrings)

    println(filteredStrings)
}

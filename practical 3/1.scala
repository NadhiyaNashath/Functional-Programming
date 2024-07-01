import scala.io.StdIn

def reverseString(input: String): String = {
    if (input.length <= 1)
        input
    else {
        reverseString(input.tail) + input.head
    }
}

def main(input: Array[String]): Unit = {
    println("Enter a string :")
    val str = StdIn.readLine()
    val reversedStr = reverseString(str)
    println(s"The reversed string of '$str' is '$reversedStr'")
}

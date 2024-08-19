import scala.io.StdIn._

object InterestCalculatorApp {

  def main(args: Array[String]): Unit = {

    val calculateInterest: Double => Double = (depositAmount: Double) => {
      if (depositAmount <= 20000) {
        depositAmount * 0.02
      } else if (depositAmount <= 200000) {
        depositAmount * 0.04
      } else if (depositAmount <= 2000000) {
        depositAmount * 0.035
      } else {
        depositAmount * 0.065
      }
    }

    println("Enter the deposit amount : ")
    val depositAmount = readDouble()
    
    val interest = calculateInterest(depositAmount)
    println(s"Deposit Amount: Rs. $depositAmount, Interest Earned: Rs. $interest")
  }
}

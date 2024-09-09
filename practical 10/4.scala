class Account(val accountHolder: String, private var balance: Double) {

  
  def getBalance: Double = balance
  def deposit(amount: Double): Unit = {
    if (amount > 0) balance += amount
  }

  
  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) balance -= amount
  }

  def applyInterest(): Unit = {
    if (balance > 0) {
      val interest = balance * 0.05 
      deposit(interest)
    } else {
      val interest = balance * 0.10 
      withdraw(-interest) 
    }
  }

  
  def isNegativeBalance: Boolean = balance < 0

  
  def displayAccount(): Unit = {
    println(s"Account Holder: $accountHolder, Balance: $balance")
  }
}

object BankApp extends App {


  var bank: List[Account] = List()

  
  def createAccount(name: String, initialBalance: Double): Unit = {
    val account = new Account(name, initialBalance)
    bank = account :: bank
  }

  
  def negativeBalanceAccounts(): List[Account] = {
    bank.filter(_.isNegativeBalance)
  }


  def sumOfAllBalances(): Double = {
    bank.map(_.getBalance).sum
  }


  def applyInterestToAllAccounts(): Unit = {
    bank.foreach(_.applyInterest())
  }

  
  createAccount("Nadhiya", 1000.0)
  createAccount("Naveen", -500.0)
  createAccount("Harinda", 1500.0)
  createAccount("Harinda KHAN", -100.0)

  
  println("All Accounts:")
  bank.foreach(_.displayAccount())


  println("\nAccounts with negative balances:")
  negativeBalanceAccounts().foreach(_.displayAccount())

  
  println(s"\nSum of all account balances: ${sumOfAllBalances()}")

  applyInterestToAllAccounts()
  println("\nFinal balances after applying interest:")
  bank.foreach(_.displayAccount())
}

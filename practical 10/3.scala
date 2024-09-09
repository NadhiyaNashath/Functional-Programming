import scala.io.StdIn

class Account(val accountHolder: String, private var balance: Double) {

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"$amount deposited. New balance: $balance")
    } else {
      println("Deposit amount must be positive.")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"$amount withdrawn. New balance: $balance")
    } else if (amount > balance) {
      println("Insufficient funds.")
    } else {
      println("Withdrawal amount must be positive.")
    }
  }

  def transfer(amount: Double, toAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
      println(s"Transferred $amount to ${toAccount.accountHolder}.")
    } else if (amount > balance) {
      println("Insufficient funds for transfer.")
    } else {
      println("Transfer amount must be positive.")
    }
  }

  def checkBalance(): Unit = {
    println(s"Current balance for ${accountHolder}: $balance")
  }
}

object BankApp extends App {

  var accounts = List[Account]()

  def createAccount(): Unit = {
    println("Enter account holder's name:")
    val name = StdIn.readLine()
    println("Enter initial balance:")
    val balance = StdIn.readDouble()
    val newAccount = new Account(name, balance)
    accounts = newAccount :: accounts
    println(s"Account for $name created successfully with balance $balance.")
  }

  def findAccount(name: String): Option[Account] = {
    accounts.find(_.accountHolder == name)
  }

  def transferMoney(): Unit = {
    println("Enter your account name:")
    val fromName = StdIn.readLine()
    println("Enter the account name to transfer to:")
    val toName = StdIn.readLine()

    (findAccount(fromName), findAccount(toName)) match {
      case (Some(fromAccount), Some(toAccount)) =>
        println("Enter amount to transfer:")
        val amount = StdIn.readDouble()
        fromAccount.transfer(amount, toAccount)
      case (Some(_), None) => println(s"Account with name $toName not found.")
      case (None, _) => println(s"Account with name $fromName not found.")
    }
  }

  def depositMoney(): Unit = {
    println("Enter account holder's name:")
    val name = StdIn.readLine()
    findAccount(name) match {
      case Some(account) =>
        println("Enter amount to deposit:")
        val amount = StdIn.readDouble()
        account.deposit(amount)
      case None => println(s"Account with name $name not found.")
    }
  }

  def withdrawMoney(): Unit = {
    println("Enter account holder's name:")
    val name = StdIn.readLine()
    findAccount(name) match {
      case Some(account) =>
        println("Enter amount to withdraw:")
        val amount = StdIn.readDouble()
        account.withdraw(amount)
      case None => println(s"Account with name $name not found.")
    }
  }

  def checkAccountBalance(): Unit = {
    println("Enter account holder's name:")
    val name = StdIn.readLine()
    findAccount(name) match {
      case Some(account) => account.checkBalance()
      case None => println(s"Account with name $name not found.")
    }
  }

  def menu(): Unit = {
    var continue = true

    while (continue) {
      println("\n--- Banking System Menu ---")
      println("1. Create Account")
      println("2. Deposit Money")
      println("3. Withdraw Money")
      println("4. Transfer Money")
      println("5. Check Account Balance")
      println("6. Exit")

      val choice = StdIn.readInt()

      choice match {
        case 1 => createAccount()
        case 2 => depositMoney()
        case 3 => withdrawMoney()
        case 4 => transferMoney()
        case 5 => checkAccountBalance()
        case 6 =>
          println("Exiting...")
          continue = false
        case _ => println("Invalid choice, please try again.")
      }
    }
  }

  menu()
}

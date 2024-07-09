import scala.io.StdIn.readLine

object inventoryManagementApp 
{

  def displayInventory(itemNames : Array[String], itemQuantities : Array[Int]): Unit = {
    for (i <- itemNames.indices) {
      println(s"${itemNames(i)}: ${itemQuantities(i)}")
    }
  }

  def restockItem(itemNames : Array[String],itemQuantities : Array[Int],itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index != -1) {
      itemQuantities(index) += quantity
      println(s"Restocked $itemName. New quantity: ${itemQuantities(index)}")
    } else {
      println(s"Item '$itemName' does not exist in the inventory.")
    }
  }

  def sellItem(itemNames: Array[String],itemQuantities: Array[Int],itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index != -1) {
      if (itemQuantities(index) >= quantity) {
        itemQuantities(index) -= quantity
        println(s"Sold $quantity of $itemName. Remaining quantity: ${itemQuantities(index)}")
      } else {
        println(s"Not enough quantity of $itemName to sell. Available quantity: ${itemQuantities(index)}")
      }
    } else {
      println(s"Item '$itemName' does not exist in the inventory.")
    }
  }

  def main(args: Array[String]): Unit = {
    println("Inventory Management System")
    val itemNo = readLine("Enter the number of items in the inventory : ").toInt
    val itemNames = new Array[String](itemNo)
    var itemQuantities = new Array[Int](itemNo)
    for (i <- 0 until itemNo) 
    {
      itemNames(i) = readLine(s"Enter the name of item ${i + 1}: ")
      itemQuantities(i) = readLine(s"Enter the quantity of ${itemNames(i)}: ").toInt
    }
    var continue = true
    while(continue)
    {
    println("Menu")
    println("Enter 1 to display inventory")
    println("Enter 2 to restock item")
    println("Enter 3 to sell item")
    println("Enter 4 to exit menu");
    var choice = readLine("Enter choice : ").toInt
    choice match {
        case 1 =>
          displayInventory(itemNames,itemQuantities)
        case 2 =>
          val itemName = readLine("Enter the name of the item to restock: ")
          val quantity = readLine("Enter the quantity to restock: ").toInt
          restockItem(itemNames,itemQuantities,itemName, quantity)
        case 3 =>
          val itemName = readLine("Enter the name of the item to sell: ")
          val quantity = readLine("Enter the quantity to sell: ").toInt
          sellItem(itemNames,itemQuantities,itemName, quantity)
        case 4 =>
          continue = false
          println("Exiting the program.")
        case _ =>
          println("Invalid choice. Please try again.")
      }
  }
}
}

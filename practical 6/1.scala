object inventoryApp extends App {

  val inventory1: Map[Int, (String, Int, Double)] = Map(
    101 -> ("Product1", 10, 100.0),
    102 -> ("Product2", 20, 200.0),
    103 -> ("Product3", 30, 300.0)
  )
 
  val inventory2: Map[Int, (String, Int, Double)] = Map(
    102 -> ("Product2", 20, 1000.0),
    104 -> ("Product4", 40, 400.0),
    105 -> ("Product5",50,500.0)
  )

  def printProducts(inventory: Map[Int, (String, Int, Double)]): Iterable[String] = {
    inventory.values.map(_._1)
  }
 
  def calculateTotalPrice(inventory: Map[Int, (String, Int, Double)]): Double = {
    inventory.values.map { case (_, qty, price) => qty * price }.sum
  }
 
  def isInventoryEmpty(inventory: Map[Int, (String, Int, Double)]): Boolean = {
    inventory.isEmpty
  }
 
  def mergeInventories(inventory1: Map[Int, (String, Int, Double)],
                       inventory2: Map[Int, (String, Int, Double)]): Map[Int, (String, Int, Double)] = {
    inventory2.foldLeft(inventory1) { case (acc, (id, (name, qty, price))) =>
      acc.get(id) match {
        case Some((existingName, existingQty, existingPrice)) =>
          acc.updated(id, (existingName, existingQty + qty, math.max(existingPrice, price)))
        case None =>
          acc + (id -> (name, qty, price))
      }
    }
  }
 
  def checkProductExists(inventory: Map[Int, (String, Int, Double)], productId: Int): Unit = {
    inventory.get(productId) match {
      case Some((name, qty, price)) =>
        println(s"Product ID: $productId, Name: $name, Quantity: $qty, Price: Rs.$price")
      case None =>
        println(s"Product with ID: $productId does not exist.")
    }
  }
 
  println("Product Names in Inventory 1: " + printProducts(inventory1).mkString(", "))
  println("Total Value of Inventory 1: Rs." + calculateTotalPrice(inventory1))

  if (isInventoryEmpty(inventory1))
    println("Inventory 1 is empty")
  else 
    println("Inventory 1 is not empty")
    

  val mergedInventory = mergeInventories(inventory1, inventory2)
  println("Merged Inventory: " + mergedInventory)
  checkProductExists(inventory1, 102)
}
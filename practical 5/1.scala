import scala.io.StdIn.readLine

object inventoryManagementSystem {
  
  def getProductList(): List[String] = {
    var productList = List[String]()
    var input = ""

    while (input != "done") {
      input = readLine("Enter a product name (type 'done' to finish): ")
      if (input != "done") {
        productList = productList :+ input
      }
    }
    
    productList
  }

  def printProductList(productList: List[String]): Unit = {
    for (i <- productList.indices) {
      println(s"${i + 1}. ${productList(i)}")
    }
  }

  def getTotalProducts(productList: List[String]): Int = {
    productList.size
  }

  def main(args: Array[String]): Unit = {
    val productList = getProductList()
    println("\nProduct List:")
    printProductList(productList)
    println(s"\nTotal number of products: ${getTotalProducts(productList)}")
  }
}

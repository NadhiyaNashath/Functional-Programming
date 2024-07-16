import scala.collection.mutable
import scala.io.StdIn.readLine

case class Book(title: String, author: String, isbn: String)

object LibraryManagement {
  var library: mutable.Set[Book] = mutable.Set(
    Book("Harry Potter", "J.K.Rowling", "1"),
    Book("It ends with us", "Colleen Hoover", "2"),
    Book("Corrupt", "Penelope Douglas", "3")
  )

  def addBook(book: Book): Unit = {
      library += book
      println(s"Book '${book.title}' added to the library.")
  }

  def removeBook(isbn: String): Unit = {
    val bookToRemove = library.find(_.isbn == isbn)
    bookToRemove match {
      case Some(book) =>
        library -= book
        println(s"Book '${book.title}' removed from the library.")
      case None => println(s"No book found with ISBN '$isbn'.")
    }
  }

  def isBookInLibrary(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  def displayLibrary(): Unit = {
    
      println("Current Library Collection:")
      library.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
    
  }

  def searchByTitle(title: String): Unit = {
    val book = library.find(_.title.equalsIgnoreCase(title))
    book match {
      case Some(b) => println(s"Found Book - Title: ${b.title}, Author: ${b.author}, ISBN: ${b.isbn}")
      case None => println(s"No book found with title '$title'.")
    }
  }

  def displayBooksByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
    if (booksByAuthor.nonEmpty) {
      println(s"Books by $author:")
      booksByAuthor.foreach(book => println(s"Title: ${book.title}, ISBN: ${book.isbn}"))
    } else {
      println(s"No books found by author '$author'.")
    }
  }

  def main(args: Array[String]): Unit = {
    var continue = true

    while (continue) {
      println("\nLibrary Management System")
      println("1. Display Library")
      println("2. Add Book")
      println("3. Remove Book")
      println("4. Search Book by Title")
      println("5. Display Books by Author")
      println("6. Exit")
      print("Choose an option: ")
      val choice = readLine().toInt

      choice match {
        case 1 => displayLibrary()
        case 2 =>
          println("Enter book details:")
          print("Title: ")
          val title = readLine()
          print("Author: ")
          val author = readLine()
          print("ISBN: ")
          val isbn = readLine()
          addBook(Book(title, author, isbn))
        case 3 =>
          print("Enter ISBN of the book to remove: ")
          val isbn = readLine()
          removeBook(isbn)
        case 4 =>
          print("Enter the title of the book to search: ")
          val title = readLine()
          searchByTitle(title)
        case 5 =>
          print("Enter the author to search books by: ")
          val author = readLine()
          displayBooksByAuthor(author)
        case 6 => continue = false
        case _ => println("Invalid option. Please try again.")
      }
    }
  }
}

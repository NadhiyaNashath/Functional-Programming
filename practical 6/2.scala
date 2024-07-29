import scala.io.StdIn.readLine

object studentRecordsApp {

  def readStudentInfo(): (String, Int, Int, Double, Char) = {
    var valid = false
    var studentInfo: (String, Int, Int, Double, Char) = ("", 0, 0, 0.0, 'F')
    
    while (!valid) {
      val name = readLine("Enter student name: ")
      val marks = readLine("Enter student marks: ").toInt
      val totalMarks = readLine("Enter total possible marks: ").toInt

      val (isValid, errorMessage) = validateInput(name, marks, totalMarks)

      if (isValid) {
        val percentage = (marks.toDouble / totalMarks) * 100
        val grade = percentage match {
          case p if p >= 90 => 'A'
          case p if p >= 75 => 'B'
          case p if p >= 50 => 'C'
          case _ => 'D'
        }
        studentInfo = (name, marks, totalMarks, percentage, grade)
        valid = true
      } else {
        println(errorMessage.getOrElse("Invalid input. Please try again."))
      }
    }

    studentInfo
}

  def printStudentRecord(record: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = record
    println(s"Student Name: $name")
    println(s"Marks: $marks / $totalMarks")
    println(f"Percentage: $percentage%.2f%%")
    println(s"Grade: $grade")
  }

  def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      (false, Some("Name cannot be empty"))
    } else if (marks < 0 || totalMarks <= 0 || marks > totalMarks) {
      (false, Some("Marks must be non-negative and not exceed total possible marks"))
    } else {
      (true, None)
    }
  }

  def readStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    readStudentInfo()
  }

  def main(args: Array[String]): Unit = {
    println("Student Records Application")
    val studentRecord = readStudentInfoWithRetry()
    printStudentRecord(studentRecord)
  }
}

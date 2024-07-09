object q3{
  def toUpper(string: String):String = {
    string.toUpperCase
  }

  def toLower(string: String):String = {
    string.toLowerCase
  }

  def formatNames(name: String, format: String => String): String = {
    format(name)
  }

  def main(args: Array[String]):Unit = {
    val benny = formatNames("Benny", toUpper)
    println(benny)

    val niroshan = formatNames("Niroshan", name =>{
      val firstTwo = toUpper(name.substring(0,2))
      val remaining = toLower(name.substring(2))
      firstTwo + remaining
    })
    println(niroshan)

    val saman = formatNames("Saman", toLower)
    println(saman)

    val kumara = formatNames("Kumara", name =>{
      val first = toUpper(name.substring(0,1))
      val middle = toLower(name.substring(1, name.length - 1))
      val last = toUpper(name.substring(name.length - 1))
      first + middle + last
    })
    println(kumara)
  }
}





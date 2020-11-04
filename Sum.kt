
fun main() {
  print("Valor? ")
  val value1 = readLine()!!.toInt()

  print("Valor? ")
  val value2 = readLine()!!.toInt()
  
  println("$value1 + $value2 = ${value1 + value2}")
}
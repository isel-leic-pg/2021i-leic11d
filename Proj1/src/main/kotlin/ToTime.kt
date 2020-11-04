
fun main() {
  /*
  val tm = Time(1,11,40) // Representação no diagrama
  println(tm.h)
  println(tm.m)
  println(tm.s)
  */
  val secs = readInt("Segundos")
  val tm = secsToTime(secs)
  println("$secs segundos = ${tm.toTxt()}")
}
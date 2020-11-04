
fun main() {
    /*
	val h = readInt("Horas")
	val m = readInt("Minutos")
	val s = readInt("Segundos")
	val secs = h*3600 + m*60 + s
	*/
	
	val tm = Time( readInt("Horas"), readInt("Minutos"), readInt("Segundos") )
	val secs = timeToSecs(tm)
	println("${toText(tm)} = $secs segundos.")
}
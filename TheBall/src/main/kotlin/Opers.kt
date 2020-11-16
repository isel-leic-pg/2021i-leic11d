
const val DEBUG = false

fun readInt(quest:String) :Int {
    print("$quest? ")
    return if (DEBUG) {
        val v = (1..10).random()
        println(v)
        v
    }
    else readLine()!!.trim().toInt()
}

fun doPlus() {
    val a = readInt("A")
    val b = readInt("B")
    println("$a + $b = ${ a + b }")
}
fun doMinus() {
    val a = readInt("A")
    val b = readInt("B")
    println("$a - $b = ${ a - b }")
}
fun doMultiply() {
    val a = readInt("A")
    val b = readInt("B")
    println("$a x $b = ${ a * b }")
}

fun main() {
    doPlus()
    doMinus()
    doMultiply()
}

const val DEBUG = true

fun readInt(quest:String) :Int {
    print("$quest? ")
    return if (DEBUG) {
        val v = (1..10).random()
        println(v)
        v
    }
    else readLine()!!.trim().toInt()
}

fun doOperation(operator:Char) {
    val a = readInt("A")
    val b = readInt("B")
    val res = when (operator) {
        '+' -> a + b
        '-' -> a - b
        else -> a * b // smell code
    }
    println("$a $operator $b = $res")
}


fun main() {
    doOperation('+')
    doOperation('-')
    doOperation('x')
}
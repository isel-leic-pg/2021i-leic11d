
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

fun doOperation(operator:Char, fx : (Int,Int)->Int ) {
    val a = readInt("A")
    val b = readInt("B")
    val res = fx(a,b)
    println("$a $operator $b = $res")
}

fun add(a:Int, b:Int) :Int { return a + b }
fun sub(a:Int, b:Int) :Int = a - b
fun mult(a:Int, b:Int) = a * b

fun main() {
    doOperation('+',::add)
    doOperation('-',::sub)
    doOperation('x',::mult)
}
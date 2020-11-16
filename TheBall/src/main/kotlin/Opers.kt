
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

typealias OperFx = (Int,Int)->Int

fun doOperation(operator:Char, fx :OperFx ) {
    val a = readInt("A")
    val b = readInt("B")
    val res = fx(a,b)
    println("$a $operator $b = $res")
}

fun main() {
    doOperation('+', {a:Int,b:Int -> a+b} )
    doOperation('-', { x,y -> x-y } )
    doOperation('x') { a,b -> a * b }
}
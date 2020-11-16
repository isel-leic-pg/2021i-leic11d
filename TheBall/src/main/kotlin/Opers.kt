
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

fun main() {
    fun add(a:Int,b:Int) = a + b
    val sub :(Int,Int)->Int = { a,b -> a - b }
    val mult = { a:Int,b:Int -> a*b }

    doOperation('+',::add)
    doOperation('-',sub)
    doOperation('x',mult)
}
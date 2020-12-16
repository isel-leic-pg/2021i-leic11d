import java.util.concurrent.locks.Condition

fun readLines() :List<String> {
    var lines:List<String> = emptyList()
    /*
    var line = readLine()
    while( line!=null ) {
        lines = lines + line
        line = readLine()
    }
    return lines
     */
    while (true) {
        val line = readLine() ?: return lines
        lines = lines + line
    }
}

data class Find2Result(val idx0:Int, val idx1:Int)

fun List<Int>.indexOf2Numbers( condition:(Int,Int)->Boolean ) :Find2Result {
    var idx = 0
    while (idx<size) {
        var idx2 = idx+1
        while (idx2<size) {
            if ( condition(this[idx],get(idx2)) )
                return Find2Result(idx,idx2)
            ++idx2
        }
        ++idx
    }
    return Find2Result(-1,-1)
}

fun main() {
    //val lines = readLines()
    //lines.forEach { print("$it ") }
    val numbers = readLines().map { it.toInt() }
    val (i0,i1) = numbers.indexOf2Numbers{ a,b -> a+b==2020 }
    if (i0!=-1)
        println("${numbers[i0]} , ${numbers[i1]}")
}
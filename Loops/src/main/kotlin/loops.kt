

fun main() {
    val vals = createListFloat(0.0F,20.0F,0.5F).shuffled()
    println(vals)
    val idx = find(vals,7.3F)
    println(idx)
}

fun find(vals:List<Float>, elem:Float) :Int? {
    /*
    val idx = vals.indexOf(elem)
    return if (idx==-1) null else idx
     */
    /*
    var idx = 0
    while ( idx < vals.size ) {
        if ( vals[idx] == elem ) return idx
        idx++
    }
    */
    for( idx in vals.indices )
        if ( vals[idx] == elem ) return idx
    /*
    repeat(vals.size) { idx ->
        if ( vals[idx] == elem ) return idx
    }
     */
    return null
}

fun createListFloat(from:Float, to:Float, delta:Float) :List<Float> {
    val size :Int = ((to-from) / delta).toInt()
    return (0..size).map{ from + it * delta }
    /*
    var res = emptyList<Float>()
    var elem = from
    while(elem <= to) {
        res = res + elem
        elem += delta
    }
    return res
     */
}

fun createListInt(from:Int, to:Int, delta:Int) :List<Int> {
    return (from..to step delta).toList()
    /*
    var res = emptyList<Int>()
    for ( elem in from..to step delta ) {
        res = res + elem
        println(elem)
    }
    */
    /*
    var elem = from
    while ( elem <= to ) {
        res = res + elem
        //println(elem)
        elem += delta
    }
    return res
     */
}

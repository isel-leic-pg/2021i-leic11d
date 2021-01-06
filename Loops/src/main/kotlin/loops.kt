

fun main() {
    val vals = createListFloat(from = 14.0F, to = 20.0F, delta = 0.5F).shuffled()
    println(vals)
    val idx = findR(vals,17.5F)
    println(idx)
    val ordered = sort(vals)
    println(ordered)
    //val idx2 = search(ordered,17.5F)
    //println(idx2)
}

fun sort(vals:List<Float>) :List<Float> {
    var l = vals
    var res = emptyList<Float>()
    while (l.isNotEmpty()) {
        var m = l[0]
        for (idx in 1 until l.size) {
            val v = l[idx]
            if (v < m) m = v
        }
        res = res + m
        l = l - m
    }
    return res
}

// List<T>  ->  ( emptyList || T , List<T> )

fun findR(vals:List<Float>, elem:Float, from:Int=0) :Int? = when {
    from >= vals.size -> null
    vals[from]==elem -> from
    else -> findR(vals,elem,from+1)
}

fun find(vals:List<Float>, elem:Float) :Int? {
    for( idx in vals.indices )
        if ( vals[idx] == elem ) return idx
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
    /*
    repeat(vals.size) { idx ->
        if ( vals[idx] == elem ) return idx
    }
     */
    return null
}

fun createListFloat(from:Float, to:Float, delta:Float) :List<Float> {
    var res = emptyList<Float>()
    var elem = from
    while(elem <= to) {
        res = res + elem
        elem += delta
    }
    return res
    //val size :Int = ((to-from) / delta).toInt()
    //return (0..size).map{ from + it * delta }
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

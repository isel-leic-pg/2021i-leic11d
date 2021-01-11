
fun find1(vals:List<Float>, elem:Float) :Int? {
    var idx = 0
    while ( idx < vals.size ) {
        if ( vals[idx] == elem ) return idx
        idx++
    }
    return null
}

fun find2(vals:List<Float>, elem:Float) :Int? {
    for( idx in vals.indices )
        if ( vals[idx] == elem ) return idx
    return null
}

fun find3(vals:List<Float>, elem:Float) :Int? {
    repeat(vals.size) { idx ->
        if ( vals[idx] == elem ) return idx
    }
    return null
}

fun find4(vals:List<Float>, elem:Float) :Int? {
    val idx = vals.indexOf(elem)
    return if (idx==-1) null else idx
}

// List<T>  ->  ( emptyList || T , List<T> )
fun find5(vals:List<Float>, elem:Float) :Int? = when {
    vals.size == 0 -> null
    vals[0]==elem -> 0
    else -> {
        val idx = find5(vals-vals[0],elem)
        if (idx==null) null else idx+1
    }
}

fun find6(vals:List<Float>, elem:Float, from:Int=0) :Int? = when {
    from >= vals.size -> null
    vals[from]==elem -> from
    else -> find6(vals,elem,from+1)
}


fun main() {
    val lst = createListFloat2(15.0F,20.0F,0.5F).shuffled()
    println(lst)
    val idx = find6(lst,16.5F)
    println(idx)
}
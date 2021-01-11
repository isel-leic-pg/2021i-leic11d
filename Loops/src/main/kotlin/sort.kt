
fun min(a:Float, b:Float) = if (a<b) a else b

fun List<Float>.min() :Float {
    var m = this[0]
    for(idx in 1 until size ) {
        m = min(m,this[idx])
    }
    return m
}

// List<T> --> (T | T,List<T>)
fun List<Float>.min2() :Float =
    if (size==1) this[0]
    else min(this[0],(this-this[0]).min2())


fun sort(vals:List<Float>) :List<Float> {
    var l = vals
    var res = emptyList<Float>()
    while (l.isNotEmpty()) {
        val m = vals.min()
        res = res + m
        l = l - m
    }
    return res
}


fun main() {
    val vals = createListFloat2(from = 14.0F, to = 20.0F, delta = 0.5F).shuffled()
    println(vals)
    val min = vals.min2()
    println(min)
    val idx = find2(vals,17.5F)
    println(idx)
    val ordered = sort(vals)
    println(ordered)
}
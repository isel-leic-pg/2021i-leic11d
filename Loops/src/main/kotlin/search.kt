

tailrec fun search1(l :List<Float>, elem:Float, from:Int=0, to:Int=l.size-1) :Int? {
    if (from>to) return null
    val mid = (from+to)/2
    val v = l[mid]
    if (elem == v) return mid
    if (elem < v)
        return search1(l,elem,from,mid-1)
    else
        return search1(l,elem,mid+1,to)
}

fun search2(l :List<Float>, elem:Float, from:Int=0, to:Int=l.size-1) :Int? {
    var left=from
    var right=to
    while(left<=right) {
        val mid = (left+right)/2
        val v = l[mid]
        if (elem == v) return mid
        if (elem < v) right = mid-1
        else left = mid+1
    }
    return null
}

fun main() {
    val lst = createListFloat2(0F,512F,1F)
    println(lst)
    val idx = search2(lst,18.5F)
    println(idx)
}

fun main() {
    val lst:List<Int> = listOf(1,2,3,4)
    println(lst + 10)
    //lst[2] = 20

    val lm = mutableListOf(1,2,3,4)
    lm.add(10)
    lm[2] = 20
    println(lm)
    lm.removeIf { it < 3 }
    println(lm.toString())

    val ai:Array<Int> = arrayOf(1,2,3,4)
    printArray(ai)
    ai[2] = 10
    printArray(ai)
    val a = Array(5) { (0..200).random()/10.0 }
    printArray(a)
    sortArray(a)
    printArray(a)
}

fun sortArray(a:Array<Double>) {
    var swap:Boolean
    for(limit in (a.size-2) downTo 0) {
        swap = false
        for (idx in 0 .. limit) {
            if (a[idx] > a[idx + 1]) {
                val tmp = a[idx]
                a[idx] = a[idx + 1]
                a[idx + 1] = tmp
                swap = true
            }
        }
        if (!swap) return
    }
}

fun <T> printArray(a:Array<T>) {
    print('{')
    for (idx in 0..(a.size-2))
        print("${a[idx]}, ")
    if (a.size>0) print(a.last())
    println('}')
}
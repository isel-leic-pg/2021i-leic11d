

fun main(args :Array<String>) {
    val total = args.map { it.toInt() }.sum()
    println("total = $total")
}
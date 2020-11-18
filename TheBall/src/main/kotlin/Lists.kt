fun main() {
    val numbers :List<Int> = listOf(38,40,39,40,1,12)
    numbers.forEach { number -> println("Number $number") }
    var sum = 0
    numbers.forEach { n -> sum+=n }
    println(sum)
    val evens = numbers.filter { it%2==0 }
    println(evens)
    val divs :List<Float> = numbers.map { it/2.0f }
    println(divs)
    println(numbers.sorted() + 11)
    println((numbers - 45) - 1)
    println(numbers[0])
    println(numbers[1])
    println(numbers[numbers.size-1])
    println(emptyList<Int>()+numbers.first()+numbers.last())
    val l : List<String> = listOf()
    println(l)
}
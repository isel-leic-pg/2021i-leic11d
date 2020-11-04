import pt.isel.canvas.*

fun main() {
    onStart {
        val arena = Canvas(600,300, CYAN)
    }
    onFinish {
        println("Bye")
    }
}
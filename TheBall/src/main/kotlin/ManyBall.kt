import pt.isel.canvas.*
import kotlin.math.sqrt

fun Ball.step2(xLimit :Int, yLimit :Int) :Ball {
    val p = this.pos + vel
    val (x,y) = pos
    return when {
        x !in radius .. xLimit-radius ->
            Ball( Position(pos.x-vel.dx,y) , Velocity(-vel.dx,vel.dy), radius, color)
        y !in radius .. yLimit-radius ->
            Ball( Position(x,pos.y-vel.dy) , Velocity(vel.dx,-vel.dy), radius, color)
        else ->
            Ball( p, vel, radius, color )
    }
}

fun Canvas.drawBall2(b :Ball) {
    b.apply { drawCircle(pos.x, pos.y, radius, color) }
}

fun distance(a:Position, b:Position) = sqrt( square(a.x-b.x).toFloat() + square(a.y-b.y) )
fun square(n:Int) = n*n

fun main() {
    onStart {
        val arena = Canvas(width = 600, height = 200, CYAN)
        val center = Position(arena.width/2,arena.height/2)
        var balls :List<Ball> = emptyList()
        arena.onTimeProgress(10) {
            balls = balls.map { it.step2(arena.width, arena.height) }
            arena.erase()
            balls.forEach { arena.drawBall2(it) }
        }
        arena.onMouseDown { m ->
            val mousePos = Position(m.x,m.y)
            balls = balls.filter{ distance(it.pos,mousePos) > it.radius }
        }
        arena.onKeyPressed { ke ->
            if (ke.char == 'v' || ke.char == 'V')
                balls = balls + Ball(center, Velocity((-5..5).random(), (-5..5).random()), (20..50).random(), (0..0xFFFFFF).random())
        }
    }
    onFinish {
        println("Bye")
    }
}
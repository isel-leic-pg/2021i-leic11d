import pt.isel.canvas.*
import kotlin.random.Random.Default.nextInt

data class Position(val x:Int, val y:Int)
data class Velocity(val dx:Int, val dy:Int)

data class Ball(val pos:Position, val vel:Velocity, val radius:Int =20, val color:Int =RED)

fun Canvas.drawBall(b :Ball) {
    erase()
    drawCircle(b.pos.x, b.pos.y, b.radius, b.color)
}

fun Ball.step(xLimit :Int, yLimit :Int) :Ball {
    val x = pos.x + vel.dx
    val y = pos.y + vel.dy
    return when {
        x+radius > xLimit || x-radius < 0 ->
            Ball( Position(pos.x-vel.dx,y) , Velocity(-vel.dx,vel.dy), radius, color)
        y+radius > yLimit || y-radius < 0 ->
            Ball( Position(x,pos.y-vel.dy) , Velocity(vel.dx,-vel.dy), radius, color)
        else ->
            Ball( Position(x,y), vel, radius, color )
    }
}

fun main() {
    onStart {
        val arena = Canvas(width = 600, height = 200, CYAN)
        var ball = Ball(Position(arena.width/2,arena.height/2), Velocity(4,2), color = RED)  // Mutabilidade
        arena.drawBall(b = ball)
        arena.onTimeProgress(10) { tm ->
            //ball = stepBall(ball, arena.width)
            ball = ball.step(arena.width, arena.height)
            //drawBall(arena,ball)
            arena.drawBall(ball)
            //println(tm)
        }
        arena.onKeyPressed { ke ->
            if (ke.char == 'v')
                ball = Ball(ball.pos, Velocity(nextInt(-5, 6), nextInt(-5, 6)), ball.radius, ball.color)
            else
                ball = Ball(ball.pos, ball.vel, ball.radius, when (ke.char) {
                    'b' -> BLUE
                    'r' -> RED
                    'g' -> GREEN
                    else -> BLACK
                } )
        }
    }
    onFinish {
        println("Bye")
    }
}
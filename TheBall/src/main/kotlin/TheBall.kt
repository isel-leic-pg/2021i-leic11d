import pt.isel.canvas.*

data class Position(val x:Int, val y:Int)
data class Velocity(val dx:Int, val dy:Int)

/*
fun plus(pos:Position, vel:Velocity) :Position {
    return Position(pos.x+vel.dx , pos.y+vel.dy)
}
 */
operator fun Position.plus(vel:Velocity) = Position(x+vel.dx, y+vel.dy)

data class Ball(val pos:Position, val vel:Velocity, val radius:Int =20, val color:Int =RED)

fun Canvas.drawBall(b :Ball) {
    erase()
    drawCircle(b.pos.x, b.pos.y, b.radius, b.color)
}

fun Ball.step(xLimit :Int, yLimit :Int) :Ball {
    //val x = pos.x + vel.dx
    //val y = pos.y + vel.dy
    //val p = pos.plus(vel)
    val p = pos + vel
    val (x,y) = pos
    //val x = pos.component1()
    //val y = pos.component2()
    return when {
        //x > xLimit-radius || x < radius ->
        x !in radius .. xLimit-radius ->
            Ball( Position(pos.x-vel.dx,y) , Velocity(-vel.dx,vel.dy), radius, color)
        //y+radius > yLimit || y-radius < 0 ->
        y !in radius .. yLimit-radius ->
            Ball( Position(x,pos.y-vel.dy) , Velocity(vel.dx,-vel.dy), radius, color)
        else ->
            Ball( p, vel, radius, color )
    }
}

fun main() {
    onStart {
        val arena = Canvas(width = 600, height = 200, CYAN)
        var ball = Ball(Position(arena.width/2,arena.height/2), Velocity(4,2), color = RED)  // Mutabilidade
        arena.drawBall(b = ball)
        arena.onTimeProgress(10) { tm ->
            ball = ball.step(arena.width, arena.height)
            arena.drawBall(ball)
        }
        arena.onKeyPressed { ke ->
            ball = if (ke.char == 'v')
                Ball(ball.pos, Velocity((-5..5).random(), (-5..5).random()), ball.radius, ball.color)
            else
                Ball(ball.pos, ball.vel, ball.radius, when (ke.char) {
                    'b' -> BLUE ; 'r' -> RED ; 'g' -> GREEN  else -> BLACK
                } )
        }
    }
    onFinish {
        println("Bye")
    }
}
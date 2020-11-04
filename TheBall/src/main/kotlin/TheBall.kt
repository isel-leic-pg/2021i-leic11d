import pt.isel.canvas.*

data class Position(val x:Int, val y:Int)
data class Velocity(val dx:Int, val dy:Int)

data class Ball(val pos:Position, val vel:Velocity, val radius:Int =50)

fun Canvas.drawBall(b :Ball) {
    erase()
    drawCircle(b.pos.x,b.pos.y,b.radius,RED)
}
/*
fun stepBall(b :Ball, limit :Int) :Ball {
    val x = b.x + b.dx
    return if ( x+b.radius > limit || x-b.radius < 0) Ball( b.x-b.dx , -b.dx, b.radius)
           else Ball( x, b.dx, b.radius )
}
*/
fun Ball.step(xLimit :Int, yLimit :Int) :Ball {
    val x = pos.x + vel.dx
    val y = pos.y + vel.dy
    return when {
        x+radius > xLimit || x-radius < 0 ->
            Ball( Position(pos.x-vel.dx,y) , Velocity(-vel.dx,vel.dy), radius)
        y+radius > yLimit || y-radius < 0 ->
            Ball( Position(x,pos.y-vel.dy) , Velocity(vel.dx,-vel.dy), radius)
        else ->
            Ball( Position(x,y), vel, radius )
    }
/*
    if ( x+radius > limit || x-radius < 0)
        Ball( Position(pos.x-vel.dx,pos.y) , Velocity(-vel.dx,vel.dy), radius)
    else Ball( Position(x,pos.y), vel, radius
 */
}

fun main() {
    onStart {
        val arena = Canvas(600, 200, CYAN)
        var ball = Ball(Position(arena.width/2,arena.height/2), Velocity(4,2), 20)  // Mutabilidade
        arena.drawBall(ball)
        arena.onTimeProgress(10) {
            //ball = stepBall(ball, arena.width)
            ball = ball.step(arena.width, arena.height)
            //drawBall(arena,ball)
            arena.drawBall(ball)
        }
    }
    onFinish {
        println("Bye")
    }
}
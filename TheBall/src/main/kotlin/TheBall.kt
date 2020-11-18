import pt.isel.canvas.*

data class Position(val x:Int, val y:Int)
data class Velocity(val dx:Int, val dy:Int)

operator fun Position.plus(vel:Velocity) = Position(x+vel.dx, y+vel.dy)

data class Ball(val pos:Position, val vel:Velocity, val radius:Int =20, val color:Int =RED)

fun Canvas.drawBall(b :Ball?) {   // Canvas.(Ball?)->Unit
    erase()
    //if (b!=null) this.drawCircle(b.pos.x, b.pos.y, b.radius, b.color)
    b?.apply { drawCircle(pos.x, pos.y, radius, color) }
}

fun Ball.step(xLimit :Int, yLimit :Int) :Ball? {  // Ball.(Int,Int)->Ball?
    val p = this.pos + vel
    val (x,y) = pos
    return when {
        //x !in radius .. xLimit-radius ->
        x > xLimit -> {
            println("Gone.")
            null
        }
        x < radius ->
            Ball( Position(pos.x-vel.dx,y) , Velocity(-vel.dx,vel.dy), radius, color)
        y !in radius .. yLimit-radius ->
            Ball( Position(x,pos.y-vel.dy) , Velocity(vel.dx,-vel.dy), radius, color)
        else ->
            Ball( p, vel, radius, color )
    }
}

fun show(a:Int) { print(a) }         // (Int)->Unit
fun sub(a:Int,b:Float) :Float = a*b  //  (Int,Float)->Float
fun Int.add(b:Float) :Float = this*b  //  Int.(Float)->Float

fun main() {    // ()->Unit
    onStart {
        val arena = Canvas(width = 600, height = 200, CYAN)
        val center = Position(arena.width/2,arena.height/2)
        var ball :Ball? = Ball(center, Velocity(-4,2), color = RED)  // Mutabilidade
        arena.onTimeProgress(10) {
            ball = ball?.step(arena.width, arena.height)
            arena.drawBall(ball)
        }
        /*
        val a :Int? = null
        val x :Int = a ?: 0
        */
        arena.onKeyPressed { ke ->
            ball = if (ke.char == 'v' || ke.char == 'V')
                Ball(center, Velocity((-5..5).random(), (-5..5).random()))
            else {
                val b = ball
                if (b != null)
                    Ball(b.pos, b.vel, b.radius, when (ke.char) {
                    'b' -> BLUE; 'r' -> RED; 'g' -> GREEN
                    else -> BLACK
                })
                else null
            }
        }
    }
    onFinish {
        println("Bye")
    }
}
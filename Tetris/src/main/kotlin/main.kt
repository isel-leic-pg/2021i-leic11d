import pt.isel.canvas.*

/**
 * Grid width in blocks
 */
const val GRID_WIDTH = 6

/**
 * Grid height in blocks
 */
const val GRID_HEIGHT = 10

/**
 * Valid horizontal block positions.
 */
val GRID_X = 0 until GRID_WIDTH

/**
 * Valid vertical block positions.
 */
val GRID_Y = 0 until GRID_HEIGHT

/**
 * Program entry point for a version of Tetris game.
 *
 * Movement of a block in a grid (10x20) using the cursor keys.
 * The block is fixed when it touches the base or on top of another block.
 * A new block appears with a random color.
 */
fun main() {  // ()->Unit
    onStart {
        val arena = Canvas(GRID_WIDTH*BLOCK_SIDE, GRID_HEIGHT*BLOCK_SIDE, BLACK)
        var game = Tetris( newPiece(), emptyList() )
        arena.drawTetris(game)
        arena.onKeyPressed { ke ->
            val g :Tetris? = when(ke.code) {
                LEFT_CODE -> game.move(-1,0)
                RIGHT_CODE -> game.move(+1,0)
                DOWN_CODE -> game.move(0,+1)
                UP_CODE -> game.rotate()
                else -> null
            }
            if (g!=null) {
                game = g
                arena.drawTetris(game)
            }
        }
    }
    onFinish { }
    f( Dir.LEFT )
}

enum class Dir(val dx:Int,val dy:Int) { UP(0,-1), DOWN(0,1), LEFT(-1,0), RIGHT(1,0) }

/*
data class Dir(val name:String, val ordinal:Int)
val UP = Dir("UP",0)
val DWON = Dir("DOWN",1)
    ...
*/

fun f(dir:Dir) {
    println("${dir.dx},${dir.dy}")
    println(dir.name)
    println(dir.ordinal)
    Dir.values().forEach { print("$it ") }
    println()
}


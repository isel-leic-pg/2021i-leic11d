import pt.isel.canvas.*

/**
 * Grid width in blocks
 */
const val GRID_WIDTH = 5

/**
 * Grid height in blocks
 */
const val GRID_HEIGHT = 8

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
        var game = Tetris( newBlock(), emptyList() )
        arena.drawTetris(game)
        arena.onKeyPressed { ke ->
            val g :Tetris? = when(ke.code) {
                LEFT_CODE -> game.move(-1,0)
                RIGHT_CODE -> game.move(+1,0)
                DOWN_CODE -> game.move(0,+1)
                //UP_CODE -> blk.move(0,-1)
                else -> null
            }
            if (g!=null) {
                game = g
                arena.drawTetris(game)
            }
        }
    }
    onFinish { }

    /*
    val l = listOf(10, 13, 7, 3)
    println(l)
    val r = l.map { 'A'+it }
    println(r)
    val i = l.filter { it%2!=0 }
    println(i)
    println(l.any{ it%2==0 })
    println(l.filter { it%2==0 }.size>0)
    println(l.all{ it>5 })
    println(l[2])
    println( l + 27 + listOf(0,1,2) )
    println( l )
    println( l - 13 - listOf(10,27,15) )
    */
}
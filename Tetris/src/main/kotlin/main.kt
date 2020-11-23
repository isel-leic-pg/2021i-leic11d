import pt.isel.canvas.*

/**
 * Block information.
 *
 * Position ([x],[y]) and [color].
 */
data class Block(val x:Int, val y:Int, val color:Int)

const val GRID_WIDTH = 10
const val GRID_HEIGHT = 20

const val BLOCK_SIDE = 38
const val BORDER = 7  // Must be odd

/**
 *
 */
fun Canvas.drawBlock(b:Block) {
    val x = b.x*BLOCK_SIDE  // in pixels
    val y = b.y*BLOCK_SIDE  // in pixels
    drawRect(x, y, BLOCK_SIDE, BLOCK_SIDE, b.color)
    drawRect(x+BORDER/2, y+BORDER/2, BLOCK_SIDE-BORDER, BLOCK_SIDE-BORDER, 0xAAAAAA, BORDER)
}

fun Block.move(dx:Int, dy:Int) = Block(x + dx ,y + dy,color)

/**
 * Program entry point for a version of Tetris game.
 *
 * Draw one block.
 */
fun main() {
    onStart {
        val arena = Canvas(GRID_WIDTH*BLOCK_SIDE, GRID_HEIGHT*BLOCK_SIDE, BLACK)
        var blk = Block(3,7, GREEN)
        arena.drawBlock(blk)
        arena.onKeyPressed { ke ->
            when(ke.code) {
                LEFT_CODE -> blk = blk.move(-1,0)
                RIGHT_CODE -> blk = blk.move(+1,0)
                DOWN_CODE -> blk = blk.move(0,+1)
                UP_CODE -> blk = blk.move(0,-1)
            }
            arena.erase()
            arena.drawBlock(blk)
        }
    }
    onFinish { }
}
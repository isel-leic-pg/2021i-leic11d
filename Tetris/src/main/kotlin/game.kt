import pt.isel.canvas.Canvas
import pt.isel.canvas.WHITE

/**
 * Represents the game status.
 *
 * Aggregates the falling block ([moving]) and the blocks already fixed ([fixed]).
 */
data class Tetris(val moving:Block, val fixed:List<Block>, val finish:Boolean=false)

/**
 * Draw the game.
 * @param g Status of game to draw
 */
fun Canvas.drawTetris(g:Tetris) {
    erase()
    drawBlock(g.moving)
    g.fixed.forEach { drawBlock(it) }
    if (g.finish)
        drawText(0,height/2,"END", WHITE,64)
}

/**
 * Try to move the falling block and check if it is fixed.
 * @receiver The original game
 * @param dx Horizontal offset to move
 * @param dy Vertical offset to move
 * @return The resulting game status
 */
fun Tetris.move(dx:Int, dy:Int) :Tetris? {
    if (finish) return null
    val b = moving.move(dx, dy, fixed)
    return when {
        b==null             -> null
        b.toFix( fixed )    -> fixBlock(b)
        else                -> Tetris( b, fixed)
    }
}

/**
 * Fix a block and check if it forms a complete line.
 * Remove the complete line and drop the above lines.
 *
 * @receiver The original game
 * @param b block to fix
 * @return The resulting game status
 */
fun Tetris.fixBlock(b:Block) :Tetris {
    var f = fixed + b
    val line = f.filter { it.y==b.y }
    if (line.size == GRID_WIDTH)
        f = (f - line).map{ if(it.y<b.y) Block(it.x,it.y+1,it.color) else it  }
    val newBlk = newBlock()
    return Tetris( newBlk, f , newBlk.toFix( f ) )
}


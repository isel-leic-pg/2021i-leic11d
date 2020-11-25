import pt.isel.canvas.Canvas

/**
 * Represents the game status.
 *
 * Aggregates the falling block ([moving]) and the blocks already fixed ([fixed]).
 */
data class Tetris(val moving:Block, val fixed:List<Block>)

/**
 * Draw the game.
 * @param g Status of game to draw
 */
fun Canvas.drawTetris(g:Tetris) {
    erase()
    drawBlock(g.moving)
    g.fixed.forEach { drawBlock(it) }
}

/**
 * Try to move the falling block and check if it is fixed.
 * @receiver The original game
 * @param dx Horizontal offset to move
 * @param dy Vertical offset to move
 * @return The resulting game status
 */
fun Tetris.move(dx:Int, dy:Int) :Tetris? {
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
    val f = fixed + b
    //TODO: Verificar linhas completas
    return Tetris(newBlock(), f )
}


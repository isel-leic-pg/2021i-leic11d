import pt.isel.canvas.BLUE
import pt.isel.canvas.Canvas

data class Piece(val blks:List<Block>)


fun newPiece() :Piece {
    val x = GRID_WIDTH/2
    val y = 1
    val color = BLUE
    // J
    return Piece(listOf(Block(x,y,color),Block(x,y-1,color),Block(x,y+1,color),Block(x-1,y+1,color)))
}


fun Canvas.drawPiece(p:Piece)  {
    p.blks.forEach { drawBlock(it) }
}

fun Piece.move(dx:Int, dy:Int, f:List<Block>) :Piece? {
    val bs:List<Block> = blks.mapNotNull { b -> b.move(dx, dy, f) }
    return if (bs.size==4) Piece(bs) else null
}

fun Piece.toFix(f:List<Block>) = blks.any { it.toFix(f) }

fun Piece.rotate(f:List<Block>):Piece? {
    val bs = blks.mapNotNull{ b -> b.rotate(blks[0],f) }
    return if (bs.size==4) Piece(bs) else null
}

fun Block.rotate(center:Block, f:List<Block>) :Block? {
    if (this==center) return this
    val b = Block(center.x -y +center.y, center.y +x - center.x, color)
    return if (b.valid(f)) b else null
}

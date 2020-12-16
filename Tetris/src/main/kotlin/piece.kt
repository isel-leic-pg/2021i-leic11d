import pt.isel.canvas.*

data class Piece(val type:Tetromino, val blks:List<Block>)

const val ORANGE = 0xFFA500

enum class Tetromino(val color:Int) { J(BLUE), O(YELLOW), I(CYAN), L(ORANGE), S(GREEN), Z(RED), T(MAGENTA) }

fun createPiece(t:Tetromino,x1:Int,y1:Int,x2:Int,y2:Int,x3:Int,y3:Int) :Piece {
    val x = GRID_WIDTH / 2
    val y = 1
    val color = t.color
    return Piece( t, listOf (
       Block(x,y,color), Block(x+x1,y+y1,color), Block(x+x2,y+y2,color),Block(x+x3,y+y3,color)
    ))
}

fun newPiece() = when(val type= Tetromino.values().random()) {
    Tetromino.J -> createPiece(type, 0, -1, 0, 1, -1, 1)
    Tetromino.O -> createPiece(type, 0, -1, 1, -1, 1, 0)
    Tetromino.I -> createPiece(type, 0, -1, 0, 1, 0, 2)
    Tetromino.S -> createPiece(type, 1, 0, 0, 1, -1, 1)
    Tetromino.T -> createPiece(type, 1, 0, -1, 0, 0, 1)
    Tetromino.L -> createPiece(type, 0, -1, 0, 1, 1, 1)
    Tetromino.Z -> createPiece(type, 1, 0, 0, -1, -1, -1)
}

fun Canvas.drawPiece(p:Piece)  {
    p.blks.forEach { drawBlock(it) }
}

fun Piece.move(dx:Int, dy:Int, f:List<Block>) :Piece? {
    val bs:List<Block> = blks.mapNotNull { b -> b.move(dx, dy, f) }
    return if (bs.size==4) Piece(type,bs) else null
}

fun Piece.toFix(f:List<Block>) = blks.any { it.toFix(f) }

fun Piece.rotate(f:List<Block>):Piece? {
    if (type==Tetromino.O) return null
    val bs = blks.mapNotNull{ b -> b.rotate(blks[0],f) }
    return if (bs.size==4) Piece(type,bs) else null
}

fun Block.rotate(center:Block, f:List<Block>) :Block? {
    if (this==center) return this
    val b = Block(center.x -y +center.y, center.y +x - center.x, color)
    return if (b.valid(f)) b else null
}

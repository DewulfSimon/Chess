package pieceMechanics.MoveServices;

import pieceMechanics.Piece;
import pieceMechanics.pieces.Knight;


/**
 * provides methods for Knight Moves. wasn't really necessary but made it for consistency with other classes
 */
public class KnightService extends MoveServices{
    private Knight knight;

    public KnightService(Knight knight) {
        this.knight = knight;
    }

    public KnightService setPiece(Knight knight) {
        this.knight = knight;
        return this;
    }
}

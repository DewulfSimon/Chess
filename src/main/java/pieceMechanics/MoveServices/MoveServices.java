package pieceMechanics.MoveServices;

import pieceMechanics.Piece;


/**
 * template class for specific moveServices for all Pieces
 */
abstract class MoveServices {
    private Piece piece;



    public MoveServices(Piece piece) {
        this.piece = piece;
    }

    public MoveServices() {
    }

    public Piece getPiece() {
        return piece;
    }

    public MoveServices setPiece(Piece piece) {
        this.piece = piece;
        return this;
    }
}

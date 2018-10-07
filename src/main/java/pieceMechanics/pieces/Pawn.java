package pieceMechanics.pieces;

import BoardMechanics.Location;
import pieceMechanics.MoveServices.PawnService;
import pieceMechanics.Piece;

public class Pawn extends Piece {
    private PawnService pawnService;


    public Pawn(Location location, String color, PawnService pawnService) {
        super(location, color);
        this.pawnService = pawnService;
    }

    public PawnService getPawnService() {
        return pawnService;
    }
}

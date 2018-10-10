package pieceMechanics.pieces;

import boardMechanics.Field;
import pieceMechanics.MoveServices.PawnService;
import pieceMechanics.Piece;

public class Pawn extends Piece {
    private PawnService pawnService;


    public Pawn(Field field, String color, PawnService pawnService) {
        super(field, color);
        this.pawnService = pawnService;
    }



    public PawnService getPawnService() {
        return pawnService;
    }

    @Override
    public void move(Field targetField) {

    }
}

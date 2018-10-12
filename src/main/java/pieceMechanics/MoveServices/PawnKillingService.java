package pieceMechanics.MoveServices;

import boardMechanics.Field;
import pieceMechanics.Piece;

public class PawnKillingService extends MoveServices {
    //todo: implement killing AND en-passant

    protected boolean targetFieldFormula(Field start, Field target, Piece pawn) {
        return false;
    }

    @Override
    boolean move(Field start, Field target, Piece[][] board) {
        return false;
    }
}

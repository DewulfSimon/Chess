package pieceMechanics.MoveServices;

import boardMechanics.Field;
import gameMechanics.GameData;
import pieceMechanics.Piece;

public class CastleService extends MoveServices implements ColoredFormula {
    @Override
    protected boolean move(Field start, Field target, Piece[][] board) {
        return false;
    }

    @Override
    protected boolean targetFieldContent(Field start, Field target, Piece[][] board) {
        return super.targetFieldContent(start, target, board);
    }

    @Override
    public boolean targetFieldFormula(Field start, Field target, Piece pawn) {
        return false;
    }
}

package pieceMechanics.MoveServices;

import boardMechanics.Field;

import pieceMechanics.Piece;

public abstract class LongGroundMoverService extends MoveServices implements PieceFormula {
    /**
     * checks targetfield and road to targetfield seperatly as it doesn't matter who or what stands in between
     */
    @Override
    public boolean move(Field start, Field target, Piece[][] board) {

        return emptyRoad(start, target, board) && targetFieldContent(start, target, board) && targetFieldFormula(start, target);

    }



    protected abstract boolean emptyRoad(Field start, Field target, Piece[][] board);

}

package pieceMechanics.MoveServices;

import boardMechanics.Field;
import pieceMechanics.Piece;


/**
 * template class for specific moveServices for all Pieces
 */
abstract class MoveServices {

    abstract boolean move(Field start, Field target, Piece[][] board);

    /**
     *  checks if the targetlocation contains a piece and if so if it is an enemy
     * @param start startField
     * @param target the target location
     * @param board the piece[][] of this game
     * @return boolean
     */

    protected boolean targetFieldContent(Field start, Field target, Piece[][] board) {
        Piece targetPiece = board[target.getY()][target.getX()];
        if (targetPiece == null) return true;
        else if (targetPiece.isEnemy(board[target.getY()][target.getX()])) return true;

        return false;
    }

    protected abstract boolean targetFieldFormula(Field start, Field target);


}

package pieceMechanics.MoveServices;

import boardMechanics.Field;
import gameMechanics.GameData;
import pieceMechanics.Piece;


/**
 * template class for specific moveServices for all Pieces
 */
public abstract class MoveServices {

    protected abstract boolean move(Field start, Field target, Piece[][] board);

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
        else return (targetPiece.isEnemy(board[start.getY()][start.getX()]));
    }




}

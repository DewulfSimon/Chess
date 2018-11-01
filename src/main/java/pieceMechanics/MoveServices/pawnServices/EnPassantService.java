package pieceMechanics.MoveServices.pawnServices;

import boardMechanics.Field;
import gameMechanics.GameData;
import pieceMechanics.Piece;
import pieceMechanics.pieces.Pawn;

public class EnPassantService extends PawnKillingService {
    private static EnPassantService enPassantService = null;

    public static EnPassantService getEnPassantService() {
        if (enPassantService == null) enPassantService = new EnPassantService();
        return enPassantService;
    }


    public boolean move(Field start, Field target, GameData gameData) {
        return targetFieldContent(start, target, gameData)
                && targetFieldFormula(start, target, gameData.getPiece2DArray()[start.getY()][start.getX()]);
    }


    private boolean targetFieldContent(Field start, Field target, GameData gameData) {
        Piece[][] board = gameData.getPiece2DArray();

        if (board[target.getY()][target.getX()] == null) {
            Piece killedPiece = board[start.getY()][target.getX()];
            if (killedPiece != null) {
                if (killedPiece instanceof Pawn)
                    return ((Pawn) killedPiece).getSavedGameCounter() == gameData.getCounter() - 1;
            }
        }


        return false;

    }

    @Override
    public boolean targetFieldFormula(Field start, Field target, Piece pawn) {
        boolean rightLine = false;
        if(pawn.isBlack() && target.getY() == 5 || pawn.isWhite() && target.getY() == 2) rightLine = true;




        return super.targetFieldFormula(start, target, pawn) && rightLine;
    }
}

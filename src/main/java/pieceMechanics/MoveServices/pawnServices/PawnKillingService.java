package pieceMechanics.MoveServices.pawnServices;

import boardMechanics.Field;
import pieceMechanics.MoveServices.ColoredFormula;
import pieceMechanics.MoveServices.MoveServices;
import pieceMechanics.Piece;

public class PawnKillingService extends MoveServices implements ColoredFormula {
    private static PawnKillingService pawnKillingService= null;

    public static PawnKillingService getPawnKillingService(){
        if(pawnKillingService == null) pawnKillingService = new PawnKillingService();
        return pawnKillingService;
    }


    public boolean targetFieldFormula(Field start, Field target, Piece pawn) {
        if(start.getX() - target.getX() == 1 || start.getX() - target.getX() == -1){
            if(pawn.isWhite()) return start.getY() - target.getY() == 1;
            else if(pawn.isBlack()) return start.getY() - target.getY() == -1;
        }
    return false;
    }

    @Override
    public boolean move(Field start, Field target, Piece[][] board) {

        return targetFieldContent(start, target, board) && targetFieldFormula(start, target, board[start.getY()][start.getX()]);
    }


    @Override
    protected boolean targetFieldContent(Field start, Field target, Piece[][] board) {
        Piece targetPiece = board[target.getY()][target.getX()];
        Piece pawn = board[start.getY()][start.getX()];
        if(targetPiece != null){
            return targetPiece.isEnemy(pawn);
        }
        return false;
    }
}

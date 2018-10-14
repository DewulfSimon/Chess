package pieceMechanics.MoveServices;

import boardMechanics.Field;
import gameMechanics.GameData;
import pieceMechanics.Piece;
import pieceMechanics.pieces.Pawn;

public class PawnService extends MoveServices implements PawnFormula{

   private static  PawnService pawnService = null;

   public static PawnService getPawnService(){
       if(pawnService == null) pawnService = new PawnService();
       return pawnService;
   }

    /**
     * targetFieldContent is overridden here because Pawns ONLY move ahead when the targetField is empty
     * @param start startField
     * @param target the target location
     * @param board the piece[][] of this game
     * @return
     */
    @Override
    protected boolean targetFieldContent(Field start, Field target, Piece[][] board) {
        Piece targetPiece = board[target.getY()][target.getX()];
        Piece pawn = board[start.getY()][start.getX()];
        if(pawn.isWhite() && (start.getY() == 6 && target.getY() == 4))
        {
            Piece emptyRoad = board[5][start.getX()];
            if (emptyRoad != null)return false;
        }
        if(pawn.isBlack() && (start.getY() == 1 && target.getY() == 3) ){
            Piece emptyRoad = board[2][start.getX()];
            if (emptyRoad != null)return false;
        }

        return targetPiece == null;


    }

    @Override
    public boolean move(Field start, Field target, Piece[][] board) {
        Piece pawn = board[start.getY()][start.getX()];

       return targetFieldContent(start, target, board) && targetFieldFormula(start, target, pawn);
    }


    public boolean targetFieldFormula(Field start, Field target, Piece pawn) {
        if(start.getX() != target.getX()) return false;
        if(pawn.isWhite()){
            return(start.getY() - target.getY() == 1) || (start.getY() == 6 && target.getY() == 4);
        }else if(pawn.isBlack()){
            return (start.getY() - target.getY() == -1) || (start.getY() == 1 && target.getY() == 3);
        }


        return false;
    }
}

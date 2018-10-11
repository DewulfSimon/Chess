package pieceMechanics.MoveServices;

import boardMechanics.Field;
import gameMechanics.GameData;
import pieceMechanics.Piece;
import pieceMechanics.pieces.Pawn;

public class PawnService extends MoveServices {

   private static  PawnService pawnService = null;

   public static PawnService getPawnService(){
       if(pawnService == null) pawnService = new PawnService();
       return pawnService;
   }


    @Override
    boolean move(Field start, Field target, Piece[][] board) {

       return targetFieldContent(start, target, board) && targetFieldFormula(start, target);
    }

    @Override
    protected boolean targetFieldFormula(Field start, Field target) {
        return false;
    }
}

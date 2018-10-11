package pieceMechanics.MoveServices;

import boardMechanics.Field;
import pieceMechanics.Piece;
import pieceMechanics.pieces.King;

public class KingService extends MoveServices {
    static KingService kingService = null;


    public static KingService getKingService(){

        if(kingService == null){
            kingService = new KingService();
        }return kingService;


}



    @Override
   public boolean move(Field start, Field target,  Piece[][] board) {
        //todo: check how to implement CHECK methods
        return targetFieldFormula(start, target) && targetFieldContent(start, target, board);
    }

    @Override
    protected boolean targetFieldFormula(Field start, Field target) {
        return false;
    }
}

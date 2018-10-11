package pieceMechanics.MoveServices;

import boardMechanics.Field;
import pieceMechanics.Piece;
import pieceMechanics.pieces.Knight;


/**
 * provides methods for Knight Moves. wasn't really necessary but made it for consistency with other classes
 */
public class KnightService extends MoveServices{

   private static KnightService knightService = null;

    public static KnightService getKnightService(){
        if(knightService == null) knightService = new KnightService();
        return knightService;
    }


    @Override
    public boolean move(Field start, Field target, Piece[][] board) {
        return targetFieldFormula(start, target) && targetFieldContent(start, target, board);
    }

    @Override
    protected boolean targetFieldFormula(Field start, Field target) {
        /*
        X+2 Y+1
        X+2 Y-1
        X+1 Y+2
        X+1 Y-2
        X-1 Y+2
        X-1 Y-2
        X-2 Y+1
        X-2 Y-1
         */



        return false;
    }
}

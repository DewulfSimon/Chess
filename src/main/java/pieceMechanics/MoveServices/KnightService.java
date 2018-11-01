package pieceMechanics.MoveServices;

import boardMechanics.Field;
import pieceMechanics.Piece;


/**
 * provides methods for Knight Moves. wasn't really necessary but made it for consistency with other classes
 */
public class KnightService extends MoveServices implements PieceFormula {

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
    public boolean targetFieldFormula(Field start, Field target) {

        switch (target.getX()- start.getX()){

            case +1:
            case -1: switch (target.getY() - start.getY()){
                case +2:
                case -2: return true;
                default: break;

            }
                return false;
            case +2:
            case -2:switch (target.getY() - start.getY()){
                case +1:
                case -1: return true;
                default: break;
            }
            default: return false;
        }
    }
}

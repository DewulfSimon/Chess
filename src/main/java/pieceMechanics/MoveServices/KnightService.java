package pieceMechanics.MoveServices;

import boardMechanics.Field;
import pieceMechanics.pieces.Knight;


/**
 * provides methods for Knight Moves. wasn't really necessary but made it for consistency with other classes
 */
public class KnightService extends MoveServices{

    static KnightService knightService = null;

    public static KnightService getKnightService(){
        if(knightService == null) knightService = new KnightService();
        return knightService;
    }

    public void move(Field target){

    }

    @Override
    boolean move(Field start, Field target) {
        return false;
    }
}

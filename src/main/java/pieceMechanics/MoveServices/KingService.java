package pieceMechanics.MoveServices;

import boardMechanics.Field;
import pieceMechanics.pieces.King;

public class KingService extends MoveServices {
    static KingService kingService = null;


    public static KingService getKingService(){

        if(kingService == null){
            kingService = new KingService();
        }return kingService;


}



    @Override
   public boolean move(Field start, Field target) {
        return false;
    }
}

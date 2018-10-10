package pieceMechanics.MoveServices;

import boardMechanics.Field;
import pieceMechanics.pieces.Pawn;

public class PawnService extends MoveServices {

   static  PawnService pawnService = null;

   public PawnService pawnService(){
       if(pawnService == null) pawnService = new PawnService();
       return pawnService;
   }


    @Override
    boolean move(Field start, Field target) {
        return false;
    }
}

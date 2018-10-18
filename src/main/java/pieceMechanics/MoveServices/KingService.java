package pieceMechanics.MoveServices;

import boardMechanics.Field;
import pieceMechanics.Piece;

public class KingService extends MoveServices implements PieceFormula {
    static KingService kingService = null;

    public static KingService getKingService(){

        if(kingService == null){
            kingService = new KingService();
        }return kingService;
}
    @Override
   public boolean move(Field start, Field target,  Piece[][] board) {

        return targetFieldFormula(start, target) && targetFieldContent(start, target, board);
    }

    @Override
    public boolean targetFieldFormula(Field start, Field target) {
        int Ydifference = start.getY() - target.getY();
        int Xdifference = start.getX() - target.getX();

        return (Ydifference < 2 && Ydifference > -2) && (Xdifference < 2 && Xdifference > -2);
    }
}

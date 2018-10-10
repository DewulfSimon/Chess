package pieceMechanics.pieces;

import boardMechanics.Field;
import pieceMechanics.MoveServices.KingService;
import pieceMechanics.Piece;

public class King extends Piece {
    private KingService kingService;

    public King(Field field, String color, KingService kingService) {
        super(field, color);
        this.kingService = kingService;
    }



    public KingService getKingService() {
        return kingService;
    }


    @Override
    public void move(Field targetField) {

    }
}

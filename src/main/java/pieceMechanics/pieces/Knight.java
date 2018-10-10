package pieceMechanics.pieces;

import boardMechanics.Field;
import pieceMechanics.MoveServices.KnightService;
import pieceMechanics.Piece;



public class Knight extends Piece {
    private KnightService knightService;

    public Knight(Field field, String color, KnightService knightService) {
        super(field, color);
        this.knightService = knightService;
    }



    public KnightService getKnightService() {
        return knightService;
    }

    @Override
    public void move(Field targetField) {

    }
}

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

    @Override
    public String write() {
        if(this.isBlack()) return "N";
        else return "n";
    }

    public KnightService getKnightService() {
        return knightService;
    }
}

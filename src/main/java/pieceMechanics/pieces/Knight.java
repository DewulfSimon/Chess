package pieceMechanics.pieces;

import BoardMechanics.Location;
import pieceMechanics.MoveServices.KnightService;
import pieceMechanics.Piece;

public class Knight extends Piece {
    private KnightService knightService;

    public Knight(Location location, String color, KnightService knightService) {
        super(location, color);
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

package pieceMechanics.pieces;

import BoardMechanics.Location;
import pieceMechanics.MoveServices.StraightService;
import pieceMechanics.Piece;

public class Rook extends Piece {
    private StraightService straightService;

    public Rook(Location location, String color, StraightService straightService) {
        super(location, color);
        this.straightService = straightService;

    }


    public StraightService getStraightService() {
        return straightService;
    }
}

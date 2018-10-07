package pieceMechanics.pieces;

import BoardMechanics.Location;
import pieceMechanics.MoveServices.DiagonalService;
import pieceMechanics.MoveServices.StraightService;
import pieceMechanics.Piece;

public class Queen extends Piece {
    private DiagonalService diagonalService;
    private StraightService straightService;

    public Queen(Location location, String color, DiagonalService diagonalService, StraightService straightService) {

        super(location, color);
        this.diagonalService = diagonalService;
        this.straightService = straightService;
    }

    public DiagonalService getDiagonalService() {
        return diagonalService;
    }

    public StraightService getStraightService() {
        return straightService;
    }
}

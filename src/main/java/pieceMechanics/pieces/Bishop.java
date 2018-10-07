package pieceMechanics.pieces;

import BoardMechanics.Location;
import pieceMechanics.MoveServices.DiagonalService;
import pieceMechanics.Piece;

public class Bishop extends Piece {
    private DiagonalService diagonalService;

    public Bishop(Location location, String color, DiagonalService diagonalService) {
        super(location, color);
        this.diagonalService = diagonalService;
    }

    public DiagonalService getDiagonalService() {
        return diagonalService;
    }
}

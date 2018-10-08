package pieceMechanics.pieces;

import boardMechanics.Field;
import pieceMechanics.MoveServices.DiagonalService;
import pieceMechanics.MoveServices.StraightService;
import pieceMechanics.Piece;

public class Queen extends Piece {
    private DiagonalService diagonalService;
    private StraightService straightService;

    public Queen(Field field, String color, DiagonalService diagonalService, StraightService straightService) {

        super(field, color);
        this.diagonalService = diagonalService;
        this.straightService = straightService;
    }

    @Override
    public String write() {
        if(this.isBlack())
        return "Q";
        else return "q";
    }

    public DiagonalService getDiagonalService() {
        return diagonalService;
    }

    public StraightService getStraightService() {
        return straightService;
    }
}

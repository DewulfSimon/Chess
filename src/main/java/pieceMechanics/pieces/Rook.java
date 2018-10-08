package pieceMechanics.pieces;

import boardMechanics.Field;
import pieceMechanics.MoveServices.StraightService;
import pieceMechanics.Piece;

public class Rook extends Piece {
    private StraightService straightService;

    public Rook(Field field, String color, StraightService straightService) {
        super(field, color);
        this.straightService = straightService;

    }

    public String write(){
        if(this.isBlack()) return "R";
        else return "r";
    }

    public StraightService getStraightService() {
        return straightService;
    }
}

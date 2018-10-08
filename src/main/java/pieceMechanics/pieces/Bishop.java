package pieceMechanics.pieces;

import boardMechanics.Field;
import pieceMechanics.MoveServices.DiagonalService;
import pieceMechanics.Piece;

public class Bishop extends Piece {
    private DiagonalService diagonalService;

    public Bishop(Field field, String color, DiagonalService diagonalService) {
        super(field, color);
        this.diagonalService = diagonalService;
    }

    public DiagonalService getDiagonalService() {
        return diagonalService;
    }

    public String write(){
        if(this.isBlack()){
            return "B";
        }else return "b";

    }
}

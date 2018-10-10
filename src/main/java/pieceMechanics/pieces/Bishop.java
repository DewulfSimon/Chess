package pieceMechanics.pieces;

import boardMechanics.Field;
import pieceMechanics.MoveServices.DiagonalService;
import pieceMechanics.Piece;

public class Bishop extends Piece {
    private DiagonalService diagonalService;

    public Bishop(Field field, String color) {
        super(field, color);
        this.diagonalService = DiagonalService.getDiagonalService();

    }

    @Override
    public void move(Field targetField) {
        if(diagonalService.move(this.getField(), targetField)){

            this.setField(targetField);
            this.setSelected(false);


        }

    }
}

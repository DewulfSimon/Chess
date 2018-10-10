package pieceMechanics.pieces;

import boardMechanics.Field;
import pieceMechanics.MoveServices.DiagonalService;
import pieceMechanics.MoveServices.TranslationalService;
import pieceMechanics.Piece;


public class Queen extends Piece {

    private DiagonalService diagonalService;
    private TranslationalService translationalService;

    public Queen(Field field, String color, DiagonalService diagonalService, TranslationalService translationalService) {

        super(field, color);
        this.diagonalService = diagonalService;
        this.translationalService = translationalService;
    }



    public DiagonalService getDiagonalService() {
        return diagonalService;
    }

    public TranslationalService getTranslationalService() {
        return translationalService;
    }

    @Override
    public void move(Field targetField) {

    }
}

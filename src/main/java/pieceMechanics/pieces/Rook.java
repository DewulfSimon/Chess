package pieceMechanics.pieces;

import boardMechanics.Field;
import pieceMechanics.MoveServices.TranslationalService;
import pieceMechanics.Piece;


public class Rook extends Piece {
    private TranslationalService translationalService;

    public Rook(Field field, String color, TranslationalService translationalService) {
        super(field, color);
        this.translationalService = translationalService;

    }



    public TranslationalService getTranslationalService() {
        return translationalService;
    }

    @Override
    public void move(Field targetField) {

    }
}

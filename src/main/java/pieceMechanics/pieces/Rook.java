package pieceMechanics.pieces;

import boardMechanics.Field;
import gameMechanics.GameData;
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
    public boolean selectionCriteria(Field target, GameData gamedata) {
        return translationalService.move(this.getField(), target, gamedata.getPiece2DArray());
    }
}

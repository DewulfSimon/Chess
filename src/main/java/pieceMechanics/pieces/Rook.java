package pieceMechanics.pieces;

import boardMechanics.Field;
import gameMechanics.GameData;
import pieceMechanics.MoveServices.TranslationalService;
import pieceMechanics.Piece;


public class Rook extends Piece {
    private TranslationalService translationalService;
    private boolean hasMoved = false;

    public Rook(Field field, String color) {
        super(field, color);
        this.translationalService = TranslationalService.getTranslationalService();

    }



    public TranslationalService getTranslationalService() {
        return translationalService;
    }

    @Override
    public boolean selectionCriteria(Field target, GameData gamedata) {
        return translationalService.move(this.getField(), target, gamedata.getPiece2DArray());
    }


    public Rook setTranslationalService(TranslationalService translationalService) {
        this.translationalService = translationalService;
        return this;
    }

    public boolean hasNotMoved() {
        return !hasMoved;
    }

    private void setHasMoved() {
        this.hasMoved = true;

    }

    @Override
    public void move(Field targetField, GameData gameData) {
        super.move(targetField, gameData);
        if(!hasMoved && this.getField().compareField(targetField)) {

            this.setHasMoved();
        }
    }

    @Override
    public String getText() {
        return "Rook";
    }
}

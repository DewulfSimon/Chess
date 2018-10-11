package pieceMechanics.pieces;

import boardMechanics.Field;
import gameMechanics.GameData;
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
    public boolean selectionCriteria(Field target, GameData gamedata) {
        if(this.getField().getX() == target.getX() || this.getField().getY() == target.getY())
            return translationalService.move(this.getField(), target, gamedata.getPiece2DArray());
        else return diagonalService.move(this.getField(), target, gamedata.getPiece2DArray());
    }
}

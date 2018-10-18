package pieceMechanics.pieces;

import boardMechanics.Field;
import gameMechanics.GameData;
import pieceMechanics.MoveServices.KingService;
import pieceMechanics.Piece;

public class King extends Piece {
    private KingService kingService;
    private Rook kingSideRook;
    private Rook queenSideRook;

    public King(Field field, String color, Rook kingSideRook, Rook queenSideRook) {
        super(field, color);
        this.kingService = KingService.getKingService();
        this.kingSideRook = kingSideRook;
        this.queenSideRook = queenSideRook;
    }



    public KingService getKingService() {
        return kingService;
    }


    @Override
    public boolean selectionCriteria(Field target, GameData gamedata) {
        return kingService.move(this.getField(), target, gamedata.getPiece2DArray());
    }
}

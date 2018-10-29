package pieceMechanics.pieces;

import boardMechanics.Field;
import gameMechanics.GameData;
import pieceMechanics.MoveServices.CastleService;
import pieceMechanics.MoveServices.KingService;
import pieceMechanics.Piece;

public class King extends Piece {
    private KingService kingService;
    private CastleService castleService;
    private boolean hasMoved = false;
    private Rook kingSideRook;
    private Rook queenSideRook;


    public King(Field field, String color, Rook kingSideRook, Rook queenSideRook) {
        super(field, color);
        this.kingService = KingService.getKingService();
        this.castleService = CastleService.getCastleService();
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

    @Override
    public void move(Field targetField, GameData gameData) {
        if(castleService.move(this.getField(), targetField, gameData)){
            this.castle(this.getField(), targetField, gameData);
        }
       else super.move(targetField, gameData);
        if(!hasMoved && this.getField().compareField(targetField)) this.setHasMoved();

    }

    private void castle(Field field, Field targetField, GameData gameData) {
        //todo: make the king move to targetField, arrangePieceArray, make right rook move to right field and arrangePieceArray;
        //todo: no need for any killing pieces or anything of the like
        //todo: do not forget to increase the COUNTER

    }

    public boolean isHasMoved() {
        return hasMoved;
    }

    private void setHasMoved() {
        this.hasMoved = true;

    }

    public Rook getKingSideRook() {
        return kingSideRook;
    }

    public Rook getQueenSideRook() {
        return queenSideRook;
    }
}

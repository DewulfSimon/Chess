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

    private void castle(Field startField, Field targetField, GameData gameData) {

        this.setField(targetField);
        Rook movingRook;
        Field movingRookStartField;
        if(castleService.isQueenSide(startField, targetField)){
            movingRook = this.getQueenSideRook();
            movingRookStartField = movingRook.getField();
            if(this.isBlack()){
                movingRook.setField(new Field(3,0));
            }else movingRook.setField(new Field(3,7));
        }else{
            movingRook = this.getKingSideRook();
            movingRookStartField = movingRook.getField();
            if(this.isBlack()){
                movingRook.setField(new Field(5,0));
            }else movingRook.setField(new Field(5,7));
        }
        gameData.arrangePieceArray(movingRook, movingRookStartField);
        gameData.arrangePieceArray(this, startField);
        gameData.setCounter(gameData.getCounter() + 1);

        this.setSelected(false);



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

    @Override
    public String getText() {
        return "King";
    }
}

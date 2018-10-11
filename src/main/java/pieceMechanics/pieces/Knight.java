package pieceMechanics.pieces;


import boardMechanics.Field;
import gameMechanics.GameData;
import pieceMechanics.MoveServices.KnightService;
import pieceMechanics.Piece;



public class Knight extends Piece {
    private KnightService knightService;

    public Knight(Field field, String color, KnightService knightService) {
        super(field, color);
        this.knightService = knightService;
    }



    public KnightService getKnightService() {
        return knightService;
    }

    @Override
    public boolean selectionCriteria(Field target, GameData gamedata) {
        return knightService.move(this.getField(), target, gamedata.getPiece2DArray());
    }
}

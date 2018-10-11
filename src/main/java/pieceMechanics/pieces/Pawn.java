package pieceMechanics.pieces;

import boardMechanics.Field;
import gameMechanics.GameData;
import pieceMechanics.MoveServices.PawnService;
import pieceMechanics.Piece;

public class Pawn extends Piece {
    private PawnService pawnService;


    public Pawn(Field field, String color, PawnService pawnService) {
        super(field, color);
        this.pawnService = pawnService;
    }



    public PawnService getPawnService() {
        return pawnService;
    }

    @Override
    public boolean selectionCriteria(Field target, GameData gamedata) {
        return false;
    }

    @Override
    public void move(Field target, GameData gameData) {
this.setSelected(false);
    }
}

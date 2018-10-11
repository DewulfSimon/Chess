package pieceMechanics.pieces;

import GUI.Game;
import boardMechanics.Field;
import gameMechanics.GameData;
import pieceMechanics.MoveServices.DiagonalService;
import pieceMechanics.Piece;

public class Bishop extends Piece {
    private DiagonalService diagonalService;

    public Bishop(Field field, String color, DiagonalService diagonalService) {
        super(field, color);
        this.diagonalService = diagonalService;

    }

    @Override
    public boolean selectionCriteria(Field target, GameData gameData) {
        return diagonalService.move(this.getField(), target, gameData.getPiece2DArray());
    }
}

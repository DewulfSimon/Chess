package pieceMechanics.pieces;


import boardMechanics.Field;
import gameMechanics.GameData;
import pieceMechanics.MoveServices.DiagonalService;
import pieceMechanics.Piece;

public class Bishop extends Piece {
    private DiagonalService diagonalService;

    public Bishop(Field field, String color) {
        super(field, color);
        this.diagonalService = DiagonalService.getDiagonalService();

    }

    @Override
    public boolean selectionCriteria(Field target, GameData gameData) {
        return diagonalService.move(this.getField(), target, gameData.getPiece2DArray());
    }
}

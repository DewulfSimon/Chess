package boardMechanics;

import gameMechanics.GameData;
import pieceMechanics.Piece;

public class Field {
    private int x;
    private int y;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isUnderAttack(GameData gameData) {
        Piece[][] board = gameData.getPiece2DArray();
        Piece attacker;

        for (Piece[] pieces : board) {
            for (Piece piece : pieces) {
                if (piece != null) {
                    if (piece.selectionCriteria(this, gameData) && !piece.myTurn(gameData))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean compareField(Field b){
        return this.getX() == b.getX() && this.getY() == b.getY();
    }


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }
}

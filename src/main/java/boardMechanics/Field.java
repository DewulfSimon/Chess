package boardMechanics;

import gameMechanics.Game;
import pieceMechanics.Piece;

public class Field {
    private int x;
    private int y;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isLocationTaken(Game game){

        for (Piece piece : game.getPieces()) {
            if(this.compareLocation(piece.getField())) return true;
        }

        return false;
    }

    private boolean compareLocation(Field a){

        return this.x == a.x && this.y == a.y;
    }

    public boolean isOnBoard(){

        return this.x > 2 && this.x < 9 && this.y > 2 && this.y < 9;
    }


    public int getX() {
        return x;
    }

    public Field setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() {
        return y;
    }

    public Field setY(int y) {
        this.y = y;
        return this;
    }
}

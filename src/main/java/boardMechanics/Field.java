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

   public boolean isUnderAttack(GameData gameData){

        Piece[][] board = gameData.getPiece2DArray();


        for(int i = 0; i<8; i++) {
            for (int j = 0; j<8; j++) {
                try {

                    Piece attacker = board[i][j];
                     if(attacker.selectionCriteria(this, gameData)) return true;

                } catch (NullPointerException ignore) {}
            }
        }

        return false;
   }



    public int getX() {
        return x;
    }



    public int getY() {
        return y;
    }




}

package pieceMechanics.MoveServices;

import boardMechanics.Field;
import pieceMechanics.Piece;

/**
 * provides methods for Diagonal movement to Queens and Bishops
 */

public class DiagonalService extends LongGroundMoverService {
   private static DiagonalService diagonalService = null;



    public static DiagonalService getDiagonalService(){
        if(diagonalService == null)
        diagonalService = new DiagonalService();

        return  diagonalService;

        }

    @Override
    protected boolean emptyRoad(Field start, Field target, Piece[][] board) {


        if(target.getX() > start.getX() && start.getY() != target.getY()) {
            //X > X Y > Y
            if (target.getY() > start.getY()) return moveDownRight(start, target, board);
            //X > X Y < Y
            else return moveUpRight(start, target, board);
        }else if(target.getX() < start.getX() && start.getY() != target.getY()){
            //X < X Y > Y
            if (target.getY() > start.getY()) return moveDownLeft(start, target, board);
                //X < X Y < Y
            else return moveUpLeft(start, target, board);
        }





        //X < X Y < Y


        return false;
    }

    private boolean moveUpLeft(Field start, Field target, Piece[][] board) {
        //X > X Y > Y
        for(int i = start.getX()-1, j = start.getY()-1; i>target.getX(); i--, j--){
            if(j>target.getY())
            if(board[j][i] != null) return false;
        }
        return true;
    }

    private boolean moveDownLeft(Field start, Field target, Piece[][] board) {
        for(int i = start.getX()-1, j = start.getY()+1; i>target.getX(); i--, j++){
            if(j<target.getY())
            if(board[j][i] != null) return false;
        }
        return true;
    }

    private boolean moveUpRight(Field start, Field target, Piece[][] board) {
        for(int i = start.getX()+1, j = start.getY()-1; i<target.getX(); i++, j--){
            if(j>target.getY())
            if(board[j][i] != null)
                return false;
        }
        return true;
    }

    private boolean moveDownRight(Field start, Field target, Piece[][] board) {
        for(int i = start.getX()+1, j = start.getY()+1; i<target.getX(); i++, j++){
            if(j<target.getY())
            if(board[j][i] != null)
                return false;
        }
        return true;

    }


    @Override
    public boolean targetFieldFormula(Field start, Field target) {
        return (start.getX() - target.getX() == start.getY() - target.getY())
                || (start.getX() - target.getX() == (start.getY() - target.getY())*-1);
    }
}

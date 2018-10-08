package pieceMechanics.MoveServices;

import boardMechanics.Field;
import pieceMechanics.Piece;

/**
 * provides methods for Diagonal movement to Queens and Bishops
 */

public class DiagonalService extends MoveServices {
    static DiagonalService diagonalService = null;

    private DiagonalService(Piece piece) {
        super(piece);
    }

    public static DiagonalService getInstance(){
        if(diagonalService == null)
        diagonalService = new DiagonalService(null);

        return  diagonalService;

        }

        public void move(Field start, Field target){
        if(start.getX() > target.getX()){
            if(start.getY() > target.getY()){

            }
            else if(start.getY() < target.getY()){

            }
        }else if (start.getX() < target.getX()){
            if(start.getY() > target.getY()){

            }


            else if(start.getY()< target.getY()){

            }
        }
        else System.out.println(" not a valid bishopMove");
        }







}

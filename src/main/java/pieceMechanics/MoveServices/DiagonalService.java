package pieceMechanics.MoveServices;

import boardMechanics.Field;
import pieceMechanics.Piece;

/**
 * provides methods for Diagonal movement to Queens and Bishops
 */

public class DiagonalService extends MoveServices {
    static DiagonalService diagonalService = null;



    public static DiagonalService getDiagonalService(){
        if(diagonalService == null)
        diagonalService = new DiagonalService();

        return  diagonalService;

        }




    @Override
    public boolean move( Field start, Field target) {
        return false;
    }
}

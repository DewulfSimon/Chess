package pieceMechanics.MoveServices;


import boardMechanics.Field;
import pieceMechanics.Piece;

public class StraightService extends MoveServices {

    /**
     * provides Translational movement to Rooks and Queens
     *
     */

    public StraightService(Piece piece) {
        super(piece);
    }

    public void moveUp(){

        int vertical = this.getPiece().getField().getY();
        int horizontal = this.getPiece().getField().getX();


        this.getPiece().setField(new Field(3,4));
        System.out.println("moved up");


    }
}

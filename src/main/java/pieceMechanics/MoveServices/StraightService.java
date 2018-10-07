package pieceMechanics.MoveServices;


import BoardMechanics.Location;
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

        int vertical = this.getPiece().getLocation().getY();
        int horizontal = this.getPiece().getLocation().getX();


        this.getPiece().setLocation(new Location(3,4));
        System.out.println("moved up");


    }
}

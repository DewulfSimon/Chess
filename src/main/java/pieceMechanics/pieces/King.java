package pieceMechanics.pieces;

import BoardMechanics.Location;
import pieceMechanics.MoveServices.KingService;
import pieceMechanics.Piece;

public class King extends Piece {
    private KingService kingService;

    public King(Location location, String color, KingService kingService) {
        super(location, color);
        this.kingService = kingService;
    }

    @Override
    public String write() {
        if(this.isBlack()) return "K";
        else return "k";
    }

    public KingService getKingService() {
        return kingService;
    }


}

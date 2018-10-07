package pieceMechanics;

import BoardMechanics.Location;

public abstract class Piece {
    private Location location;
    private String color;

    public Piece(Location location, String color) {
        this.location = location;
        this.color = color;
    }

    private boolean isWhite(){

        return this.color.equals("White");

    }

    private boolean isBlack(){

        return this.color.equals("Black");
    }

    public boolean isEnemy(Piece a){


        return this.isBlack() && a.isBlack()
                || this.isWhite() && a.isWhite();
    }

    public Location getLocation() {
        return location;
    }

    public Piece setLocation(Location location) {
        this.location = location;
        return this;
    }



}

package pieceMechanics;

import boardMechanics.Field;

public abstract class Piece {
    private Field field;
    private String color;

    public Piece(Field field, String color) {
        this.field = field;
        this.color = color;
    }

    protected boolean isWhite(){

        return this.color.equals("White");

    }

   public abstract String write();

    protected boolean isBlack(){

        return this.color.equals("Black");
    }

    public boolean isEnemy(Piece a){


        return this.isBlack() && a.isBlack()
                || this.isWhite() && a.isWhite();
    }

    public Field getField() {
        return field;
    }

    public Piece setField(Field field) {
        this.field = field;
        return this;
    }



}

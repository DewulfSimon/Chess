package pieceMechanics;

import boardMechanics.Field;


public abstract class Piece {
    private Field field;
    private String color;
    private boolean isSelected = false;
    private boolean isAlive = true;

    public Piece(Field field, String color) {
        this.field = field;
        this.color = color;
    }

    public abstract void move(Field targetField);

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

    public Field getField() {
        return field;
    }

    public Piece setField(Field field) {
        this.field = field;
        return this;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public Piece setSelected(boolean selected) {
        isSelected = selected;
        return this;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public Piece kill() {
        isAlive = false;


        return this;
    }
}

package pieceMechanics;

import boardMechanics.Field;
import gameMechanics.GameData;


public abstract class Piece {
    private Field field;
    private String color;
    private boolean isSelected = false;
    private boolean isAlive = true;
    private Piece piece;

    public Piece(Field field, String color) {
        this.field = field;
        this.color = color;
    }


    public void move(Field targetField, GameData gameData){

        if(selectionCriteria(targetField, gameData) && myTurn(gameData)) {
            if (gameData.kingIsSafe(this, targetField)) {

                gameData.killIfEnemy(targetField);

                Field startField = this.field;
                this.setField(targetField);

                gameData.arrangePieceArray(this, startField);
                gameData.setCounter(gameData.getCounter() + 1);

            }
        }
        this.setSelected(false);

        if(gameData.checkMateOrStaleMate()) {
            System.out.println("GAME OVER");

        }

    }



    public boolean myTurn(GameData gameData) {
        return ((this.isWhite() && gameData.turnOfWhite())|| (this.isBlack() && gameData.turnOfBlack()));
    }

    public boolean isWhite(){

        return this.color.equals("White");

    }



    public boolean isBlack(){

        return this.color.equals("Black");
    }

    public boolean isEnemy(Piece a){


        return this.isBlack() && a.isWhite()
                || this.isWhite() && a.isBlack();
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
        this.isSelected = selected;
        return this;
    }

    public String getColor() {
        return color;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public Piece kill() {
        this.isAlive = false;
        this.field = null;

        return this;
    }

    public Piece setAlive(boolean alive) {
        isAlive = alive;
        return this;
    }

    public abstract boolean selectionCriteria(Field target, GameData gamedata);

    public abstract String getText();
}

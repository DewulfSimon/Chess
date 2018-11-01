package actionListeners;

import GUI.Grid;
import boardMechanics.Field;
import gameMechanics.GameData;


public class ActionVariableProvider {
    private String color;
    private Field field;
    private GameData gameData;
    private Field startField;
    private Grid grid;

    private static ActionVariableProvider instance = new ActionVariableProvider();
    public static ActionVariableProvider getActionVariableProvider() {

        return instance;
    }

    private ActionVariableProvider(){}



     Field getStartField() {
        return startField;
    }

    public ActionVariableProvider setStartField(Field startField) {
        this.startField = startField;
        return this;
    }

     String getColor() {
        return color;
    }

    public ActionVariableProvider setColor(String color) {
        this.color = color;
        return this;
    }

    public Field getField() {
        return field;
    }

    public ActionVariableProvider setField(Field field) {
        this.field = field;
        return this;
    }

    public GameData getGameData() {
        return gameData;
    }

    public ActionVariableProvider setGameData(GameData gameData) {
        this.gameData = gameData;
        return this;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Grid getGrid() {
        return grid;
    }
}

package GUI;

import actionListeners.ActionVariableProvider;
import gameMechanics.GameData;

public class Game {
    public Game() {
        GameData gameData = new GameData();
        Grid grid = new Grid(gameData);
        ActionVariableProvider actionVariableProvider = ActionVariableProvider.getActionVariableProvider();
        actionVariableProvider.setGrid(grid);
        gameData.startGame();
    }
}

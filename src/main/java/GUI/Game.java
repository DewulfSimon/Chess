package GUI;

import gameMechanics.GameData;

//@ApplicationScoped
public class Game {
    GameData gameData;
    Grid grid;
    public Game() {
        this.gameData = new GameData();
        this.grid = new Grid(gameData);
    }
}

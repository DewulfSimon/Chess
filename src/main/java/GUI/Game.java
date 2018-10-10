package GUI;

import gameMechanics.GameLogic;

//@ApplicationScoped
public class Game {
    GameLogic gameLogic;
    Grid grid;
    public Game() {
        this.gameLogic = new GameLogic();
        this.grid = new Grid(gameLogic);
    }
}

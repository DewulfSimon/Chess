
import gameMechanics.Game;


public class Play {
    public static void main(String[] args) {

       Game game = new Game();

//todo: need solution for fast location tracking. not about to loop over every single piece every time i need to do something simple again

      game.createPrintBoard();
      game.createPieces();
      game.showBoard();



    }
}

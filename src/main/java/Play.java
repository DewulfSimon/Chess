
import gameMechanics.Game;
import pieceMechanics.Piece;


import java.util.ArrayList;

public class Play {
    public static void main(String[] args) {

       Game game = new Game();



        game.createPieces();

        ArrayList<Piece> testPieces = game.getPieces();

        System.out.println(testPieces.size());

        for(int i = 0; i <32; i++){
            System.out.print(testPieces.get(i).getLocation().getX());
            System.out.print(testPieces.get(i).getLocation().getY());
            System.out.println();



        }





    }
}

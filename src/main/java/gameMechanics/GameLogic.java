package gameMechanics;

import pieceMechanics.Piece;

import java.util.ArrayList;

public class GameLogic {

    //todo keep pieces & board updated together. they are your interface
    //todo: make Singletons from your MoveServices. you only need one each
    //todo: put console output in ConsoleOUtput class;

   // private ArrayList<Piece> pieces = new ArrayList<>();
    private Piece[][] Piece2DArray = new Piece[8][8];
    private ArrayList<Piece> deadPieces = new ArrayList<>();


    public Piece[][] getPiece2DArray() {
        return Piece2DArray;
    }

    public GameLogic setPiece2DArray(Piece[][] piece2DArray) {
        Piece2DArray = piece2DArray;
        return this;
    }
}


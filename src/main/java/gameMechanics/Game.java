package gameMechanics;

import pieceMechanics.Piece;

import java.util.ArrayList;

public class Game {

    //todo keep pieces & board updated together. they are your interface
    //todo: make Singletons from your MoveServices. you only need one each
    //todo: put console output in ConsoleOUtput class;

    private ArrayList<Piece> pieces = new ArrayList<>();
    private Piece[][] Piece2DArray = new Piece[8][8];

    private ArrayList<Piece> deadPieces = new ArrayList<>();
    private String[][] printBoard = new String[12][20];

    public void createPrintBoard() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 12; j++) {
                printBoard[j][i] = " ";
            }
        }

        //letters and numbers for side of the board

        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8"};

        for (int i = 0; i < 12; i += 11) {
            for (int j = 2; j < 10; j++) {
            printBoard[j][i] = numbers[j-2];
            printBoard[i][j] = letters[j-2];
            }
        }

        //stars for empty board fields

        for(int i = 2; i<=9; i++){
            for (int j = 2; j<=9; j++)
            {
                printBoard[i][j] = "*";
            }
        }
    }

    public void writeBoard() {



    }

    public void showBoard() {

        for (Piece piece : pieces) {
            printBoard[piece.getField().getY()][piece.getField().getX()] = piece.write();
        }
        for (String[] aPrintBoard : printBoard) {
            for (int j = 0; j < 20; j++) {
                System.out.print(aPrintBoard[j]);
                System.out.print("  ");
            }
            System.out.println();
        }


    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public Game setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
        return this;
    }

 //   public ArrayList<Field> getBoard() {
 //       return board;
 //   }

 //  public Game setBoard(ArrayList<Field> board) {
 //      this.board = board;
 //      return this;
 //  }


}


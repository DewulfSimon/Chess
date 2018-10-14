package gameMechanics;

import boardMechanics.Field;
import pieceMechanics.MoveServices.*;
import pieceMechanics.Piece;
import pieceMechanics.pieces.*;

import java.util.ArrayList;

public class GameData {

   // private ArrayList<Piece> pieces = new ArrayList<>();
    private Piece[][] piece2DArray;

    private int counter = 0;

    private ArrayList<Piece> deadPieces = new ArrayList<>();

    public GameData() {
        this.piece2DArray = new Piece[8][8];
        startGame();
    }

    public Piece[][] getPiece2DArray() {
        return piece2DArray;
    }



    public void killIfEnemy(Field target){
        Piece victim = getPiece2DArray()[target.getY()][target.getX()];
        if(victim != null){
            victim.kill();
            piece2DArray[target.getY()][target.getX()] = null;
            deadPieces.add(victim);
            System.out.println("killed something");
        }
    }

    private void startGame() {

        createCastlers();
        createKnights();
        createBishops();
        createQueens();
        createPawns();

    }

    private void createPawns() {
        for(int i = 0; i<8; i++) {
            for (int j = 1; j <= 6; j += 5) {
                if (j == 1) arrangePieceArray(new Pawn(new Field(i, j), "Black"));
                else arrangePieceArray(new Pawn(new Field(i, j), "White"));
            }
        }
        }


    private void createQueens() {
        Queen whiteQueen = new Queen(new Field(3,7), "White", DiagonalService.getDiagonalService(), TranslationalService.getTranslationalService());
        Queen blackQueen = new Queen(new Field(3,0), "Black", DiagonalService.getDiagonalService(), TranslationalService.getTranslationalService());

        this.arrangePieceArray(whiteQueen);
        this.arrangePieceArray(blackQueen);
    }

    private void createBishops() {
        Bishop blackQueenSideBishop = new Bishop(new Field(2,0), "Black", DiagonalService.getDiagonalService());
        Bishop blackKingSideBishop = new Bishop(new Field(5,0), "Black", DiagonalService.getDiagonalService());

        Bishop whiteQueenSideBishop = new Bishop(new Field(2,7), "White", DiagonalService.getDiagonalService());
        Bishop whiteKingSideBishop = new Bishop(new Field(5,7), "White", DiagonalService.getDiagonalService());

        this.arrangePieceArray(blackKingSideBishop);
        this.arrangePieceArray(blackQueenSideBishop);
        this.arrangePieceArray(whiteKingSideBishop);
        this.arrangePieceArray(whiteQueenSideBishop);

    }

    private void createKnights() {
        Knight blackQueenSideKnight = new Knight(new Field(1, 0),"Black", KnightService.getKnightService());
        Knight blackKingSideKnight = new Knight(new Field(6, 0),"Black", KnightService.getKnightService());

        Knight whiteQueenSideKnight = new Knight(new Field(1, 7),"White", KnightService.getKnightService());
        Knight whiteKingSideKnight = new Knight(new Field(6,7), "White", KnightService.getKnightService());

        this.arrangePieceArray(blackKingSideKnight);
        this.arrangePieceArray(blackQueenSideKnight);
        this.arrangePieceArray(whiteKingSideKnight);
        this.arrangePieceArray(whiteQueenSideKnight);
    }

    private void createCastlers() {
        Rook blackQueenSideRook = new Rook(new Field(0,0), "Black", TranslationalService.getTranslationalService());
        Rook blackKingSideRook = new Rook(new Field(7,0), "Black", TranslationalService.getTranslationalService());

        Rook whiteQueenSideRook = new Rook(new Field(0,7), "White", TranslationalService.getTranslationalService());
        Rook whiteKingSideRook = new Rook(new Field(7,7), "White" ,TranslationalService.getTranslationalService());

        King whiteKing = new King(new Field(4,7), "White", KingService.getKingService(), whiteKingSideRook, whiteQueenSideRook);
        King blackKing = new King(new Field(4,0), "Black", KingService.getKingService(), blackKingSideRook, blackQueenSideRook);

        this.arrangePieceArray(blackKingSideRook);
        this.arrangePieceArray(blackQueenSideRook);
        this.arrangePieceArray(whiteKingSideRook);
        this.arrangePieceArray(whiteQueenSideRook);

        this.arrangePieceArray(whiteKing);
        this.arrangePieceArray(blackKing);
    }

    /**
     * clears the old location on the matrix
     * puts the Piece on the same indexes of the array as the Field object of said Piece
     * @param movingPiece
     */
    public void arrangePieceArray(Piece movingPiece, Field startField){

        this.piece2DArray[startField.getY()][startField.getX()] = null;
        this.piece2DArray[movingPiece.getField().getY()][movingPiece.getField().getX()] = movingPiece;

    }

    public void arrangePieceArray(Piece createdPiece){
        this.piece2DArray[createdPiece.getField().getY()][createdPiece.getField().getX()] = createdPiece;
    }

    public boolean turnOfWhite(){
        return counter%2 ==0;
    }

    public boolean turnOfBlack(){
        return counter%2 ==1;
    }

    public int getCounter() {
        return counter;
    }

    public GameData setCounter(int counter) {
        this.counter = counter;
        return this;
    }
}


package gameMechanics;

import actionListeners.ActionVariableProvider;
import boardMechanics.Field;
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
        this.deadPieces.add(null);
        this.deadPieces.add(null);

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

        }
    }

    private void resurrect(Field rebirth){
        Piece jesus = deadPieces.get(deadPieces.size()-1);
        jesus.setField(rebirth);
        jesus.setAlive(true);
        arrangePieceArray(jesus);
        deadPieces.remove(jesus);
    }

    public void startGame() {

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
        Queen whiteQueen = new Queen(new Field(3,7), "White");
        Queen blackQueen = new Queen(new Field(3,0), "Black");

        this.arrangePieceArray(whiteQueen);
        this.arrangePieceArray(blackQueen);
    }

    private void createBishops() {
        Bishop blackQueenSideBishop = new Bishop(new Field(2,0), "Black");
        Bishop blackKingSideBishop = new Bishop(new Field(5,0), "Black");

        Bishop whiteQueenSideBishop = new Bishop(new Field(2,7), "White");
        Bishop whiteKingSideBishop = new Bishop(new Field(5,7), "White");

        this.arrangePieceArray(blackKingSideBishop);
        this.arrangePieceArray(blackQueenSideBishop);
        this.arrangePieceArray(whiteKingSideBishop);
        this.arrangePieceArray(whiteQueenSideBishop);

    }

    private void createKnights() {
        Knight blackQueenSideKnight = new Knight(new Field(1, 0),"Black");
        Knight blackKingSideKnight = new Knight(new Field(6, 0),"Black");

        Knight whiteQueenSideKnight = new Knight(new Field(1, 7),"White");
        Knight whiteKingSideKnight = new Knight(new Field(6,7), "White");

        this.arrangePieceArray(blackKingSideKnight);
        this.arrangePieceArray(blackQueenSideKnight);
        this.arrangePieceArray(whiteKingSideKnight);
        this.arrangePieceArray(whiteQueenSideKnight);
    }

    private void createCastlers() {
        Rook blackQueenSideRook = new Rook(new Field(0,0), "Black");
        Rook blackKingSideRook = new Rook(new Field(7,0), "Black");

        Rook whiteQueenSideRook = new Rook(new Field(0,7), "White");
        Rook whiteKingSideRook = new Rook(new Field(7,7), "White" );

        King whiteKing = new King(new Field(4,7), "White",  whiteKingSideRook, whiteQueenSideRook);
        King blackKing = new King(new Field(4,0), "Black",  blackKingSideRook, blackQueenSideRook);

        this.arrangePieceArray(blackKingSideRook);
        this.arrangePieceArray(blackQueenSideRook);
        this.arrangePieceArray(whiteKingSideRook);
        this.arrangePieceArray(whiteQueenSideRook);

        this.arrangePieceArray(whiteKing);
        this.arrangePieceArray(blackKing);
    }


    public void arrangePieceArray(Piece movingPiece, Field startField){

        this.piece2DArray[startField.getY()][startField.getX()] = null;
        this.piece2DArray[movingPiece.getField().getY()][movingPiece.getField().getX()] = movingPiece;

        ActionVariableProvider.getActionVariableProvider().getGrid().arrangeButtonText(movingPiece, startField);
    }

    private void arrangePieceArray(Piece createdPiece){
        this.piece2DArray[createdPiece.getField().getY()][createdPiece.getField().getX()] = createdPiece;
        ActionVariableProvider.getActionVariableProvider().getGrid().arrangeButtonText(createdPiece);
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

    public boolean kingIsSafe(Piece moveCandidate, Field target) {

        Field startField = moveCandidate.getField();
        boolean didAKill = piece2DArray[target.getY()][target.getX()] != null;
        if(didAKill){
            killIfEnemy(target);

        }
        moveCandidate.setField(target);
        arrangePieceArray(moveCandidate, startField);
        boolean canDoMove = true;

        for (Piece[] pieces : piece2DArray) {
            for (Piece piece : pieces) {
                if(piece instanceof King && piece.myTurn(this)){
                    if(piece.getField().isUnderAttack(this)){
                       canDoMove = false;

                    }
                }
            }
        }
        moveCandidate.setField(startField);
        arrangePieceArray(moveCandidate, target);
        if(didAKill) {
            resurrect(target);
        }
        return canDoMove;
    }

    public ArrayList<Piece> getDeadPieces() {
        return deadPieces;
    }

    public boolean checkMateOrStaleMate() {

        for (Piece[] pieces : piece2DArray) {
            for (Piece piece : pieces) {
                if(piece != null){
                    for(int i = 0; i<8; i++){
                        for(int j = 0; j<8; j++){

                            Field tryField = new Field(i, j);
                           if(piece.selectionCriteria(tryField, this) && kingIsSafe(piece, tryField)&& piece.myTurn(this))
                               return false;
                        }
                    }
                }
            }
        }
       return true;
    }
}


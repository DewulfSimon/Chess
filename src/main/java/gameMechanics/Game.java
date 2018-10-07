package gameMechanics;

import BoardMechanics.Location;
import pieceMechanics.MoveServices.*;
import pieceMechanics.Piece;
import pieceMechanics.pieces.*;
import java.util.ArrayList;

public class Game {
    private ArrayList<Piece> pieces = new ArrayList<>();
    private ArrayList<Location> board = new ArrayList<>();



    public void createPieces() {

        createRooks();
        createKnights();
        createBishops();
        createQueens();
        createKings();
        createPawns();


    }

    /**
     *just looping for Pawns, they don't need unique Identifiers
     */

    private void createPawns() {



        for(int x = 2; x<18; x++){
                if(x<10) {
                    Pawn pawn = new Pawn(new Location(x, 3), "Black", new PawnService(null));
                    pawn.getPawnService().setPiece(pawn);
                    pieces.add(pawn);
                }else{
                    Pawn pawn = new Pawn(new Location(x-8, 8), "Black", new PawnService(null));
                    pawn.getPawnService().setPiece(pawn);
                    pieces.add(pawn);

                }
            }








        }


    private void createKings() {
        King blackKing = new King(new Location(6,2), "Black", new KingService(null));
        blackKing.getKingService().setPiece(blackKing);

        King whiteKing = new King(new Location(6,9), "White", new KingService(null));
        whiteKing.getKingService().setPiece(whiteKing);

        pieces.add(blackKing);
        pieces.add(whiteKing);

    }

    private void createQueens() {

        Queen blackQueen = new Queen(new Location(5,2), "black", new DiagonalService(null), new StraightService(null));
        blackQueen.getDiagonalService().setPiece(blackQueen);
        blackQueen.getStraightService().setPiece(blackQueen);

        Queen whiteQueen = new Queen(new Location(5,9), "White", new DiagonalService(null), new StraightService(null));
        whiteQueen.getDiagonalService().setPiece(whiteQueen);
        whiteQueen.getStraightService().setPiece(whiteQueen);

        pieces.add(blackQueen);
        pieces.add(whiteQueen);
    }

    private void createBishops() {
        Bishop blackQueenSideBishop = new Bishop(new Location(4,2), "Black", new DiagonalService(null));
        blackQueenSideBishop.getDiagonalService().setPiece(blackQueenSideBishop);

        Bishop blackKingSideBishop = new Bishop(new Location(7,2), "Black", new DiagonalService(null));
        blackKingSideBishop.getDiagonalService().setPiece(blackKingSideBishop);

        Bishop whiteQueenSideBishop = new Bishop(new Location(4,9), "White", new DiagonalService(null));
        whiteQueenSideBishop.getDiagonalService().setPiece(whiteQueenSideBishop);

        Bishop whiteKingSideBIshop = new Bishop(new Location(7,9), "White", new DiagonalService(null));
        whiteKingSideBIshop.getDiagonalService().setPiece(whiteKingSideBIshop);

        pieces.add(blackKingSideBishop);
        pieces.add(blackQueenSideBishop);
        pieces.add(whiteKingSideBIshop);
        pieces.add(whiteQueenSideBishop);
    }

    private void createKnights() {
        Knight blackQueenSideKnight = new Knight(new Location(3,2), "Black", new KnightService(null));
        blackQueenSideKnight.getKnightService().setPiece(blackQueenSideKnight);

        Knight blackKingSideKnight = new Knight(new Location(8,2), "Black", new KnightService(null));
        blackKingSideKnight.getKnightService().setPiece(blackKingSideKnight);

        Knight whiteQueenSideKnight = new Knight(new Location(3,9), "White", new KnightService(null));
        whiteQueenSideKnight.getKnightService().setPiece(whiteQueenSideKnight);

        Knight whiteKingSideKnight = new Knight(new Location(8,9), "White", new KnightService(null));
        whiteKingSideKnight.getKnightService().setPiece(whiteKingSideKnight);

        pieces.add(blackKingSideKnight);
        pieces.add(blackQueenSideKnight);
        pieces.add(whiteKingSideKnight);
        pieces.add(whiteQueenSideKnight);
    }

    private void createRooks() {

        Rook blackQueenSideRook = new Rook(new Location(2, 2), "Black", new StraightService(null));
        blackQueenSideRook.getStraightService().setPiece(blackQueenSideRook);

        Rook blackKingSideRook = new Rook(new Location(9, 2), "Black", new StraightService(null));
        blackKingSideRook.getStraightService().setPiece(blackKingSideRook);

        Rook whiteQueenSideRook = new Rook(new Location(2, 9), "White", new StraightService(null));
        whiteQueenSideRook.getStraightService().setPiece(whiteQueenSideRook);

        Rook whiteKingSideRook = new Rook(new Location(9, 9), "White", new StraightService(null));
        whiteKingSideRook.getStraightService().setPiece(whiteKingSideRook);

        pieces.add(blackKingSideRook);
        pieces.add(blackQueenSideRook);
        pieces.add(whiteKingSideRook);
        pieces.add(whiteQueenSideRook);
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public Game setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
        return this;
    }

    public ArrayList<Location> getBoard() {
        return board;
    }

    public Game setBoard(ArrayList<Location> board) {
        this.board = board;
        return this;
    }


}


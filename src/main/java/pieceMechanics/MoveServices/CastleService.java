package pieceMechanics.MoveServices;

import boardMechanics.Field;
import gameMechanics.GameData;
import pieceMechanics.Piece;
import pieceMechanics.pieces.King;
import pieceMechanics.pieces.Rook;

public class CastleService implements ColoredFormula {
    private static CastleService castleService = null;

    public static CastleService getCastleService(){
        if(castleService == null) castleService = new CastleService();
        return castleService;
    }
    private CastleService(){}


    public boolean move(Field start, Field target, GameData gameData) {

        Piece[][] board = gameData.getPiece2DArray();
        return targetFieldFormula(start, target, board[start.getY()][start.getX()]) && targetFieldContent(start, target, board, gameData);
    }


    /**
     *
     * here we'll check not only the target Field but the presence of the rook on the right field, the road to get there
     * and if any field underway is under attack
     * and if either rook or king have moved
     */

    private boolean targetFieldContent(Field start, Field target, Piece[][] board, GameData gameData) {
        Piece kingTest = board[start.getY()][start.getX()];
        King king;
        if(kingTest instanceof King) {
            king = (King) kingTest;
        }else return false;

        //checking if king/rook have moved before in the game
        if(!havePiecesNotMovedYet(king,start,  target)) return false;

        if(!allNecessaryFieldsAreSafe(start, target, board, king, gameData)) return false;


return true;

    }

    private boolean allNecessaryFieldsAreSafe(Field start, Field target, Piece[][] board, King king, GameData gameData) {

        Rook castlingRook;
        Field testField;
        if(target.getX() < start.getX()){
            castlingRook = king.getQueenSideRook();

            for(int i = 0; i<= 4; i++){
              testField = new Field(i, start.getY());
              if(testField.isUnderAttack(gameData)) return false;
              if(!(board[start.getY()][i] == null
                      || board[start.getY()][i] == king
                      || board[start.getY()][i]== king.getQueenSideRook()))
                  return false;
            }

        }else if(target.getX() > start.getX()){
            castlingRook = king.getKingSideRook();
            for(int i = 4; i<=7; i++){
                testField = new Field(i ,start.getY());
                if(testField.isUnderAttack(gameData)) {
                    return false;
                }
                if(!(board[start.getY()][i] == null
                        || board[start.getY()][i] == king
                        || board[start.getY()][i] == king.getKingSideRook()))
                    return false;
            }
        }
        return true;
    }

    private boolean havePiecesNotMovedYet(King king, Field start, Field target) {
        if(king.isHasMoved()) return false;
        if(target.getX() < start.getX()) {
            return !king.getQueenSideRook().isHasMoved();
        } else if(target.getX() > start.getX())
            return !king.getKingSideRook().isHasMoved();

        return true;
    }

    @Override
    public boolean targetFieldFormula(Field start, Field target, Piece piece) {
        if(piece.isBlack()){
            return target.compareField(new Field(2,0) ) || target.compareField(new Field(6,0));
        }else return target.compareField(new Field(2,7)) || target.compareField(new Field(6,7));
    }

}

package pieceMechanics.MoveServices;


import boardMechanics.Field;
import pieceMechanics.Piece;

public class TranslationalService extends LongGroundMoverService {
    static TranslationalService translationalService = null;

    public static TranslationalService getTranslationalService() {
        if (translationalService == null) translationalService = new TranslationalService();
        return translationalService;
    }

    /**
     * provides Translational movement to Rooks and Queens
     */


    @Override

/**
 * checks targetfield and road to targetfield seperatly as it doesn't matter who or what stands in between
 */
    public boolean move(Field start, Field target, Piece[][] board) {

        return emptyRoad(start, target, board) && targetFieldContent(start, target, board) && targetFieldFormula(start, target);

    }
    /**
     * purely delegates to directions down up, left and right
     */

@Override
    protected boolean emptyRoad(Field start, Field target, Piece[][] board) {
        if (start.getX() == target.getX() && start.getY() != target.getY()) {
            if (start.getY() > target.getY()) return moveDown(start, target, board);
            else return moveUp(start, target, board);

        } else if (start.getY() == target.getY() && start.getX() != target.getX()) {
            if (start.getX() > target.getX()) return MoveRight(start, target, board);
            else return moveLeft(start, target, board);

        } else return false;
    }



    private boolean moveLeft(Field start, Field target, Piece[][] board) {
        //Y == Y start X < target X
        for (int i = start.getX() - 1; i > target.getX(); i--) {
            if (board[start.getY()][i] != null) return false;
        }

       return true;
    }

    private boolean MoveRight(Field start, Field target, Piece[][] board) {
        //Y == Y start X > targetX
        for (int i = start.getX() + 1; i < target.getX(); i++) {
            if (board[start.getY()][i] != null) return false;
        }

        return true;
    }

    private boolean moveUp(Field start, Field target, Piece[][] board) {
        //X == X startY < target Y
        for (int i = start.getY() - 1; i > target.getX(); i--) {
            if (board[i][start.getX()] != null) return false;
        }
        return true;
    }

    private boolean moveDown(Field start, Field target, Piece[][] board) {
        //X == X start Y > target Y
        for (int i = start.getY() + 1; i < target.getX(); i++) {
            if (board[i][start.getX()] != null) return false;
        }
        return true;
    }

    @Override
    protected boolean targetFieldFormula(Field start, Field target) {
        return (start.getX() == target.getX() || start.getY() == target.getY())
                && !(start.getX() == target.getX() && start.getY() == target.getY());
    }
}

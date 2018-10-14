package pieceMechanics.MoveServices;

import boardMechanics.Field;
import pieceMechanics.Piece;

public interface PawnFormula {

    boolean targetFieldFormula(Field start, Field target, Piece pawn);
}

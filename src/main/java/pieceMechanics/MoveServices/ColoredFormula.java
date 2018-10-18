package pieceMechanics.MoveServices;

import boardMechanics.Field;
import pieceMechanics.Piece;

public interface ColoredFormula {

    boolean targetFieldFormula(Field start, Field target, Piece pawn);
}

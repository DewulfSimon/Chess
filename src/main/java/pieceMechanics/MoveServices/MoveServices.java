package pieceMechanics.MoveServices;

import boardMechanics.Field;
import pieceMechanics.Piece;


/**
 * template class for specific moveServices for all Pieces
 */
abstract class MoveServices {

    abstract boolean move(Field start, Field target);


}

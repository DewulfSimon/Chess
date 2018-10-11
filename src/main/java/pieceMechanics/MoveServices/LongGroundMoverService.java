package pieceMechanics.MoveServices;

import boardMechanics.Field;

import pieceMechanics.Piece;

public abstract class LongGroundMoverService extends MoveServices {


    protected abstract boolean emptyRoad(Field start, Field target, Piece[][] board);

}

package pieceMechanics.pieces;

import boardMechanics.Field;
import gameMechanics.GameData;
import pieceMechanics.MoveServices.PawnService;
import pieceMechanics.Piece;

public class Pawn extends Piece {
    private PawnService pawnService; //todo: takes care of single moves, double moves and promote

    private PawnService pawnKillingService; //todo: takes care of En passant and slaying Pieces
    boolean canbeKilledByEnPassent;


    public Pawn(Field field, String color, PawnService pawnService) {
        super(field, color);
        this.pawnService = pawnService;
    }



    public PawnService getPawnService() {
        return pawnService;
    }

    @Override
    public boolean selectionCriteria(Field target, GameData gamedata) {
        return pawnService.move(this.getField(), target, gamedata.getPiece2DArray());
    }


}

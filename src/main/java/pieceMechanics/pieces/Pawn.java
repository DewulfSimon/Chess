package pieceMechanics.pieces;

import boardMechanics.Field;
import gameMechanics.GameData;
import pieceMechanics.MoveServices.PawnKillingService;
import pieceMechanics.MoveServices.PawnService;
import pieceMechanics.Piece;

public class Pawn extends Piece {
    private PawnService pawnService; //todo: takes care of single moves, double moves

    private PawnKillingService pawnKillingService; //todo: takes care of slaying Pieces
    boolean canbeKilledByEnPassent;


    public Pawn(Field field, String color) {
        super(field, color);
        this.pawnService = PawnService.getPawnService();
        this.pawnKillingService = PawnKillingService.getPawnKillingService();
    }


    @Override
    public boolean selectionCriteria(Field target, GameData gamedata) {
        return pawnService.move(this.getField(), target, gamedata.getPiece2DArray())
                ||pawnKillingService.move(this.getField(), target, gamedata.getPiece2DArray());
    }


}

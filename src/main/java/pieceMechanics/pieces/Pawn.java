package pieceMechanics.pieces;

import boardMechanics.Field;
import gameMechanics.GameData;
import pieceMechanics.MoveServices.pawnServices.EnPassantService;
import pieceMechanics.MoveServices.pawnServices.PawnKillingService;
import pieceMechanics.MoveServices.pawnServices.PawnService;
import pieceMechanics.MoveServices.pawnServices.PromotionService;
import pieceMechanics.Piece;

public class Pawn extends Piece {
    private PawnService pawnService;
    private PromotionService promotionService;
    private PawnKillingService pawnKillingService;
    private EnPassantService enPassantService;
    private int savedGameCounter = 0;


    public Pawn(Field field, String color) {
        super(field, color);
        this.pawnService = PawnService.getPawnService();
        this.pawnKillingService = PawnKillingService.getPawnKillingService();
        this.promotionService = PromotionService.getPromotionService();
        this.enPassantService = EnPassantService.getEnPassantService();
    }


    @Override
    public boolean selectionCriteria(Field target, GameData gamedata) {
        if (pawnService.move(this.getField(), target, gamedata.getPiece2DArray())
                || pawnKillingService.move(this.getField(), target, gamedata.getPiece2DArray())) {


            //in case of double move (already cleared by previous if-statement), marks the moving piece
            // with the int of the current turn
            if(this.getField().getY() - target.getY() == -2 || this.getField().getY() - target.getY() == 2){
                this.savedGameCounter = gamedata.getCounter();
            }


            if (target.getY() == 0 || target.getY() == 7) {
                this.promotionService.promote(this, target, gamedata);
                return false;
            }
            return true;
        }
        if(enPassantService.move(this.getField(), target, gamedata)){
            gamedata.getPiece2DArray()[this.getField().getY()][target.getX()].kill();
            gamedata.getPiece2DArray()[this.getField().getY()][target.getX()] =null;
            return true;

        }

        return false;
    }

    public int getSavedGameCounter() {
        return savedGameCounter;
    }

}

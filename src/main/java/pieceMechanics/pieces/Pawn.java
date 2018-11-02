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

            return true;
        }
        if(enPassantService.move(this.getField(), target, gamedata)){
            gamedata.getPiece2DArray()[this.getField().getY()][target.getX()].kill();
            gamedata.getPiece2DArray()[this.getField().getY()][target.getX()] =null;
            return true;

        }

        return false;
    }

    @Override
    public void move(Field target, GameData gameData) {
        if(selectionCriteria(target, gameData) && myTurn(gameData)) {
            if (gameData.kingIsSafe(this, target)) {

                gameData.killIfEnemy(target);

                Field startField = this.getField();
                this.setField(target);

                if(this.getField().getY() - target.getY() == -2 || this.getField().getY() - target.getY() == 2){
                    this.savedGameCounter = gameData.getCounter();
                }

                if (target.getY() == 0 || target.getY() == 7) {
                    this.promotionService.promote(this, target, gameData);
                }

                gameData.arrangePieceArray(this, startField);
                gameData.setCounter(gameData.getCounter() + 1);
            }
        }
        this.setSelected(false);

        if(gameData.checkMateOrStaleMate()) {
            System.out.println("GAME OVER");

        }
    }

    public int getSavedGameCounter() {
        return savedGameCounter;
    }

    @Override
    public String getText() {
        return "Pawn";
    }
}

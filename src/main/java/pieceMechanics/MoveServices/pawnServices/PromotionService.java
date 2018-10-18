package pieceMechanics.MoveServices.pawnServices;


import GUI.PromotionSelectFrame;
import actionListeners.ActionVariableProvider;
import boardMechanics.Field;
import gameMechanics.GameData;
import pieceMechanics.pieces.Pawn;


public class PromotionService {
    private static PromotionService ourInstance = new PromotionService();
    private ActionVariableProvider actionVariableProvider = ActionVariableProvider.getActionVariableProvider();
    public static PromotionService getPromotionService() {

        return ourInstance;
    }

    private PromotionService() {
    }


    public void promote(Pawn a, Field target, GameData gameData) {
        //needs to update array, needs to set the selected new piece on the right spot, needs to
        PromotionSelectFrame frame = new PromotionSelectFrame("Please select a Piece to Promote to");
        actionVariableProvider.setColor(a.getColor());
        actionVariableProvider.setField(target);
        actionVariableProvider.setGameData(gameData);
        actionVariableProvider.setStartField(a.getField());

    }



}

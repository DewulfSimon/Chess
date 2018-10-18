package actionListeners;

import GUI.PromotionSelectFrame;
import pieceMechanics.Piece;
import pieceMechanics.pieces.Bishop;
import pieceMechanics.pieces.Knight;
import pieceMechanics.pieces.Queen;
import pieceMechanics.pieces.Rook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionP implements ActionListener {


    private Button button;

    private ActionVariableProvider actionVariableProvider = ActionVariableProvider.getActionVariableProvider();
    private PromotionSelectFrame frame;

    public ActionP(PromotionSelectFrame frame, Button button) {
        this.button = button;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       frame.setVisible(false);

        Piece newPiece = null;

        switch (button.getLabel()){
            case "Queen": newPiece = new Queen(actionVariableProvider.getField(), actionVariableProvider.getColor());
                    break;
            case "Rook": newPiece = new Rook(actionVariableProvider.getField(), actionVariableProvider.getColor());
                    break;
            case "Bishop": newPiece = new Bishop(actionVariableProvider.getField(), actionVariableProvider.getColor());
                    break;
            case "Knight": newPiece = new Knight(actionVariableProvider.getField(), actionVariableProvider.getColor());
                    break;
                    default: break;
        }
       if(newPiece!=null){
           actionVariableProvider.getGameData().arrangePieceArray(newPiece, actionVariableProvider.getStartField());
           actionVariableProvider.getGameData().setCounter(actionVariableProvider.getGameData().getCounter()+1);
       }
    }
}

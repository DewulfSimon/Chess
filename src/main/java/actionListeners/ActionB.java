package actionListeners;

import boardMechanics.Field;
import gameMechanics.GameData;
import pieceMechanics.Piece;
import pieceMechanics.pieces.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionB implements ActionListener {

    private Field field;
    private GameData gameData;

    public ActionB(Field field, GameData gameData) {
        this.field = field;
        this.gameData = gameData;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Piece currentPiece = findCurrentPiece();

        if (currentPiece != null) {
            currentPiece.move(field, gameData);

        }
        selectPiece(gameData);
    }

    private void selectPiece(GameData gameData) {

        Piece selectedPiece = this.gameData.getPiece2DArray()[field.getY()][field.getX()];
        if (selectedPiece != null) {
            if (selectedPiece.isWhite() && gameData.turnOfWhite() || selectedPiece.isBlack() && gameData.turnOfBlack()) {
                selectedPiece.setSelected(true);
            }
        }
    }

    private Piece findCurrentPiece() {

        for (Piece[] pieces : this.gameData.getPiece2DArray()) {
            for (Piece piece : pieces) {
                if (piece != null) {
                    if (piece.isSelected()) return piece;
                }
            }
        }
        return null;
    }
}

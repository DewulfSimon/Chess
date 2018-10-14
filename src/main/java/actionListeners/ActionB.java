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

    /**
     * If selectpiece returns a piece, executes move, else nullpointerexceptions causes a piece to be selected.
     */
    public void actionPerformed(ActionEvent e) {

        Piece currentPiece = selectedPiece();

        try {
            //in case a Piece was already selected => execute move
            currentPiece.move(field, gameData);
            System.out.println("trying to move something");
            //NullPointer will be triggered if no Piece was already selected

            //if the NullPointer doesn't get triggered (meaning a Piece of the right color was selected)
                // but we have clicked another Piece of the same color
                // We want that other Piece to be selected
            selectPiece(gameData);

        } catch (NullPointerException noPieceSelected) {
           selectPiece(gameData);
            }
        }

    private void selectPiece(GameData gameData) {

        Piece selectedPiece = this.gameData.getPiece2DArray()[field.getY()][field.getX()];
        if (selectedPiece != null) {
            if(selectedPiece.isWhite() && gameData.turnOfWhite() || selectedPiece.isBlack() && gameData.turnOfBlack()) {


                //Als deze niet null is zetten we de boolean isSelected op true;

                selectedPiece.setSelected(true);

                String piece = "";
                if (selectedPiece instanceof Queen) piece = "Queen";
                if (selectedPiece instanceof King) piece = "King";
                if (selectedPiece instanceof Bishop) piece = "Bishop";
                if (selectedPiece instanceof Knight) piece = "Knight";
                if (selectedPiece instanceof Rook) piece = "Rook";
                if (selectedPiece instanceof Pawn) piece = "Pawn";
                System.out.println("selected a " + selectedPiece.getColor() + " " + piece);
            }
    }

}




    private Piece selectedPiece() {

        for (Piece[] pieces : this.gameData.getPiece2DArray()) {
            for (Piece piece : pieces)
                try {
                    if (piece.isSelected()) return piece;
                } catch (NullPointerException ignored) {}
        }
        return null;
    }
}

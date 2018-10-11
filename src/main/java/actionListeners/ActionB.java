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

        Piece currentPiece = selectPiece();
        try {
            //als er een piece geselecteerd was voor deze button geklikt werd:
            currentPiece.move(field, gameData);
            System.out.println("trying to move something");
            //nullpointer wordt getriggered als er geen piece geselecteerd was
        } catch (NullPointerException noPieceSelected) {
            //als er geen Piece geselecteerd is maken we een variabele aan voor een piece op het geklikte veld
            Piece selectedPiece = this.gameData.getPiece2DArray()[field.getY()][field.getX()];
            //we kijken of deze variabele null is ==> of er een stuk op dat veld staat
            if (selectedPiece != null) {

                //Als deze niet null is zetten we de boolean isSelected op true;
                selectedPiece.setSelected(true);

                String piece = "";
                if(selectedPiece instanceof Queen) piece = "Queen";
                if(selectedPiece instanceof King) piece = "King";
                if(selectedPiece instanceof Bishop) piece = "Bishop";
                if(selectedPiece instanceof Knight) piece = "Knight";
                if(selectedPiece instanceof Rook) piece = "Rook";
                if(selectedPiece instanceof Pawn) piece = "Pawn";
                System.out.println("selected a " + selectedPiece.getColor() + " " + piece);

            }


        }
    }




    private Piece selectPiece() {

        for (Piece[] pieces : this.gameData.getPiece2DArray()) {
            for (Piece piece : pieces)
                try {
                    if (piece.isSelected()) return piece;
                } catch (NullPointerException ignored) {}
        }
        return null;
    }
}

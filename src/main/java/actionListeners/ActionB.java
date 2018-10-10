package actionListeners;
import boardMechanics.Field;
import gameMechanics.GameLogic;
import pieceMechanics.Piece;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionB implements ActionListener {

    private Field field;
    private GameLogic gameLogic;

    public ActionB(Field field, GameLogic gameLogic) {
        this.field = field;
        this.gameLogic = gameLogic;
    }


    @Override

    /**
     * If selectpiece returns a piece, executes move, else nullpointerexceptions causes a piece to be selected.
     */
    public void actionPerformed(ActionEvent e) {

        Piece currentPiece = selectPiece();


        try {
            //als er een piece geselecteerd was voor deze button geklikt werd:
            currentPiece.move(field);
            //nullpointer wordt getriggered als er geen piece geselecteerd was
        } catch (NullPointerException noPieceSelected) {
            //als er geen Piece geselecteerd is maken we een variabele aan voor een piece op het geklikte veld
            Piece selectedPiece = this.gameLogic.getPiece2DArray()[field.getY()][field.getX()];
            //we kijken of deze variabele null is ==> of er een stuk op dat veld staat
            if (selectedPiece != null)
                //Als deze niet null is zetten we de boolean isSelected op true;
            selectedPiece.setSelected(true);


        }
    }




    private Piece selectPiece() {

        for (Piece[] pieces : this.gameLogic.getPiece2DArray()) {
            for (Piece piece : pieces)
                try {
                    if (piece.isSelected()) return piece;
                } catch (NullPointerException ignored) {}
        }
        return null;
    }
}

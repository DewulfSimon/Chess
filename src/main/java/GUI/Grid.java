package GUI;

import actionListeners.ActionB;
import actionListeners.ActionVariableProvider;
import boardMechanics.Field;
import gameMechanics.GameData;
import pieceMechanics.Piece;

import javax.swing.*;
import java.awt.*;

public class Grid extends JFrame {
    private int rows;
    private int columns;
    private GameData gameData;
    private BoardButton[][] boardButtons;

    public BoardButton[][] getBoardButtons() {
        return boardButtons;
    }

    Grid(GameData gameData) {
        this.rows = 8;
        this.columns = 8;
        this.gameData = gameData;
        boardButtons = new BoardButton[columns][rows];
        createGrid();


    }

    private void createGrid() {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setMinimumSize(new Dimension(860, 860));

        Container pane = getContentPane();
        pane.setLayout(new GridLayout(rows, columns));


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Field givenField = new Field(j, i);
                BoardButton button = new BoardButton(givenField);
                boardButtons[i][j] = button;
                button.setMinimumSize(new Dimension(100, 100));
                button.addActionListener(new ActionB(button.getField(), this.gameData));

                if (button.getField().getX() % 2 != 0 && button.getField().getY() % 2 == 0
                        || button.getField().getX() % 2 == 0 && button.getField().getY() % 2 != 0)
                    button.setBackground(Color.BLACK);
                else button.setBackground(Color.gray);

                //set an Icon for Pieces;

                pane.add(button);

            }
        }
        this.setVisible(true);
    }

    public GameData getGameData(){
        return this.gameData;
    }

    public void arrangeButtonText(Piece movingPiece, Field startField){
         boardButtons[startField.getY()][startField.getX()].setText("");
         boardButtons[movingPiece.getField().getY()][movingPiece.getField().getX()].setText(movingPiece.getColor() + " " + movingPiece.getText());

    }

    public void arrangeButtonText(Piece createdPiece){
        boardButtons[createdPiece.getField().getY()][createdPiece.getField().getX()].setText(createdPiece.getColor() + " " + createdPiece.getText());
    }
}

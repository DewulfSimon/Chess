package GUI;

import actionListeners.ActionB;
import boardMechanics.Field;
import gameMechanics.GameData;

import javax.swing.*;
import java.awt.*;

public class Grid extends JFrame {
    private int rows;
    private int columns;
    private GameData gameData;

    public Grid( GameData gameData) {
        this.rows = 8;
        this.columns = 8;
        this.gameData = gameData;
        createGrid();

    }

    private void createGrid() {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setMinimumSize(new Dimension(500, 500));

        Container pane = getContentPane();
        pane.setLayout(new GridLayout(rows, columns));


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                BoardButton button = new BoardButton(new Field(j, i));
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
}

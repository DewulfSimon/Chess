package GUI;

import actionListeners.ActionB;
import boardMechanics.Field;
import gameMechanics.GameLogic;

import javax.swing.*;
import java.awt.*;

public class Grid extends JFrame {
    private int rows;
    private int columns;
    private GameLogic gameLogic;

    public Grid( GameLogic gameLogic) {
        this.rows = 8;
        this.columns = 8;
        this.gameLogic = gameLogic;
        createGrid();

    }

    private void createGrid() {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setMinimumSize(new Dimension(500, 500));

        String[] numbers = {"8", "7", "6", "5", "4", "3", "2", "1"};
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};

        Container pane = getContentPane();
        pane.setLayout(new GridLayout(rows, columns));


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                BoardButton button = new BoardButton(new Field(i, j), letters[j] + numbers[i]);
                button.setMinimumSize(new Dimension(100, 100));
                button.addActionListener(new ActionB(button.getField(), this.gameLogic));

                if (button.getField().getX() % 2 != 0 && button.getField().getY() % 2 == 0
                        || button.getField().getX() % 2 == 0 && button.getField().getY() % 2 != 0)
                    button.setBackground(Color.BLACK);
                else button.setBackground(Color.gray);
                //set an Icon for Pieces;

                pane.add( button);

            }
        }
        this.setVisible(true);
    }

    public GameLogic getGameLogic(){
        return this.gameLogic;
    }
}

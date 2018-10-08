package GUI;

import actionListeners.ActionB;
import boardMechanics.Field;

import javax.swing.*;
import java.awt.*;

public class Grid extends JFrame {
    private int rows;
    private int columns;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        createGrid();
    }

    private void createGrid() {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setMinimumSize(new Dimension(500,500));

        String[] numbers = {"8", "7", "6", "5", "4", "3", "2", "1"};
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};

        Container pane = getContentPane();
        pane.setLayout(new GridLayout(rows, columns));


        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                BoardButton button = new BoardButton(new Field(i, j), letters[j]+numbers[i]);
                button.setMinimumSize(new Dimension(100,100));
                button.addActionListener(new ActionB(button.getField()));
                pane.add(button);
            }
        }
        this.setVisible(true);
    }
}

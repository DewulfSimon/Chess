package GUI;

import boardMechanics.Field;

import javax.swing.*;

public class BoardButton extends JButton {
    private Field field;

    public BoardButton(Field field) {
        this.field = field;
    }


    public Field getField() {
        return field;
    }
}

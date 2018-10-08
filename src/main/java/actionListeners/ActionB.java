package actionListeners;

import boardMechanics.Field;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionB implements ActionListener {
    private Field field;

    public ActionB(Field field){
        this.field = field;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

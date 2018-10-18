package GUI;

import actionListeners.ActionP;

import javax.swing.*;
import java.awt.*;

public class PromotionSelectFrame extends JFrame {


    public PromotionSelectFrame(String title) throws HeadlessException {
        super(title);

        createPromotionSelectFrame();
    }

    private void createPromotionSelectFrame() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();

        Container pane = getContentPane();
        pane.setLayout(new GridLayout(2,2));
        this.setMinimumSize(new Dimension(100, 100));


        for(int i = 0; i<4; i++){
            String buttonName = "";
            switch (i){
                case 0: buttonName = "Queen";
                        break;
                case 1: buttonName = "Rook" ;
                        break;
                case 2: buttonName = "Knight";
                        break;
                case 3: buttonName = "Bishop" ;
                        break;
                default: break;
            }
            Button x = new Button(buttonName);
            x.addActionListener(new ActionP(this,x));
            pane.add(x);
        }
        this.setVisible(true);


  }

}

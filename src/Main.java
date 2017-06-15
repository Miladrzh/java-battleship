import ir.aut.view.InGameButtonPanel;
import ir.aut.view.gameview.GameFrame;

import javax.swing.*;

/**
 * Created by Milad on 6/14/2017.
 */
public class Main {
    public static void main(String[] args) {
//        GameFrame field = new GameFrame(300 , 300 , 1200 , 1200);
        JFrame jFrame = new JFrame("hello");
        jFrame.add(new InGameButtonPanel("sadra",0,0,400,200));
        jFrame.setVisible(true);
        jFrame.setSize(500,300);
    }
}

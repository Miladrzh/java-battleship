import ir.aut.view.gameview.GameChatPanel;
import ir.aut.view.gameview.GameFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Milad on 6/14/2017.
 */
public class Main {
    public static void main(String[] args) {
//        GameFrame field = new GameFrame(50 , 10 , 1000 , 700);
        GameChatPanel gameChatPanel = new GameChatPanel("reza", 0, 0, 332, 690);
////        gameChatPanel
//        field.add(gameChatPanel);
        JFrame jFrame = new JFrame("milad");
        jFrame.setLayout(null);
        jFrame.add(gameChatPanel);
        jFrame.setVisible(true);
        jFrame.setSize(350, 700);
    }
}

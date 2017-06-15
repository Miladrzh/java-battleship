package ir.aut.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lenovo on 6/15/2017.
 */
public class ChatPanel extends JPanel {
    String enemyName;

    public ChatPanel(String enemyName) {
        this.enemyName = enemyName;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //todo: add JScrollPane
    }

    public void addMessage(String message, String time, int type) {
        if (type == 0) {
            add(new MessagePanel("You:", message, time, MessagePanel.ME));
        } else {
            add(new MessagePanel(enemyName + ":", message, time, MessagePanel.ENEMY));
        }
        add(Box.createRigidArea(new Dimension(0, 10)));
    }
}
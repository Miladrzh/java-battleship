package ir.aut.view;

import javax.swing.*;

/**
 * Created by Lenovo on 6/15/2017.
 */
public class ChatPanel extends JPanel {
    public ChatPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //todo: add JScrollPane
    }

    public void addMyMessage(String message, String time) {
        add(new MessagePanel("You:", message, time, MessagePanel.MY));
    }

    public void addEnemyMessage(String name, String message, String time) {
        add(new MessagePanel(name + ":", message, time, MessagePanel.ENEMY));
    }
}
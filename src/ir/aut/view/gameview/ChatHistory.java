package ir.aut.view.gameview;

import ir.aut.view.ChatPanel;

import javax.swing.*;

/**
 * Created by Milad on 7/9/2017.
 */
public class ChatHistory extends JFrame {
    String enemyName;
    ChatPanel chatPanel;

    public ChatHistory(String enemyName, int xCor, int yCor, int xSize, int ySize) {
        super(enemyName);
        this.enemyName = enemyName;
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setBounds(xCor, yCor, xSize, ySize);
        chatPanel = new ChatPanel(0, 0, enemyName);
        this.add(chatPanel);
        setVisible(false);
    }

    public void addMessage(String message, String time, int type) {
        chatPanel.addMessage(message, time, type);
    }
}

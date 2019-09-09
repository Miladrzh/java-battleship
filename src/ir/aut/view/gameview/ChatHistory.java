package ir.aut.view.gameview;

import ir.aut.view.ChatPanel;

import javax.swing.*;
import java.awt.*;

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
        setPreferredSize(new Dimension(xSize, ySize));
        JScrollPane jScrollPane = new JScrollPane(chatPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(xSize - 20, 0, xSize, 1000);
//        this.add(chatPanel);
        add(jScrollPane);
        setVisible(false);
    }

    public void addMessage(String message, String time, int type) {
        chatPanel.addMessage(message, time, type);
    }
}

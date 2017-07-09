package ir.aut.view;

import ir.aut.model.MessageJSON;
import ir.aut.view.gameview.ChatPanelCallBack;
import ir.aut.view.gameview.MasterGameFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lenovo on 6/15/2017.
 */
public class ChatPanel extends JPanel {
    String enemyName;
    int lastYcor, baseStep;
    ChatPanelCallBack chatPanelCallBack;

    public ChatPanel(ChatPanelCallBack chatPanelCallBack, int xCor, int yCor, String enemyName) {
        super();
        this.chatPanelCallBack = chatPanelCallBack;
        this.enemyName = enemyName;
        this.setLayout(null);
        this.setLocation(xCor, yCor);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lastYcor = 10;
        baseStep = 60;
    }

    public ChatPanel(int xCor, int yCor, String enemyName) {
        super();
        this.enemyName = enemyName;
        this.setLayout(null);
        this.setLocation(xCor, yCor);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lastYcor = 10;
        baseStep = 60;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public void addMessage(String message, String time, int type) {

        if (type == 0) {
            add(new MessagePanel("You:", message, time, MessagePanel.ME, lastYcor));
            if (chatPanelCallBack != null)
                chatPanelCallBack.addMessageJSON(new MessageJSON(message, time, MessageJSON.MY_MESSAGE));
        } else {
            add(new MessagePanel(enemyName + ":", message, time, MessagePanel.ENEMY, lastYcor));
            if (chatPanelCallBack != null)
                chatPanelCallBack.addMessageJSON(new MessageJSON(message, time, MessageJSON.ENEMY_MESSAGE));
        }
        lastYcor += baseStep;
        add(Box.createRigidArea(new Dimension(0, 10)));
        validate();
    }

}
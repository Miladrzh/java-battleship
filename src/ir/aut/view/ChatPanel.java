package ir.aut.view;

import ir.aut.view.gameview.MasterGameFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lenovo on 6/15/2017.
 */
public class ChatPanel extends JPanel {
    String enemyName;
    int lastYcor , baseStep;
    public ChatPanel(int xCor , int yCor) {
        super();
        this.enemyName = enemyName;
        this.setLayout(null);
        this.setLocation(xCor , yCor);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lastYcor = 10;
        baseStep = 60;
    }

    public void addMessage(String message, String time, int type) {
        if (type == 0) {
            add(new MessagePanel("You:", message, time, MessagePanel.ME , lastYcor));
        } else {
            add(new MessagePanel(enemyName + ":", message, time, MessagePanel.ENEMY  , lastYcor));
        }
        lastYcor += baseStep;
        add(Box.createRigidArea(new Dimension(0, 10)));
        validate();
    }

}
package ir.aut.view;

import ir.aut.view.gameview.MasterGameFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lenovo on 6/15/2017.
 */
public class ChatPanel extends JPanel {
    String enemyName;
    int curXsize , curYsize , count;
    int initialX , initialY;
    int lastYcor , baseStep;
    public ChatPanel(int xCor , int yCor , String enemyName) {
        super();
        this.enemyName = "!23";
        this.setLayout(null);
        this.setLocation(xCor , yCor);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lastYcor = 10;
        baseStep = 60;
        this.addMessage("dsfds" , "sdf" , MessagePanel.ME);
        this.addMessage("sdf" , "efew" , MessagePanel.ENEMY);
        this.addMessage("dsfds" , "sdf" , MessagePanel.ME);
        this.addMessage("dsfds" , "sdf" , MessagePanel.ME);
        this.addMessage("sdf" , "efew" , MessagePanel.ENEMY);
        this.addMessage("dsfds" , "sdf" , MessagePanel.ME);
        this.addMessage("dsfds" , "sdf" , MessagePanel.ME);
        this.addMessage("sdf" , "efew" , MessagePanel.ENEMY);
        this.addMessage("dsfds" , "sdf" , MessagePanel.ME);
        this.addMessage("dsfds" , "sdf" , MessagePanel.ME);
        this.addMessage("sdf" , "efew" , MessagePanel.ENEMY);
        this.addMessage("dsfds" , "sdf" , MessagePanel.ME);
        this.addMessage("dsfds" , "sdf" , MessagePanel.ME);
        this.addMessage("sdf" , "efew" , MessagePanel.ENEMY);
        this.addMessage("dsfds" , "sdf" , MessagePanel.ME);
        this.addMessage("dsfds" , "sdf" , MessagePanel.ME);
        this.addMessage("sdf" , "efew" , MessagePanel.ENEMY);
        this.addMessage("dsfds" , "sdf" , MessagePanel.ME);
        this.addMessage("dsfds" , "sdf" , MessagePanel.ME);
        this.addMessage("sdf" , "efew" , MessagePanel.ENEMY);
        this.addMessage("dsfds" , "sdf" , MessagePanel.ME);
        this.addMessage("dsfds" , "sdf" , MessagePanel.ME);
        this.addMessage("sdf" , "efew" , MessagePanel.ENEMY);
        this.addMessage("dsfds" , "sdf" , MessagePanel.ME);
        this.addMessage("dsfds" , "sdf" , MessagePanel.ME);
        this.addMessage("sdf" , "efew" , MessagePanel.ENEMY);
        this.addMessage("dsfds" , "sdf" , MessagePanel.ME);
        this.addMessage("dsfds" , "sdf" , MessagePanel.ME);
        this.addMessage("sdf" , "efew" , MessagePanel.ENEMY);
        this.addMessage("dsfds" , "sdf" , MessagePanel.ME);
        count = 0;
    }
    public void setInitialBounds (int x , int y){
        initialX = x;
        initialY = y;
    }
    public void addMessage(String message, String time, int type) {
        if (type == 0) {
            add(new MessagePanel("You:", message, time, MessagePanel.ME , lastYcor));
        } else {
            add(new MessagePanel(enemyName + ":", message, time, MessagePanel.ENEMY  , lastYcor));
        }
        lastYcor += baseStep;

        System.out.println(count);
        add(Box.createRigidArea(new Dimension(0, 10)));

    }

}
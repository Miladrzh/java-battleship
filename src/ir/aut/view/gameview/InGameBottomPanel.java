package ir.aut.view.gameview;


import ir.aut.game.GameFrameCallBack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Lenovo on 6/15/2017.
 */
public class InGameBottomPanel extends JPanel {
    private JLabel you;
    private JLabel enemy;
    private JButton leaveButton;
    private GameFrame master;
    private GameFrameCallBack gameFrameCallBack;

    public InGameBottomPanel(String enemyName, int xCor, int yCor, int xSize, int ySize) {
        you = new JLabel("You");
        enemy = new JLabel(enemyName);
        this.setBackground(new Color(229, 110, 53));
        leaveButton = new JButton("leave");
        setLayout(null);
        you.setBounds(5, 15, 40, 15);
        enemy.setBounds(xSize / 2, 15, 70, 15);
        leaveButton.setBounds(xSize - 100, ySize - 80, 80, 30);
        add(you);
        add(enemy);
        add(leaveButton);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLocation(xCor, yCor);
        setSize(xSize, ySize);
        leaveButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrameCallBack.sendConnectionLostMessage();
            }
        });
    }

    public void setGameFrameCallBack(GameFrameCallBack gameFrameCallBack) {
        this.gameFrameCallBack = gameFrameCallBack;
    }

    public void setMaster(GameFrame master) {
        this.master = master;
    }
}

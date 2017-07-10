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
    private JLabel yourHits;
    private JLabel enemyHits;
    private JButton leaveButton;
    private GameFrame master;
    private GameFrameCallBack gameFrameCallBack;

    public InGameBottomPanel(String enemyName, int xCor, int yCor, int xSize, int ySize) {
        you = new JLabel("You");
        enemy = new JLabel(enemyName);
        this.setBackground(new Color(229, 176, 140));
        leaveButton = new JButton("leave");
        setLayout(null);
        you.setBounds(5, 15, 40, 15);
        enemy.setBounds(xSize / 2, 15, 70, 15);
        leaveButton.setBounds(xSize - 100, ySize - 80, 80, 30);
        add(you);
        add(enemy);
        add(leaveButton);
        yourHits = new JLabel("0");
        enemyHits = new JLabel("0");

        yourHits.setBounds(6, 30, 100, 100);
        yourHits.setFont(new Font("Arial" , Font.BOLD , 20));
        enemyHits.setBounds(xSize / 2, 30, 100, 100);
        enemyHits.setFont(new Font("Arial" , Font.BOLD , 20));
        add(yourHits);
        add(enemyHits);
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

    public void setYourHits(int i) {
        yourHits.setText("" + i);
    }

    public void setEnemyHits(int i) {
        enemyHits.setText( "" +i);
    }

    public void setGameFrameCallBack(GameFrameCallBack gameFrameCallBack) {
        this.gameFrameCallBack = gameFrameCallBack;
    }

    public void setMaster(GameFrame master) {
        this.master = master;
    }
}

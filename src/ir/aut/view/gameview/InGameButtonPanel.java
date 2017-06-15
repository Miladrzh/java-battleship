package ir.aut.view.gameview;


import javax.swing.*;

/**
 * Created by Lenovo on 6/15/2017.
 */
public class InGameButtonPanel extends JPanel {
    private JLabel you;
    private JLabel enemy;
    private JButton leaveButton;

    public InGameButtonPanel(String enemyName, int xCor, int yCor, int xSize, int ySize) {
        you = new JLabel("You");
        enemy = new JLabel(enemyName);
        leaveButton = new JButton("leave");
        setLayout(null);
        you.setBounds(5, 15, 40, 15);
        enemy.setBounds(xSize / 2, 15, 70, 15);
        leaveButton.setBounds(xSize - 10, ySize - 30, 80, 30);
        add(you);
        add(enemy);
        add(leaveButton);
        setLocation(xCor, yCor);
        setSize(xSize, ySize);
    }
}

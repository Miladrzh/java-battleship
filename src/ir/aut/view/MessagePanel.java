package ir.aut.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lenovo on 6/15/2017.
 */
public class MessagePanel extends JPanel {
    public static final int ME = 0;
    public static final int ENEMY = 1;
    public static final int LEFT = 10;
    public static final int RIGHT = 120;
    private JLabel titleLbl;
    private JLabel messageLbl;
    private JLabel timeLbl;

    public MessagePanel(String title, String message, String time, int type , int yCor) {
        setLayout(new GridLayout(3, 1, 5, 5));
        titleLbl = new JLabel(title, SwingConstants.LEFT);
        messageLbl = new JLabel(message);
        timeLbl = new JLabel(time, SwingConstants.RIGHT);
        if (type == 0) {
            setBackground(new Color(188, 229, 200));
            setLocation(RIGHT , yCor);
        }
        else {
            setBackground(new Color(198, 166, 190));
            setLocation(LEFT , yCor);
        }
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setSize(180, 40);
        this.add(titleLbl);
        this.add(messageLbl);
        this.add(timeLbl);
    }
}
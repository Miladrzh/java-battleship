package ir.aut.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lenovo on 6/15/2017.
 */
public class MessagePanel extends JPanel {
    public static final int ME = 0;
    public static final int ENEMY = 1;
    private JLabel titleLbl;
    private JLabel messageLbl;
    private JLabel timeLbl;

    public MessagePanel(String title, String message, String time, int type) {
        setLayout(new GridLayout(3, 1, 5, 5));
        titleLbl = new JLabel(title, SwingConstants.RIGHT);
        messageLbl = new JLabel(message);
        timeLbl = new JLabel(time, SwingConstants.RIGHT);
        if (type == 0) {
            setBackground(Color.GREEN);
        }
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setSize(60, 40);
    }
}
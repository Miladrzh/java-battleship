package ir.aut.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Lenovo on 6/15/2017.
 */
public class GameChatPanel extends JPanel implements ActionListener {
    private JLabel chatToLbl;
    private ChatPanel chatPanel;
    private JTextField typeTextField;

    public GameChatPanel(String enemyName) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        chatToLbl = new JLabel("Chat to " + enemyName);
        chatPanel = new ChatPanel(enemyName);
        typeTextField = new JTextField("Type here ...", 50);
        add(chatToLbl);
        add(Box.createRigidArea(new Dimension(0, 4)));
        add(chatPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(typeTextField);
        typeTextField.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        chatPanel.addMessage(e.getActionCommand(), new SimpleDateFormat("HHmm").format(new Date()), MessagePanel.MY);
    }
}
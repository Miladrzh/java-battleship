package ir.aut.view.gameview;

import ir.aut.view.ChatPanel;
import ir.aut.view.MessagePanel;

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

    public GameChatPanel(String enemyName, int xCor, int yCor, int xSize, int ySize) {
//        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(null);
        chatToLbl = new JLabel("Chat to " + enemyName);
        chatToLbl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        chatPanel = new ChatPanel(enemyName);
        typeTextField = new JTextField("Type here ...", 50);
        chatToLbl.setBounds(0, 0, xSize, ySize / 12);
        chatPanel.setBounds(0, ySize / 12, xSize, ySize * 5 / 6);
        typeTextField.setBounds(0, ySize * 11 / 12, xSize, ySize / 12);
        add(chatToLbl);
//        add(Box.createRigidArea(new Dimension(0, 4)));
        add(chatPanel);
//        add(Box.createRigidArea(new Dimension(0, 10)));
        add(typeTextField);
        typeTextField.addActionListener(this);
        setVisible(true);
        setLocation(xCor, yCor);
        setSize(xSize, ySize);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        chatPanel.addMessage(e.getActionCommand(), new SimpleDateFormat("HHmm").format(new Date()), MessagePanel.ME);
    }
}
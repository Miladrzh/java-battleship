package ir.aut.view.gameview;

import ir.aut.game.GameFrameCallBack;
import ir.aut.logic.messages.ChatMessage;
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
    public ChatPanel chatPanel;
    private JTextField typeTextField;
    private GameFrameCallBack gameFrameCallBack;

    public GameChatPanel(String enemyName, int xCor, int yCor, int xSize, int ySize) {
//        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(null);
        chatToLbl = new JLabel("  Chat to: " + enemyName);
        chatToLbl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        chatPanel = new ChatPanel(enemyName);
        typeTextField = new JTextField("Type here ...", 50);
        chatToLbl.setBounds(0, 0, xSize, ySize / 12);
        chatPanel.setBounds(0, ySize / 12, xSize, ySize * 3 / 4);
        typeTextField.setBounds(0, ySize * 5 / 6, xSize, ySize / 12);
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

    public void setGameFrameCallBack(GameFrameCallBack gameFrameCallBack) {
        this.gameFrameCallBack = gameFrameCallBack;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        chatPanel.addMessage(e.getActionCommand(), new SimpleDateFormat("HHmm").format(new Date()), MessagePanel.ME);
        gameFrameCallBack.sendMessage(new ChatMessage("milad", e.getActionCommand()));
        //todo: ok beshe !
        validate();
    }
}

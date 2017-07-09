package ir.aut.view.gameview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Milad on 7/9/2017.
 */
public class ConversationSchema extends JPanel {
    private String name, date, lastMessage;
    private ChatHistory chatHistory;


    public ConversationSchema(ChatHistory chatHistory, String name, String date, String lastMessage, int xSize, int ySize, int yCor) {
        this.chatHistory = chatHistory;
        this.name = name;
        this.date = date;
        this.lastMessage = lastMessage;
        setLayout(new GridLayout(2, 2));
        JLabel nameLbl = new JLabel(this.name, SwingConstants.LEFT);
        JLabel dateLbl = new JLabel(this.date, SwingConstants.RIGHT);
        JLabel lastMessageLbl = new JLabel(this.lastMessage);
        add(nameLbl);
        add(dateLbl);
        add(lastMessageLbl);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLocation(0, yCor);
        setSize(xSize, ySize);
        addMouseListener(new MouseHandler());
    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            chatHistory.setVisible(true);
        }
    }
}

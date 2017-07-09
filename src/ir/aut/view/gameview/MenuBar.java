package ir.aut.view.gameview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Lenovo on 6/15/2017.
 */
public class MenuBar extends JMenuBar implements ActionListener {
    private JMenu file;
    private JMenu help;
    private JMenuItem wikiPedia;
    private JMenuItem saveChat;
    private JMenuItem chatHistory;

    public MenuBar(int xCor, int yCor, int xSize, int ySize) {
        file = new JMenu("File");
        help = new JMenu("Help");
        chatHistory = new JMenuItem("Show Conversations History");
        wikiPedia = new JMenuItem("Wikipedia");
        saveChat = new JMenuItem("Save Chats");
        this.setBackground(new Color(102, 158, 200));
        file.add(chatHistory);
        help.add(wikiPedia);
        add(file);
        add(help);
        chatHistory.addActionListener(this);
        wikiPedia.addActionListener(this);
        this.setLocation(xCor, yCor);
        this.setSize(xSize, ySize);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chatHistory) {
            new ConversationsHistory(100, 100, 200, 300);
        } else {
            try {
                java.awt.Desktop.getDesktop().browse(new URI("https://en.wikipedia.org/wiki/Battleship_(game)"));
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (URISyntaxException e1) {
                e1.printStackTrace();
            }
        }
    }
}
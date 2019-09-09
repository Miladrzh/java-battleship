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
    private JMenuItem chatHistory;
    private JMenuItem wikiPedia;
    private JMenuItem saveChat;
    private MenuBarCallBack menuBarCallBack;
    public ConversationsHistory conversationsHistory;
    public MenuBar(MenuBarCallBack menuBarCallBack, int xCor, int yCor, int xSize, int ySize) {
        super();
        this.menuBarCallBack = menuBarCallBack;
        file = new JMenu("File");
        help = new JMenu("Help");
        chatHistory = new JMenuItem("Chat History");
        wikiPedia = new JMenuItem("Wikipedia");
        saveChat = new JMenuItem("Save Chat");
        saveChat.addActionListener(this);
        chatHistory.addActionListener(this);
        this.setBackground(new Color(102, 158, 200));
        file.add(saveChat);
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
            if (conversationsHistory != null)
                conversationsHistory.setVisible(false);
            conversationsHistory = new ConversationsHistory(300 , 300 , 300 , 600);
        } else if (e.getSource() == saveChat) {
            menuBarCallBack.saveChatHistory();
            System.out.println("menubar action listener");
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
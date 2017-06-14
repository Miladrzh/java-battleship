package ir.aut.view;

import javax.swing.*;
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

    public MenuBar() {
        file = new JMenu("File");
        help = new JMenu("Help");
        chatHistory = new JMenuItem("Chat History");
        wikiPedia = new JMenuItem("Wikipedia");
        file.add(chatHistory);
        help.add(wikiPedia);
        chatHistory.addActionListener(this);
        wikiPedia.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chatHistory) {

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
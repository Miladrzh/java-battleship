package ir.aut.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lenovo on 6/14/2017.
 */
public class WaitingForConnectionFrame extends JFrame {
    private JLabel rcv;

    public WaitingForConnectionFrame() {
        super("Waiting For Connection... ");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        //Todo: add JScrollPane
//        add(new JScrollPane(getContentPane()));
        rcv = new JLabel("Received Connections :");
        JPanel rcvPanel = new JPanel(new FlowLayout());
        rcvPanel.add(rcv);
        add(rcvPanel);
        setSize(200, 300);
        setVisible(true);
    }

    public void addToFrame(String name, String ip) {
        add(new RequestPanel(name, ip));
        add(Box.createRigidArea(new Dimension(0, 10)));
        validate();
    }
}
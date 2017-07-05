package ir.aut.view;

import ir.aut.game.WaitForConnectionCallBack;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lenovo on 6/14/2017.
 */
public class WaitingForConnectionFrame extends JFrame {
    private JLabel rcv;
    private WaitForConnectionCallBack waitForConnectionCallBack;

    public WaitingForConnectionFrame(WaitForConnectionCallBack waitForConnectionCallBack) {
        super("Waiting For Connection... ");
        this.waitForConnectionCallBack = waitForConnectionCallBack;
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
        add(new RequestPanel(waitForConnectionCallBack,name, ip));
        add(Box.createRigidArea(new Dimension(0, 10)));
        validate();
    }
}
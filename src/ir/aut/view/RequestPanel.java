package ir.aut.view;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.JavaMethod;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_COLOR_BURNPeer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lenovo on 6/14/2017.
 */
public class RequestPanel extends JPanel {
    private JLabel nameLbl;
    private JLabel ipLbl;
    private JButton reject;
    private JButton accept;

    public RequestPanel(String name, String ip) {
        setLayout(new GridLayout(3, 1, 10, 10));
        nameLbl = new JLabel(name);
        ipLbl = new JLabel(ip);
        reject = new JButton("Reject");
        accept = new JButton("Accept");
        ipLbl.setForeground(Color.DARK_GRAY);
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.add(reject);
        buttonPanel.add(accept);
        add(nameLbl);
        add(ipLbl);
        add(buttonPanel);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}

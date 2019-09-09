package ir.aut.view;

import ir.aut.game.WaitForConnectionCallBack;
import ir.aut.logic.messages.ApplyStatusMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lenovo on 6/14/2017.
 */
public class RequestPanel extends JPanel {
    private WaitForConnectionCallBack waitForConnectionCallBack;
    private JLabel nameLbl;
    private JLabel ipLbl;
    private JButton reject;
    private JButton accept;

    public RequestPanel(WaitForConnectionCallBack waitForConnectionCallBack, String name, String ip) {
        setLayout(new GridLayout(3, 1, 10, 10));
        nameLbl = new JLabel(name);
        ipLbl = new JLabel(ip);
        reject = new JButton("Reject");
        accept = new JButton("Accept");
        ipLbl.setForeground(Color.DARK_GRAY);
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        this.setBackground(new Color(108, 125, 143));
        buttonPanel.add(reject);
        buttonPanel.add(accept);
        add(nameLbl);
        add(ipLbl);
        add(buttonPanel);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.waitForConnectionCallBack = waitForConnectionCallBack;
        ActionHandler actionHandler = new ActionHandler();
        accept.addActionListener(actionHandler);
        reject.addActionListener(actionHandler);
    }

    private class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == accept) {
                waitForConnectionCallBack.setEnemyName(RequestPanel.this.nameLbl.getText());
                waitForConnectionCallBack.hostResponse(RequestPanel.this.ipLbl.getText(), new ApplyStatusMessage((byte) 1));
                waitForConnectionCallBack.setEnemyIp(RequestPanel.this.ipLbl.getText());
            } else {
                waitForConnectionCallBack.hostResponse(RequestPanel.this.ipLbl.getText(), new ApplyStatusMessage((byte) 0));
                RequestPanel.this.setVisible(false);
            }
        }
    }
}

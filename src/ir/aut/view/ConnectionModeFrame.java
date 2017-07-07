package ir.aut.view;

import ir.aut.game.ModeFrameCallback;
import ir.aut.logic.MessageManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lenovo on 6/14/2017.
 */
public class ConnectionModeFrame extends JFrame implements ActionListener {

    private ModeFrameCallback modeFrameMaster;
    private JLabel nameLbl;
    private JLabel portLbl;
    private JLabel ipLbl;
    private JLabel portLbl2;
    private JButton startButton;
    private JButton exitButton;
    private JRadioButton guestButton;
    private JRadioButton hostButton;
    private JTextField nameText;
    private JTextField portText;
    private JTextField ipText;
    private JTextField portText2;

    public ConnectionModeFrame(ModeFrameCallback modeFrameMaster) {
        super("Select Connection Mode");
        this.modeFrameMaster = modeFrameMaster;
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(330, 320);
        nameLbl = new JLabel("Name : ");
        hostButton = new JRadioButton("Host", true);
        portLbl = new JLabel("Port : ");
        guestButton = new JRadioButton("Guest");
        ipLbl = new JLabel("IP : ");
        portLbl2 = new JLabel("Port : ");
        nameText = new JTextField(20);
        portText = new JTextField(20);
        portText2 = new JTextField(20);
        ipText = new JTextField(20);
        startButton = new JButton("start");
        startButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (guestButton.isSelected()) {
                    modeFrameMaster.setMessageManager(new MessageManager(ipText.getText(), Integer.parseInt(portText2.getText())));
                    modeFrameMaster.sendRequest(ipText.getText(), nameText.getText());
                    modeFrameMaster.startPleaseWaitFrame();
                } else {
                    modeFrameMaster.setMessageManager(new MessageManager(Integer.parseInt(portText.getText())));
                    modeFrameMaster.startWaitForConnectionFrame();
                }
                modeFrameMaster.setNameOfPlayer(nameText.getText());
                modeFrameMaster.closeModeFrame();
            }
        });
        exitButton = new JButton("Exit");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(guestButton);
        buttonGroup.add(hostButton);
        ipText.setEnabled(false);
        portText2.setEnabled(false);
        nameLbl.setBounds(20, 20, 60, 20);
        nameText.setBounds(70, 20, 140, 20);
        hostButton.setBounds(20, 60, 70, 30);
        portLbl.setBounds(20, 100, 60, 20);
        portText.setBounds(55, 100, 65, 20);
        guestButton.setBounds(20, 145, 70, 30);
        ipLbl.setBounds(20, 185, 60, 20);
        ipText.setBounds(45, 185, 100, 20);
        portLbl2.setBounds(160, 185, 60, 20);
        portText2.setBounds(195, 185, 80, 20);
        exitButton.setBounds(160, 240, 70, 30);
        startButton.setBounds(236, 240, 70, 30);

        add(nameLbl);
        add(nameText);
        add(hostButton);
        add(portLbl);
        add(portText);
        add(guestButton);
        add(ipLbl);
        add(ipText);
        add(portLbl2);
        add(portText2);
        add(exitButton);
        add(startButton);

        guestButton.addActionListener(this);
        hostButton.addActionListener(this);
        nameText.requestFocus();
        startButton.requestFocus();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guestButton) {
            ipText.setEnabled(true);
            ipText.requestFocus();
            portText2.setEnabled(true);
            portText.setEnabled(false);
        } else if (e.getSource() == hostButton) {
            portText.setEnabled(true);
            portText.requestFocus();
            ipText.setEnabled(false);
            portText2.setEnabled(false);
        }
    }
}
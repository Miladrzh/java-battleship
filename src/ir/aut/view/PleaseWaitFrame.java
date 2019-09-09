package ir.aut.view;

import ir.aut.game.PleaseWaitFrameCallBack;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Lenovo on 6/14/2017.
 */
public class PleaseWaitFrame extends JFrame {
    private JLabel lbl;
    private JButton cancel;
    private PleaseWaitFrameCallBack pleaseWaitFrameCallBack;

    public PleaseWaitFrame(PleaseWaitFrameCallBack pleaseWaitFrameCallBack) {
        super("Please Wait ...");
        this.pleaseWaitFrameCallBack = pleaseWaitFrameCallBack;
        int xCor = 100, yCor = 100, xSize = 300, ySize = 300;
        setLayout(null);
        lbl = new JLabel("      Waiting for the host to join ...");
        cancel = new JButton("Cancel");
        lbl.setBounds(20, 20, 200, 20);
        cancel.setBounds(120, 65, 80, 28);
        cancel.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pleaseWaitFrameCallBack.cancelPleaseWaitFrame();
                pleaseWaitFrameCallBack.start();
            }
        });
        add(lbl);
        add(cancel);
        setSize(xSize, ySize);
        setLocation(xCor, yCor);
        setVisible(true);
    }
}
package ir.aut.view;

import javax.swing.*;

/**
 * Created by Lenovo on 6/14/2017.
 */
public class PleaseWaitFrame extends JFrame {
    private JLabel lbl;
    private JButton cancel;

    public PleaseWaitFrame(int xCor, int yCor, int xSize, int ySize) {
        super("Please Wait ...");
        setLayout(null);
        lbl = new JLabel("      Waiting for the host to join ...");
        cancel = new JButton("Cancel");
        lbl.setBounds(20, 20, 200, 20);
        cancel.setBounds(120, 65, 80, 28);
        add(lbl);
        add(cancel);
        setSize(xSize, ySize);
        setLocation(xCor, yCor);
        setVisible(true);
    }
}
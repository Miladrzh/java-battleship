package ir.aut.view.gameview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Milad on 6/15/2017.
 */
public class BeforeGameBottomPanel extends JPanel {
    public JButton reset, ready;
    public JLabel block4, block3, block2, block1;
    private GameFrame master;
    public BeforeGameBottomPanel(int xCor, int yCor, int xSize, int ySize) {
        super();
        this.setLayout(null);
        this.setLocation(xCor, yCor);
        this.setSize(xSize, ySize);
        this.setBackground(new Color(229, 212, 104));
        //Reset Button
        reset = new JButton("Reset");
        reset.setSize(80, 30);
        reset.setLocation(465, 80);
        reset.setVisible(true);
        reset.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                master.resetBeforeBottomPanel();
            }
        });
        this.add(reset);

        // Ready Button
        ready = new JButton("Ready");
        ready.setSize(80, 30);
        ready.setLocation(560, 80);
        ready.setVisible(true);
        ready.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (master == null)
                    System.out.println("Sdfds");
                master.changeBottomPanel();
            }
        });
        this.add(ready);

        // blockS
        block4 = new JLabel("x1");
        block3 = new JLabel("x2");
        block2 = new JLabel("x3");
        block1 = new JLabel("x4");
        block4.setBounds(200, 10, 30, 20);
        block3.setBounds(200, 38, 30, 20);
        block2.setBounds(200, 68, 30, 20);
        block1.setBounds(200, 93, 30, 20);
        this.add(block1);
        this.add(block2);
        this.add(block3);
        this.add(block4);


        this.setVisible(true);
    }

    public void setMaster(GameFrame master) {
        if (master == null)
            System.out.println("wer");
        this.master = master;
    }
}

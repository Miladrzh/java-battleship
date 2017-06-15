package ir.aut.view.gameview;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Milad on 6/15/2017.
 */
public class BeforeGameBottomPanel extends JPanel {
    public JButton reset , ready;
    public JLabel block4 , block3 , block2 , block1;
    public BeforeGameBottomPanel(int xCor, int yCor, int xSize, int ySize){
        super();
        this.setLayout(null);
        this.setLocation(xCor, yCor);
        this.setSize(xSize, ySize);

        //Reset Button
        reset = new JButton("Reset");
        reset.setSize(xSize / 5 , ySize / 5);
        reset.setLocation(3 * xCor / 5 , (8 * yCor) / 10);
        this.add(reset);

        // Ready Button
        ready = new JButton("Ready");
        ready.setSize(xSize / 5 , ySize / 5);
        ready.setLocation(4 * xCor / 5 , (8 * yCor) / 10);
        ready.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameFrame.changeBottomPanel();
            }
        });
        this.add(ready);

        // blockS
        block4 = new JLabel("x1");
        block3 = new JLabel("x2");
        block2 = new JLabel("x3");
        block1 = new JLabel("x4");

        this.add(block1);
        this.add(block2);
        this.add(block3);
        this.add(block4);


        this.setVisible(true);
    }
}

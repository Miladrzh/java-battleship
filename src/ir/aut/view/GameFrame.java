package ir.aut.view;

import javax.swing.*;

/**
 * Created by Milad on 6/14/2017.
 */
public class GameFrame extends JFrame {
    SeaPanel sea = new SeaPanel(1, 1, 700, 700);

    public GameFrame(int xCor, int yCor, int xSize, int ySize) {
        super();
        this.setLayout(null);
        this.setLocation(xCor, yCor);
        this.setSize(xSize, ySize);
        this.add(sea);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}

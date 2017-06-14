package ir.aut.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Milad on 6/14/2017.
 */
public class SeaPanel extends JPanel {
    public SeaPanel (int xCor , int yCor , int xSize , int ySize){
        super();
        this.setBackground(new Color(228, 245, 240));
        this.setSize(xSize , ySize);
        this.setLocation(xCor , yCor);
        GridLayout manager = new GridLayout(10 , 10);
        this.setLayout(manager);

        for (int i = 0 ; i < 100 ; i++){
            JLabel x = new JLabel();
            x.setText(Integer.toString(i));
            x.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            this.add(x);
        }

        this.setVisible(true);
    }
}

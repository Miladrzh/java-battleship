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

        for (int i = 1 ; i <= 10 ; i++){
            for (int j = 1 ; j <= 10 ; j++) {
                SeaCell x = new SeaCell(i , j);
                x.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                if (i == 10)
                    x.setSheep(true);

                SeaCell.total.put(x.getCor() , x);
                this.add(x);
            }
        }

        this.setVisible(true);
    }

}

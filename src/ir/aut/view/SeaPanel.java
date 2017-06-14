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
        GridLayout manager = new GridLayout(11 , 11);
        this.setLayout(manager);
        JLabel y = new JLabel();
        this.add(y);
        for (char i = 'A' ; i <= 'J' ; i++){
            JLabel x = new JLabel();
            x.setText("         " + Character.toString(i));
            this.add(x);
        }

        for (int i = 1 ; i <= 10 ; i++){
            for (int j = 0 ; j <= 10 ; j++) {
                if (j == 0){
                    JLabel x = new JLabel();
                    x.setText("        " + Integer.toString(i));
                    this.add(x);
                    continue;
                }
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

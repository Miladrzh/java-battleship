package ir.aut.view.gameview.sea;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Milad on 6/15/2017.
 */
public class EnemySeaPanel extends SeaPanel {
    public EnemySeaPanel(int xCor, int yCor, int xSize, int ySize) {
        super(xCor, yCor, xSize, ySize);

        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (j == 0) {
                    JLabel x = new JLabel();
                    x.setText("        " + Integer.toString(i));
                    this.add(x);
                    continue;
                }
                SeaCell enemySeaCell = new EnemySeaCell(i, j);
                enemySeaCell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                if (i == 10)
                    enemySeaCell.setSheep(true);

                total.put(enemySeaCell.getCor(), enemySeaCell);
                this.add(enemySeaCell);
            }
        }
    }
}

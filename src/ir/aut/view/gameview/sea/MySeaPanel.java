package ir.aut.view.gameview.sea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Milad on 6/15/2017.
 */
public class MySeaPanel extends SeaPanel {
    public MySeaPanel(int xCor, int yCor, int xSize, int ySize) {
        super(xCor, yCor, xSize, ySize);
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (j == 0) {
                    JLabel x = new JLabel();
                    x.setText("        " + Integer.toString(i));
                    this.add(x);
                    continue;
                }
                SeaCell mySeaCell = new MySeaCell(i, j);
                mySeaCell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                if (i == 10)
                    mySeaCell.setShip(true);

                total.put(mySeaCell.getCor(), mySeaCell);
                this.add(mySeaCell);
            }
        }
        addKeyListener(new KeyHandler());
    }

    public void disableAllCells() {
        for (int i = 1; i < 11; i++)
            for (int j = 1; j < 11; j++) {
                total.get(new SeaCellCordinate(i, j)).setEnabled(false);
            }
    }

    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_R) {
                verticalPainting = !verticalPainting;
                repaint();
            }
        }
    }

}

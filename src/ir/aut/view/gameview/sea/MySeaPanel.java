package ir.aut.view.gameview.sea;

import ir.aut.tools.Rotator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
                SeaCell x = new MySeaCell(i, j);
                x.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                if (i == 10)
                    x.setSheep(true);

                total.put(x.getCor(), x);
                this.add(x);
            }
        }
        addKeyListener(new KeyHandler());
    }

    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_R) {
                Rectangle oldRec = rectangles.get(rectangles.size() - 1);
                rectangles.remove(rectangles.size() - 1);
                rectangles.add(Rotator.rotate90(oldRec));
                repaint();
            }
        }
    }
}

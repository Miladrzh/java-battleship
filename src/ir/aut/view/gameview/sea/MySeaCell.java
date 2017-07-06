package ir.aut.view.gameview.sea;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Milad on 6/15/2017.
 */
public class MySeaCell extends SeaCell {

    public MySeaCell(int xCor, int yCor) {
        super(xCor, yCor);
        CellListener cellListener = new CellListener();
        this.addMouseListener(cellListener);
        this.addMouseMotionListener(cellListener);
    }


    public class CellListener extends MouseAdapter implements MouseListener, MouseMotionListener {
        public CellListener() {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            Rectangle rec = new Rectangle(master.mousePoint.x, master.mousePoint.y, master.rectWidth, master.rectHeight);
            master.rectangles.add(rec);
            ((SeaCell) e.getSource()).setSheep(true);
            int x = ((SeaCell) e.getSource()).cor.xCor;
            int y = ((SeaCell) e.getSource()).cor.yCor;
            if (rec.height > rec.width) {
                switch (master.rectSize) {
                    case 4:
                        master.total.get(new SeaCellCordinate(x, y + 3)).setSheep(true);
                    case 3:
                        master.total.get(new SeaCellCordinate(x, y + 2)).setSheep(true);
                    case 2:
                        master.total.get(new SeaCellCordinate(x, y + 1)).setSheep(true);
                }
            } else {
                switch (master.rectSize) {
                    case 4:
                        master.total.get(new SeaCellCordinate(x + 3, y)).setSheep(true);
                    case 3:
                        master.total.get(new SeaCellCordinate(x + 2, y)).setSheep(true);
                    case 2:
                        master.total.get(new SeaCellCordinate(x + 1, y)).setSheep(true);
                }
            }
            master.rectSize = 0;
            master.rectHeight = 0;
            master.rectWidth = 0;
            master.mousePoint = null;
            master.requestFocus();
        }

        public void mouseMoved(MouseEvent e) {
            master.mousePoint = ((SeaCell) e.getSource()).getLocation();
            master.repaint();
        }
    }
}

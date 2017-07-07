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

    MySeaCell(int xCor, int yCor) {
        super(xCor, yCor);
        CellListener cellListener = new CellListener();
        this.addMouseListener(cellListener);
        this.addMouseMotionListener(cellListener);
    }


    public class CellListener extends MouseAdapter implements MouseListener, MouseMotionListener {
        CellListener() {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            Rectangle rec = new Rectangle(master.mousePoint.x, master.mousePoint.y, master.rectWidth, master.rectHeight);
            master.rectangles.add(rec);
            ((SeaCell) e.getSource()).setShip(true);
            int x = ((SeaCell) e.getSource()).cor.xCor;
            int y = ((SeaCell) e.getSource()).cor.yCor;
            SeaCell tmp;
            if (rec.height < rec.width) {
                switch (SeaPanel.rectSize) {
                    case 4:
                        tmp = master.total.get(new SeaCellCordinate(x, y + 3));
                        if (tmp != null) tmp.setShip(true);
                    case 3:
                        tmp = master.total.get(new SeaCellCordinate(x, y + 2));
                        if (tmp != null) tmp.setShip(true);
                    case 2:
                        tmp = master.total.get(new SeaCellCordinate(x, y + 1));
                        if (tmp != null) tmp.setShip(true);
                }
            } else {
                switch (SeaPanel.rectSize) {
                    case 4:
                        tmp = master.total.get(new SeaCellCordinate(x + 3, y));
                        if (tmp != null) tmp.setShip(true);
                    case 3:
                        tmp = master.total.get(new SeaCellCordinate(x + 2, y));
                        if (tmp != null) tmp.setShip(true);
                    case 2:
                        tmp = master.total.get(new SeaCellCordinate(x + 1, y));
                        if (tmp != null) tmp.setShip(true);
                }
            }

            SeaPanel.rectSize = 0;
            master.rectHeight = 0;
            master.rectWidth = 0;
            master.verticalPainting = true;
            master.mousePoint = null;
            master.requestFocus();
        }

        public void mouseMoved(MouseEvent e) {
            master.mousePoint = ((SeaCell) e.getSource()).getLocation();
            master.repaint();
        }
    }
}

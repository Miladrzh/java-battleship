package ir.aut.view.gameview;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Milad on 6/15/2017.
 */
public class MySeaCell extends SeaCell {

    public MySeaCell (int xCor, int yCor){
        super(xCor , yCor);
        CellListener cellListener = new CellListener();
        this.addMouseListener(cellListener);
        this.addMouseMotionListener(cellListener);
    }


    public class CellListener extends MouseAdapter implements MouseListener, MouseMotionListener {
        public CellListener() {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            master.rectangles.add(new Rectangle(master.mousePoint.x, master.mousePoint.y, master.rectWidth, master.rectHeight));
            System.out.println("we");
            master.RECT_SIZE = 0;
            master.rectHeight = 0;
            master.rectWidth = 0;
            master.mousePoint=null;

        }

        public void mouseMoved(MouseEvent e){

            master.mousePoint = ((SeaCell)e.getSource()).getLocation();
            System.out.println(master.RECT_SIZE);
            System.out.println(e.getPoint());
            master.repaint();
        }
    }
}

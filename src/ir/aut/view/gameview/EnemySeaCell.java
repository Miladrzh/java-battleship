package ir.aut.view.gameview;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Milad on 6/15/2017.
 */
public class EnemySeaCell extends SeaCell {
    public EnemySeaCell (int xCor, int yCor){
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
            if (((SeaCell) e.getSource()).isSheep()) {
                setHit((SeaCell) e.getSource());
                int x = ((SeaCell) e.getSource()).cor.xCor;
                int y = ((SeaCell) e.getSource()).cor.yCor;
                setClean(x + 1, y + 1);
                setClean(x + 1, y - 1);
                setClean(x - 1, y + 1);
                setClean(x - 1, y - 1);
            } else {
                setMiss((SeaCell) e.getSource());
            }
        }
    }

}

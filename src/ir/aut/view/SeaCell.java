package ir.aut.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;

/**
 * Created by Milad on 6/14/2017.
 */
public class SeaCell extends JLabel {
    private boolean sheep = false;
    public SeaCellCordinate cor;
    static HashMap < SeaCellCordinate , SeaCell > total = new HashMap<>();
    public SeaCell(int xCor , int yCor) {
        super();
        this.cor = new SeaCellCordinate(xCor , yCor);
        this.addMouseListener(new CellListener());
    }

    public SeaCellCordinate getCor(){
        return cor;
    }

    public boolean isSheep() {
        return sheep;
    }

    public void setSheep(boolean sheep) {
        this.sheep = sheep;
    }

    public boolean setHit(SeaCell source) {
        source.setOpaque(true);
        source.setBackground(new Color(50, 124, 13));
        return true;
    }

    public boolean setMiss(SeaCell source) {
        source.setOpaque(true);
        source.setBackground(new Color(255, 0, 0));
        return true;
    }

    public void setClean(int x , int y){
        if (x > 10 || x < 1)
            return;
        if (y > 10 || y < 1)
            return;
        SeaCell nei = total.get(new SeaCellCordinate(x , y));
        if (nei == null)
            return;

        nei.setOpaque(true);
        nei.setBackground(new Color(200 , 188, 19));
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
                setClean(x + 1 , y + 1);
                setClean(x + 1 , y - 1);
                setClean(x - 1 , y + 1);
                setClean(x - 1 , y - 1);
            } else {
                setMiss((SeaCell) e.getSource());
            }
        }
    }
}

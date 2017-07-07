package ir.aut.view.gameview.sea;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Milad on 6/14/2017.
 */
public abstract class SeaCell extends JLabel {
    private boolean isShip = false;
    public SeaCellCordinate cor;
    public SeaPanel master;

    public SeaCell() {
    }

    public SeaCell(int xCor, int yCor) {
        super();
        this.cor = new SeaCellCordinate(xCor, yCor);
    }

    public SeaCellCordinate getCor() {
        return cor;
    }

    public void setMaster(SeaPanel master) {
        this.master = master;
    }

    public boolean isShip() {
        return isShip;
    }

    public void setShip(boolean ship) {
        this.isShip = ship;
    }

    public boolean setHit(SeaCell source) {
        setEnabled(false);
        source.setOpaque(true);
        source.setBackground(new Color(50, 124, 13));
        return true;
    }

    public boolean setMiss(SeaCell source) {
        setEnabled(false);
        source.setOpaque(true);
        source.setBackground(new Color(255, 0, 0));
        return true;
    }

    public void setClean(int x, int y) {
        setEnabled(false);
        if (x > 10 || x < 1)
            return;
        if (y > 10 || y < 1)
            return;
        SeaCell nei = master.total.get(new SeaCellCordinate(x, y));
        if (nei == null)
            return;

        nei.setOpaque(true);
        nei.setBackground(new Color(151, 200, 185));
    }

    public boolean hit() {
        setEnabled(false);
        if (isShip()) {
            setHit(this);
            int x = this.cor.xCor;
            int y = this.cor.yCor;
            setClean(x + 1, y + 1);
            setClean(x + 1, y - 1);
            setClean(x - 1, y + 1);
            setClean(x - 1, y - 1);
            return true;
        } else {
            setMiss(this);
            return false;
        }
    }
}

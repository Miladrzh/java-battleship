package ir.aut.view.gameview.sea;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Milad on 6/14/2017.
 */
public abstract class SeaCell extends JLabel {
    private boolean isShip = false;
    SeaCellCordinate cor;
    SeaPanel master;

    public SeaCell() {
    }

    SeaCell(int xCor, int yCor) {
        super();
        this.cor = new SeaCellCordinate(xCor, yCor);
    }

    SeaCellCordinate getCor() {
        return cor;
    }

    public void setMaster(SeaPanel master) {
        this.master = master;
    }

    private boolean isShip() {
        return isShip;
    }

    void setShip(boolean ship) {
        this.isShip = ship;
        setBorder(BorderFactory.createLineBorder(Color.BLUE));
    }

    private boolean setHit(SeaCell source) {
        source.setOpaque(true);
        source.setBackground(new Color(50, 124, 13));
        setEnabled(false);
        return true;
    }

    private boolean setMiss(SeaCell source) {
        source.setOpaque(true);
        source.setBackground(new Color(255, 0, 0));
        setEnabled(false);
        return true;
    }

    private void setClean(int x, int y) {
        if (!(x > 10 || x < 1 || y > 10 || y < 1)) {
            SeaCell nei = master.total.get(new SeaCellCordinate(x, y));
            if (nei == null)
                return;

            nei.setOpaque(true);
            nei.setBackground(new Color(151, 200, 185));
            setEnabled(false);
        }
    }

    boolean hit() {
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

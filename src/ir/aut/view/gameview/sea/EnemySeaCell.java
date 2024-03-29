package ir.aut.view.gameview.sea;

import ir.aut.game.GuiInterface;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Milad on 6/15/2017.
 */
public class EnemySeaCell extends SeaCell {
    public static GuiInterface guiInterface;

    public EnemySeaCell(int xCor, int yCor) {
        super(xCor, yCor);
        CellListener cellListener = new CellListener();
        this.addMouseListener(cellListener);
        this.addMouseMotionListener(cellListener);
    }

    public void setGuiInterface(GuiInterface guiInterface) {
        this.guiInterface = guiInterface;
    }

    public class CellListener extends MouseAdapter implements MouseListener, MouseMotionListener {
        public CellListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (((SeaCell) e.getSource()).isEnabled()) {
                SeaCellCordinate cor = ((SeaCell) e.getSource()).cor;
                EnemySeaCell.guiInterface.hit(cor.xCor, cor.yCor);
            }
        }
    }
}

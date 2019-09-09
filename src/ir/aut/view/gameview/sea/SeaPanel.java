package ir.aut.view.gameview.sea;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Milad on 6/14/2017.
 */
public abstract class SeaPanel extends JPanel {
    public static int rectSize = 0;
    boolean verticalPainting;
    int rectWidth, rectHeight;
    ArrayList<Rectangle> rectangles;
    Point mousePoint;
    protected HashMap<SeaCellCordinate, SeaCell> total = new HashMap<>();

    public SeaPanel() {

    }

    SeaPanel(int xCor, int yCor, int xSize, int ySize) {
        super();
        rectangles = new ArrayList<>();
        this.setBackground(new Color(228, 245, 240));
        this.setSize(xSize, ySize);
        this.setLocation(xCor, yCor);
        GridLayout manager = new GridLayout(11, 11);
        this.setLayout(manager);
        JLabel y = new JLabel();
        this.add(y);
        for (char i = 'A'; i <= 'J'; i++) {
            JLabel x = new JLabel();
            x.setText("      " + Character.toString(i));
            this.add(x);
        }
        verticalPainting = true;
        this.setVisible(true);
    }

    public boolean hit(SeaCellCordinate cor) {
        SeaCell now = total.get(cor);
        return now.hit();
    }

    public void setEnableAllCells(boolean enable) {
        for (int i = 1; i < 11; i++)
            for (int j = 1; j < 11; j++) {
                SeaCell seaCell = total.get(new SeaCellCordinate(i, j));
                seaCell.setEnabled(!seaCell.isUnusable() && enable);
            }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
        if (!rectangles.isEmpty()) {
            for (Rectangle anRectangle : rectangles) {
                g.fillRect(anRectangle.x, anRectangle.y, anRectangle.width, anRectangle.height);
            }
        }
        rectWidth = total.get(new SeaCellCordinate(1, 1)).getWidth();
        rectHeight = total.get(new SeaCellCordinate(1, 1)).getHeight();
        if (verticalPainting) {
            rectHeight *= rectSize;
        } else {
            rectWidth *= rectSize;
        }
        if (mousePoint != null)
            g.fillRect(mousePoint.x, mousePoint.y, rectWidth, rectHeight);
    }
}

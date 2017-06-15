package ir.aut.view.gameview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Milad on 6/14/2017.
 */
public class SeaPanel extends JPanel {
    static int RECT_SIZE = 0;
    int rectWidth, rectHeight;
    ArrayList<Rectangle> rectangles;
    Point mousePoint;
    public HashMap<SeaCellCordinate, SeaCell> total = new HashMap<>();

    public SeaPanel(int xCor, int yCor, int xSize, int ySize) {
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

        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (j == 0) {
                    JLabel x = new JLabel();
                    x.setText("        " + Integer.toString(i));
                    this.add(x);
                    continue;
                }
                SeaCell x = new SeaCell(i, j);
                x.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                if (i == 10)
                    x.setSheep(true);

                total.put(x.getCor(), x);
                this.add(x);
            }
        }
        this.setVisible(true);
        addMouseMotionListener(new MouseHandler());
    }

    public boolean hit(SeaCellCordinate cor) {
        SeaCell now = total.get(cor);
        if (now == null)
            return false;
        now.hit();
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.blue);
        if (!rectangles.isEmpty()) {
            for (Rectangle anRectangle : rectangles) {
                g.fillRect(anRectangle.x, anRectangle.y, anRectangle.width, anRectangle.height);
            }
        }
        rectWidth = total.get(new SeaCellCordinate(1, 1)).getWidth();
        rectHeight = total.get(new SeaCellCordinate(1, 1)).getHeight();
        rectHeight *= RECT_SIZE;
        if (mousePoint != null)
            g.fillRect(mousePoint.x, mousePoint.y, rectWidth, rectHeight);
    }

    private class MouseHandler extends MouseAdapter implements MouseMotionListener {
        @Override
        public void mouseReleased(MouseEvent e) {
            rectangles.add(new Rectangle(mousePoint.x, mousePoint.y, rectWidth, rectHeight));
            RECT_SIZE = 0;
            rectHeight = 0;
            rectWidth = 0;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            mousePoint = e.getPoint();
            System.out.println("hello3333");
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            System.out.println("hello");
        }
    }
}

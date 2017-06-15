package ir.aut.view.gameview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Milad on 6/15/2017.
 */
public class BeforeGameBottomPanel extends JPanel {
    public JButton reset, ready;
    public JLabel block4, block3, block2, block1;
    public JLabel fourLbl, threeLbl, twoLbl, oneLbl;

    private GameFrame master;

    public BeforeGameBottomPanel(int xCor, int yCor, int xSize, int ySize) {
        super();
        this.setLayout(null);
        this.setLocation(xCor, yCor);
        this.setSize(xSize, ySize);
        this.setBackground(new Color(229, 212, 104));
        //Reset Button
        reset = new JButton("Reset");
        reset.setSize(80, 30);
        reset.setLocation(465, 80);
        reset.setVisible(true);
        reset.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                master.resetBeforeBottomPanel();
            }
        });
        this.add(reset);

        // Ready Button
        ready = new JButton("Ready");
        ready.setSize(80, 30);
        ready.setLocation(560, 80);
        ready.setVisible(true);
        ready.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (master == null)
                    System.out.println("Sdfds");
                master.changeBottomPanel();
            }
        });
        this.add(ready);

        // blockS
        block4 = new JLabel("x1");
        block3 = new JLabel("x2");
        block2 = new JLabel("x3");
        block1 = new JLabel("x4");
        fourLbl = new JLabel();
        threeLbl = new JLabel();
        twoLbl = new JLabel();
        oneLbl = new JLabel();

        block4.setBounds(180, 10, 30, 20);
        block3.setBounds(180, 35, 30, 20);
        block2.setBounds(180, 65, 30, 20);
        block1.setBounds(180, 90, 30, 20);
        fourLbl.setBounds(10, 10, 150, 20);
        threeLbl.setBounds(10, 35, 112, 20);
        twoLbl.setBounds(10, 65, 75, 20);
        oneLbl.setBounds(10, 90, 35, 20);
        fourLbl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        threeLbl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        twoLbl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        oneLbl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fourLbl.setOpaque(true);
        threeLbl.setOpaque(true);
        twoLbl.setOpaque(true);
        oneLbl.setOpaque(true);
        fourLbl.setBackground(new Color(102, 158, 200));
        threeLbl.setBackground(new Color(102, 158, 200));
        twoLbl.setBackground(new Color(102, 158, 200));
        oneLbl.setBackground(new Color(102, 158, 200));

        this.add(block1);
        this.add(block2);
        this.add(block3);
        this.add(block4);
        this.add(fourLbl);
        this.add(threeLbl);
        this.add(twoLbl);
        this.add(oneLbl);

        MouseHandler mh = new MouseHandler();
        block4.addMouseListener(mh);
        block3.addMouseListener(mh);
        block2.addMouseListener(mh);
        block1.addMouseListener(mh);
        this.setVisible(true);
    }


    public void setBlock4(String s) {
        block4.setText(s);
    }

    public void setBlock3(String s) {
        block3.setText(s);
    }

    public void setBlock2(String s) {
        block2.setText(s);
    }

    public void setBlock1(String s) {
        block1.setText(s);
    }

    public void setMaster(GameFrame master) {
        if (master == null)
            System.out.println("wer");
        this.master = master;
    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getSource() == block4) {
                SeaPanel.RECT_SIZE = 4;
                fourLbl.setText("x" + (Character.getNumericValue(fourLbl.getText().charAt(1)) - 1));
            } else if (e.getSource() == block3) {
                SeaPanel.RECT_SIZE = 3;
                threeLbl.setText("x" + (Character.getNumericValue(threeLbl.getText().charAt(1)) - 1));
            } else if (e.getSource() == block2) {
                SeaPanel.RECT_SIZE = 2;
                twoLbl.setText("x" + (Character.getNumericValue(twoLbl.getText().charAt(1)) - 1));
            } else if (e.getSource() == block1) {
                SeaPanel.RECT_SIZE = 1;
                oneLbl.setText("x" + (Character.getNumericValue(oneLbl.getText().charAt(1)) - 1));
            }
        }
    }
}
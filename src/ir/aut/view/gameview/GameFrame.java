package ir.aut.view.gameview;

import javax.swing.*;

/**
 * Created by Milad on 6/14/2017.
 */
public class GameFrame extends JFrame {
    SeaPanel sea = new SeaPanel(92, 65, 438, 438);
    MenuBar menuBar = new MenuBar(0,0,666,30);
    InGameBottomPanel inGameBottomPanel  = new InGameBottomPanel("reza",0,550,666,150);
    BeforeGameBottomPanel beforeGameBottomPanel = new BeforeGameBottomPanel(0,550,666,150);
    public GameFrame(int xCor, int yCor, int xSize, int ySize) {
        super();
        this.setLayout(null);
        this.setLocation(xCor, yCor);
        this.setSize(xSize, ySize);
        this.add(sea);
        this.add(menuBar);
//        this.add(inGameBottomPanel);
        this.add(beforeGameBottomPanel);
        inGameBottomPanel.setVisible(false);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void changeBottomPanel(){

    }
}

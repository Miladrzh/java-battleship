package ir.aut.view.gameview;

import javax.swing.*;

/**
 * Created by Milad on 6/14/2017.
 */
public class GameFrame extends JFrame {
    SeaPanel sea;
    MenuBar menuBar;
    InGameBottomPanel inGameBottomPanel;
    BeforeGameBottomPanel beforeGameBottomPanel;
    public GameFrame(int xCor, int yCor, int xSize, int ySize) {
        super();
        sea = new SeaPanel(92, 65, 438, 438);
        menuBar = new MenuBar(0,0,666,30);
        inGameBottomPanel  = new InGameBottomPanel("reza",0,550,666,150);
        beforeGameBottomPanel = new BeforeGameBottomPanel(0,550,666,150);
        inGameBottomPanel.setVisible(false);
        beforeGameBottomPanel.setVisible(true);
        this.setLayout(null);
        this.setLocation(xCor, yCor);
        this.setSize(xSize, ySize);
        this.add(sea);
        this.add(menuBar);
        this.add(inGameBottomPanel);
        this.add(beforeGameBottomPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public  void changeBottomPanel(){
        System.out.println("change");
        inGameBottomPanel.setVisible(true);
        beforeGameBottomPanel.setVisible(false);
    }

    public void resetBeforeBottomPanel(){
        beforeGameBottomPanel.setVisible(false);
        sea.setVisible(false);

        sea = new SeaPanel(92, 65, 438, 438);
        beforeGameBottomPanel = new BeforeGameBottomPanel(0,550,666,150);
        beforeGameBottomPanel.setMaster(this);

        this.add(sea);
        this.add(beforeGameBottomPanel);
    }

    public BeforeGameBottomPanel getBeforeGameBottomPanel() {
        return beforeGameBottomPanel;
    }

    public InGameBottomPanel getInGameBottomPanel() {
        return inGameBottomPanel;
    }
}

package ir.aut.view.gameview;

import javax.swing.*;

/**
 * Created by Milad on 6/14/2017.
 */
public class GameFrame extends JFrame {
    public MasterSeaPanel myMasterSea;
    public SeaPanel mySea;
    public MenuBar menuBar;
    public InGameBottomPanel inGameBottomPanel;
    public BeforeGameBottomPanel beforeGameBottomPanel;
    public GameChatPanel gameChatPanel;

    public GameFrame(int xCor, int yCor, int xSize, int ySize) {
        super();
        myMasterSea = new MasterSeaPanel(92, 65, 438, 438);
        mySea = myMasterSea.seaPanel;
        menuBar = new MenuBar(0, 0, 666, 30);
        inGameBottomPanel = new InGameBottomPanel("reza", 0, 550, 666, 150);
        beforeGameBottomPanel = new BeforeGameBottomPanel(0, 550, 666, 150);
        gameChatPanel = new GameChatPanel("reza", 667, 0, 332, 690);
        inGameBottomPanel.setVisible(false);
        beforeGameBottomPanel.setVisible(true);
        this.setLayout(null);
        this.setLocation(xCor, yCor);
        this.setSize(xSize, ySize);
        this.add(mySea);
        this.add(menuBar);
        this.add(inGameBottomPanel);
        this.add(beforeGameBottomPanel);
        this.add(gameChatPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void changeBottomPanel() {
        System.out.println("change");
        inGameBottomPanel.setVisible(true);
        beforeGameBottomPanel.setVisible(false);
    }

    public void resetBeforeBottomPanel() {
        beforeGameBottomPanel.setVisible(false);
        mySea.setVisible(false);

        mySea = new SeaPanel(92, 65, 438, 438);
        beforeGameBottomPanel = new BeforeGameBottomPanel(0, 550, 666, 150);
        beforeGameBottomPanel.setMaster(this);

        this.add(mySea);
        this.add(beforeGameBottomPanel);
    }

    public BeforeGameBottomPanel getBeforeGameBottomPanel() {
        return beforeGameBottomPanel;
    }

    public InGameBottomPanel getInGameBottomPanel() {
        return inGameBottomPanel;
    }
}

package ir.aut.view.gameview;

import ir.aut.game.GameFrameCallBack;
import ir.aut.view.gameview.sea.EnemySeaPanel;
import ir.aut.view.gameview.sea.MasterSeaPanel;
import ir.aut.view.gameview.sea.MySeaPanel;

import javax.swing.*;

/**
 * Created by Milad on 6/14/2017.
 */
public class GameFrame extends JFrame {
    public MasterSeaPanel enemyMasterSea;
    public EnemySeaPanel enemySea;
    public MasterSeaPanel myMasterSea;
    public MySeaPanel mySea;
    public MenuBar menuBar;
    public InGameBottomPanel inGameBottomPanel;
    public BeforeGameBottomPanel beforeGameBottomPanel;
    public GameChatPanel gameChatPanel;
    private GameFrameCallBack gameFrameCallBack;

    public GameFrame(GameFrameCallBack gameFrameCallBack, int xCor, int yCor, int xSize, int ySize) {
        super("Battle Ship :)");
        this.gameFrameCallBack = gameFrameCallBack;
        myMasterSea = new MasterSeaPanel(92, 65, 438, 438, false);
        enemyMasterSea = new MasterSeaPanel(92, 65, 438, 438, true);
        mySea = (MySeaPanel) myMasterSea.seaPanel;
        enemySea = (EnemySeaPanel) enemyMasterSea.seaPanel;
        enemySea.setVisible(false);

        menuBar = new MenuBar(0, 0, 666, 30);
        inGameBottomPanel = new InGameBottomPanel("reza", 0, 550, 666, 150);
        beforeGameBottomPanel = new BeforeGameBottomPanel(0, 550, 666, 150);
        gameChatPanel = new GameChatPanel("reza", 667, 0, 332, 690);
        inGameBottomPanel.setVisible(false);
        beforeGameBottomPanel.setVisible(true);


        this.setLayout(null);
        this.setLocation(xCor, yCor);
        this.setSize(xSize, ySize);

        this.add(enemySea);
        this.add(mySea);
        this.add(menuBar);
        this.add(inGameBottomPanel);
        this.add(beforeGameBottomPanel);
        this.add(gameChatPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void changePanelStates() {
        inGameBottomPanel.setVisible(true);
        beforeGameBottomPanel.setVisible(false);
        enemySea.setVisible(!enemySea.isVisible());
        mySea.setVisible(!mySea.isVisible());
    }

    public void resetBeforeBottomPanel() {
        beforeGameBottomPanel.setVisible(false);
        mySea.setVisible(false);

        myMasterSea = new MasterSeaPanel(92, 65, 438, 438, false);
        mySea = (MySeaPanel) myMasterSea.seaPanel;
        beforeGameBottomPanel = new BeforeGameBottomPanel(0, 550, 666, 150);
        beforeGameBottomPanel.setMaster(this);

        this.add(mySea);
        this.add(beforeGameBottomPanel);
    }

    public void showMySea() {
        enemySea.setVisible(false);
        mySea.setVisible(true);
    }


    public void showEnemySea() {
        mySea.setVisible(false);
        enemySea.setVisible(true);
    }

    public BeforeGameBottomPanel getBeforeGameBottomPanel() {
        return beforeGameBottomPanel;
    }

    public InGameBottomPanel getInGameBottomPanel() {
        return inGameBottomPanel;
    }
}

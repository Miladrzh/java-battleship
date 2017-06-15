package ir.aut.view.gameview;

/**
 * Created by Milad on 6/15/2017.
 */
public class MasterGameFrame {
    public GameFrame gameFrame;

    public MasterGameFrame(int xCor, int yCor, int xSize, int ySize) {
        gameFrame = new GameFrame(xCor, yCor, xSize, ySize);
        gameFrame.getBeforeGameBottomPanel().setMaster(gameFrame);
        gameFrame.getInGameBottomPanel().setMaster(gameFrame);
    }
}

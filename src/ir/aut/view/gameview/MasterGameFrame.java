package ir.aut.view.gameview;

import ir.aut.game.GameFrameCallBack;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Milad on 6/15/2017.
 */
public class MasterGameFrame {
    public GameFrame gameFrame;
    private GameFrameCallBack gameFrameCallBack;

    public MasterGameFrame(GameFrameCallBack gameFrameCallBack, int xCor, int yCor, int xSize, int ySize) {
        this.gameFrameCallBack = gameFrameCallBack;
        gameFrame = new GameFrame(gameFrameCallBack, xCor, yCor, xSize, ySize);
        gameFrame.getBeforeGameBottomPanel().setMaster(gameFrame);
        gameFrame.getInGameBottomPanel().setMaster(gameFrame);

    }
}

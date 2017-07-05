package ir.aut.game;

import ir.aut.logic.MessageManager;
import ir.aut.view.ConnectionModeFrame;
import ir.aut.view.PleaseWaitFrame;
import ir.aut.view.WaitingForConnectionFrame;

/**
 * Created by Milad on 7/5/2017.
 */
public class Game implements ModeFrameCallback,PleaseWaitFrameCallBack,WaitForConnectionCallBack,GameInterface {
    MessageManager messageManager;
    ConnectionModeFrame connectionModeFrame;
    WaitingForConnectionFrame waitingForConnectionFrame;
    PleaseWaitFrame pleaseWaitFrame;

    public Game() {

    }

    public void start() {
        startConnectionModeFrame();
    }

    public void startConnectionModeFrame() {
        connectionModeFrame = new ConnectionModeFrame(this);
    }

    public void closeModeFrame(){
        connectionModeFrame.setVisible(false);
    }

    public void startWaitForConnectionFrame(){
        waitingForConnectionFrame = new WaitingForConnectionFrame(this);
    }

    public void startPleaseWaitFrame(){
        pleaseWaitFrame = new PleaseWaitFrame(this);
    }

    public void cancelPleaseWaitFrame (){
        pleaseWaitFrame.setVisible(false);
    }

    @Override
    public void setMessageManager(MessageManager messageManager) {
        this.messageManager = messageManager;
        messageManager.setGameInterface(this);
    }
}

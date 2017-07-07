package ir.aut.game;

import ir.aut.logic.MessageManager;
import ir.aut.logic.messages.ApplyStatusMessage;
import ir.aut.logic.messages.FeedbackMessage;
import ir.aut.logic.messages.HitMessage;
import ir.aut.logic.messages.RequestGameMessage;
import ir.aut.view.ConnectionModeFrame;
import ir.aut.view.PleaseWaitFrame;
import ir.aut.view.WaitingForConnectionFrame;
import ir.aut.view.gameview.MasterGameFrame;
import ir.aut.view.gameview.sea.SeaCellCordinate;

/**
 * Created by Milad on 7/5/2017.
 */
public class Game implements ModeFrameCallback, PleaseWaitFrameCallBack, WaitForConnectionCallBack, GameInterface, GameFrameCallBack, GuiInterface {
    MasterGameFrame masterGameFrame;
    MessageManager messageManager;
    ConnectionModeFrame connectionModeFrame;
    WaitingForConnectionFrame waitingForConnectionFrame;
    PleaseWaitFrame pleaseWaitFrame;
    String name = "";

    public Game() {

    }

    public void start() {
        startConnectionModeFrame();
    }

    public void startConnectionModeFrame() {
        connectionModeFrame = new ConnectionModeFrame(this);
    }

    public void closeModeFrame() {
        connectionModeFrame.setVisible(false);
    }

    public void startWaitForConnectionFrame() {
        waitingForConnectionFrame = new WaitingForConnectionFrame(this);
    }

    public void startPleaseWaitFrame() {
        pleaseWaitFrame = new PleaseWaitFrame(this);
    }

    public void cancelPleaseWaitFrame() {
        pleaseWaitFrame.setVisible(false);
    }

    @Override
    public void setMessageManager(MessageManager messageManager) {
        this.messageManager = messageManager;
        messageManager.setGameInterface(this);
    }

    @Override
    public void sendRequest(String ip, String name) {
        messageManager.send(new RequestGameMessage(ip, name));
    }

    @Override
    public void addRequest(String ip, String name) {
        waitingForConnectionFrame.addToFrame(name, ip);
    }

    @Override
    public void applyAccepted() {
        masterGameFrame = new MasterGameFrame(this, 50, 50, 1000, 700);
    }

    @Override
    public void applyRejected() {
        this.start();
    }

    @Override
    public void setNameOfPlayer(String x) {
        name = x;
    }

    public void hostResponse(String ip, ApplyStatusMessage message) {
        messageManager.send(ip, message);
        if (message.status == 1)
            masterGameFrame = new MasterGameFrame(this, 50, 50, 1000, 700);
        waitingForConnectionFrame.validate();
    }

    @Override
    public void hit(int i, int j) {
        messageManager.send(new HitMessage(i, j));
    }

    @Override
    public void hitResponse(int i, int j) {
        boolean isHit = masterGameFrame.gameFrame.mySea.hit(new SeaCellCordinate(i, j));
        if (isHit) {
            messageManager.send(new FeedbackMessage(i, j, 1));
        } else {
            messageManager.send(new FeedbackMessage(i, j, 0));
        }
    }

    @Override
    public void attackFeedback(int i, int j, boolean isShip) {
        if (isShip)
            masterGameFrame.gameFrame.enemySea.setShip(new SeaCellCordinate(i, j));
        masterGameFrame.gameFrame.enemySea.hit(new SeaCellCordinate(i, j));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        masterGameFrame.gameFrame.changePanelStates();
    }
}


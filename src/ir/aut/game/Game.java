package ir.aut.game;

import ir.aut.logic.MessageManager;
import ir.aut.logic.messages.*;
import ir.aut.view.ConnectionModeFrame;
import ir.aut.view.MessagePanel;
import ir.aut.view.PleaseWaitFrame;
import ir.aut.view.WaitingForConnectionFrame;
import ir.aut.view.gameview.MasterGameFrame;
import ir.aut.view.gameview.sea.EnemySeaCell;
import ir.aut.view.gameview.sea.SeaCellCordinate;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Milad on 7/5/2017.
 */
public class Game implements ModeFrameCallback, PleaseWaitFrameCallBack, WaitForConnectionCallBack, GameInterface, GameFrameCallBack, GuiInterface {
    boolean iAmReady, enemyIsReady;
    int hitShips = 0;
    int enemyHitShips = 0;
    private MasterGameFrame masterGameFrame;
    private MessageManager messageManager;
    private ConnectionModeFrame connectionModeFrame;
    private WaitingForConnectionFrame waitingForConnectionFrame;
    private PleaseWaitFrame pleaseWaitFrame;
    String myName, enemyName, myIp, enemyIp;

    public Game() {
        EnemySeaCell.guiInterface = this;
    }

    public void start() {
        startConnectionModeFrame();
    }

    private void startConnectionModeFrame() {
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
    public void sendReady() {
        iAmReady = true;

        masterGameFrame.gameFrame.beforeGameBottomPanel.reset.setVisible(false);
        masterGameFrame.gameFrame.beforeGameBottomPanel.ready.setText("Waiting");
        masterGameFrame.gameFrame.beforeGameBottomPanel.ready.setEnabled(false);

        messageManager.send(new ReadyMessage());
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
        pleaseWaitFrame.setVisible(false);
    }

    @Override
    public void youLose() {
        JOptionPane.showMessageDialog(null, "You Win !", "", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    @Override
    public void applyRejected() {
        this.start();
    }

    @Override
    public String getEnemyIp() {
        return enemyIp;
    }

    @Override
    public String getMyIp() {
        return myIp;
    }

    @Override
    public String getEnemyName() {
        return enemyName;
    }

    @Override
    public String getMyName() {
        return myName;
    }

    @Override
    public void setMyName(String x) {
        this.myName = x;
    }

    @Override
    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
        try {
            masterGameFrame.gameFrame.chatToLbl.setText("Chat to: " + enemyName);
            masterGameFrame.gameFrame.chatPanel.setEnemyName(enemyName);
        } catch (Exception e) {

        }
    }

    public void setEnemyIp(String enemyIp) {
        this.enemyIp = enemyIp;
    }

    @Override
    public void setMyIP(String ip) {
        this.myIp = ip;
    }

    public void hostResponse(String ip, ApplyStatusMessage message) {
        messageManager.send(ip, message);
        if (message.status == 1) {
            messageManager.send(new ChatMessage(myName, MessageTypes.HAZLIAT));
            System.out.println("my name is " + myName);
            masterGameFrame = new MasterGameFrame(this, 50, 50, 1000, 700);
            masterGameFrame.gameFrame.chatToLbl.setText("Chat to: " + enemyName);
            waitingForConnectionFrame.setVisible(false);
        }
        waitingForConnectionFrame.validate();
    }

    @Override
    public void hit(int i, int j) {
        System.out.println(myIp + " " + myName);
        System.out.println(enemyIp + " " + enemyName);
        messageManager.send(new HitMessage(i, j));
        masterGameFrame.gameFrame.enemySea.setEnableAllCells(false);
    }

    @Override
    public void hitResponse(int i, int j) {
        boolean isHit = masterGameFrame.gameFrame.mySea.hit(new SeaCellCordinate(i, j));
        if (isHit) {
            messageManager.send(new FeedbackMessage(i, j, 1));
            enemyHitShips++;
            masterGameFrame.gameFrame.inGameBottomPanel.setEnemyHits(enemyHitShips);
        } else {
            messageManager.send(new FeedbackMessage(i, j, 0));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            masterGameFrame.gameFrame.changePanelStates();
        }
    }

    @Override
    public void attackFeedback(int i, int j, boolean isShip) {
        if (isShip) {
            masterGameFrame.gameFrame.enemySea.setShip(new SeaCellCordinate(i, j));
            hitShips++;
            masterGameFrame.gameFrame.inGameBottomPanel.setYourHits(hitShips);
        }

        masterGameFrame.gameFrame.enemySea.hit(new SeaCellCordinate(i, j));
        masterGameFrame.gameFrame.enemySea.setEnableAllCells(true);
        if (hitShips == 20) {
            youWin();
        }
        if (!isShip) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            masterGameFrame.gameFrame.changePanelStates();
        }
    }

    @Override
    public void ready() {
        if (iAmReady) {
            int x = (int) Math.random();
            if (x % 2 == 1) {
                masterGameFrame.gameFrame.changePanelStates();
                messageManager.send(new ChatMessage("you", MessageTypes.WHO_START));
            } else {
                masterGameFrame.gameFrame.inGameBottomPanel.setVisible(true);
                masterGameFrame.gameFrame.beforeGameBottomPanel.setVisible(false);
                messageManager.send(new ChatMessage("me", MessageTypes.WHO_START));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Your opponent is ready!", "Notification", JOptionPane.PLAIN_MESSAGE);
            enemyIsReady = true;
        }
    }

    @Override
    public void meStart() {
        masterGameFrame.gameFrame.changePanelStates();
    }

    @Override
    public void enemyStart() {
        masterGameFrame.gameFrame.inGameBottomPanel.setVisible(true);
        masterGameFrame.gameFrame.beforeGameBottomPanel.setVisible(false);
    }

    private void youWin() {
        messageManager.send(new YouLoseMessage());
        JOptionPane.showMessageDialog(null, "You Win !", "", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    @Override
    public void sendMessage(ChatMessage chatMessage) {
        messageManager.send(chatMessage);
    }

    @Override
    public void addChatMessage(ChatMessage chatMessage) {
        masterGameFrame.gameFrame.chatPanel.addMessage(chatMessage.getTextMessage(), new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date()), MessagePanel.ENEMY);
    }

    @Override
    public void connectionLostEffect(boolean opponentIsServer) {
        JOptionPane.showMessageDialog(null, "Connection is lost :(", "Notification", JOptionPane.ERROR_MESSAGE);
        messageManager.getCurrentNetwork().stopSelf();
        if (opponentIsServer) {
            startConnectionModeFrame();
        } else {
            masterGameFrame.gameFrame.setVisible(false);
            waitingForConnectionFrame.setVisible(true);
        }
    }

    @Override
    public void sendConnectionLostMessage() {
        if (messageManager.getmServerSocketHandler() == null) {
            messageManager.send(new ConnectionLostMessage((byte) 0));
        } else {
            messageManager.send(new ConnectionLostMessage((byte) 1));
        }
        messageManager.getCurrentNetwork().stopSelf();
    }
}

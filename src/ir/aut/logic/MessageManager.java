package ir.aut.logic;

import ir.aut.game.GameInterface;
import ir.aut.logic.messages.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Milad on 7/4/2017.
 */
public class MessageManager implements INetworkHandlerCallback, IServerSocketHandlerCallback {
    private GameInterface gameInterface;
    private ServerSocketHandler mServerSocketHandler;
    private List<NetworkHandler> mNetworkHandlerList;
    private NetworkHandler currentNetwork;

    /**
     * Instantiate server socket handler and start it. (Call this constructor in host mode)
     */
    public MessageManager(int port) {
        mNetworkHandlerList = new LinkedList<>();
        mServerSocketHandler = new ServerSocketHandler(port, this, this);
        mServerSocketHandler.start();
    }

    /**
     * Instantiate a network handler and start it. (Call this constructor in guest mode)
     */
    public MessageManager(String ip, int port) {
        try {
            currentNetwork = new NetworkHandler(new Socket(InetAddress.getByName(ip), port), this);
            currentNetwork.start();
            mNetworkHandlerList = new LinkedList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setGameInterface(GameInterface gameInterface) {
        this.gameInterface = gameInterface;
    }

    public void send(String to, BaseMessage message) {
        for (NetworkHandler i : mNetworkHandlerList) {
            to = "/".concat(to);
            System.out.println(to);
            System.out.println(i.getID());
            System.out.println();
            if (i.getID().equals(to)) {
                currentNetwork = i;
                i.sendMessage(message);
                break;
            }
        }
    }

    public void send(BaseMessage message) {
        currentNetwork.sendMessage(message);
    }

    // type 1
    private void consumeRequestMessage(RequestGameMessage message) {
        gameInterface.addRequest(message.ip, message.name);
    }

    private void consumeChatMessage(ChatMessage chatMessage) {
        if (chatMessage.getTextMessage().equals(MessageTypes.HAZLIAT)) {
            gameInterface.setEnemyName(chatMessage.getName());
            System.out.println(chatMessage.getName());
        }
        else
            gameInterface.addChatMessage(chatMessage);
    }

    //type 3
    private void consumeHitMessage(HitMessage message) {
        gameInterface.hitResponse(message.getxCor(), message.getyCor());
    }

    //type 4
    private void consumeFeedbackMessage(FeedbackMessage message) {
        gameInterface.attackFeedback(message.xCor, message.yCor, message.status == 1);
    }

    // type 5
    private void consumeApplyStatusMessage(ApplyStatusMessage message) {
        if (message.status == 0) {
            gameInterface.applyRejected();
        } else {
            gameInterface.applyAccepted();
        }
    }

    //type 6
    private void consumeReadyMessage() {
        gameInterface.ready();
    }

    //type 7
    private void consumeYouLoseMessage() {
        gameInterface.youLose();
    }

    /**
     * Add network handler to the list.
     */
//    @Override
    public void onNewConnectionReceived(NetworkHandler networkHandler) {
        mNetworkHandlerList.add(networkHandler);
        networkHandler.start();
    }

    /**
     * IMPORTANT: Request login is an example message and doesn’t relate to this project!
     * According to the message type of baseMessage, call corresponding method to use it.
     */
    @Override
    public void onMessageReceived(BaseMessage baseMessage) {

        switch (baseMessage.getMessageType()) {
            case MessageTypes.APPLY_STATUS:
                consumeApplyStatusMessage((ApplyStatusMessage) baseMessage);
                break;
            case MessageTypes.REQUEST_GAME:
                consumeRequestMessage((RequestGameMessage) baseMessage);
                break;
            case MessageTypes.CHAT:
                consumeChatMessage((ChatMessage) baseMessage);
                break;
            case MessageTypes.HIT:
                consumeHitMessage((HitMessage) baseMessage);
                break;
            case MessageTypes.FEEDBACK:
                consumeFeedbackMessage((FeedbackMessage) baseMessage);
                break;
            case MessageTypes.READY:
                consumeReadyMessage();
                break;
            case MessageTypes.YOU_LOSE:
                consumeYouLoseMessage();
                break;
        }
    }

    @Override
    public void onSocketClosed() {
// TODO : implement !!
    }
}

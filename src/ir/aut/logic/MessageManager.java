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
                System.out.println("ip is equal");
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
    void consumeRequestMessage(RequestGameMessage message) {
        gameInterface.addRequest(message.ip, message.name);
    }

    //type 3
    void consumeHitMessage(HitMessage message) {
        gameInterface.hitResponse(message.getxCor(), message.getyCor());
    }

    //type 4
    void consumeFeedbackMessage(FeedbackMessage message) {
        gameInterface.attackFeedback(message.xCor, message.yCor, message.status == 1);
    }

    // type 5
    void consumeApplyStatusMessage(ApplyStatusMessage message) {
        System.out.println("miad tu consume apply status");
        if (message.status == 0) {
            gameInterface.applyRejected();
        } else {
            gameInterface.applyAccepted();
        }
    }


//    /**
//     * IMPORTANT: Request login is an example message and doesn’t relate to this project!
//     * Create a RequestLoginMessage object and sent it through the appropriate network handler.
//     */
//    public void sendRequestLogin(String to, String username, String password) {
//
//    }
//
//    /**
//     * IMPORTANT: Request login is an example message and doesn’t relate to this project!
//     * Use the message.
//     */
//    private void consumeRequestLogin(RequestLoginMessage message) {
//    }

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
            case MessageTypes.HIT:
                consumeHitMessage((HitMessage) baseMessage);
                break;
            case MessageTypes.FEEDBACK:
                consumeFeedbackMessage((FeedbackMessage) baseMessage);
                break;
        }
    }

    @Override
    public void onSocketClosed() {
// TODO : implement !!
    }
}

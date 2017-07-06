package ir.aut.logic;

import ir.aut.game.GameInterface;
import ir.aut.logic.messages.ApplyStatusMessage;
import ir.aut.logic.messages.BaseMessage;
import ir.aut.logic.messages.MessageTypes;
import ir.aut.logic.messages.RequestGameMessage;
import ir.aut.view.gameview.GameFrame;

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
            if(this==null)
                System.out.println("salmmmmmm");
            System.out.println("dwdwdqw");
            System.out.println(ip);
            NetworkHandler now = new NetworkHandler(new Socket(InetAddress.getByName(ip), port), this);
            currentNetwork = now;
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
            System.out.println("network is:");
            System.out.println(i.getID());
            if (i.getID().equals(to)) {
                i.sendMessage(message);
                break;
            }
        }
    }

    public void send(BaseMessage message) {
        System.out.println("now we are in current network");
        currentNetwork.sendMessage(message);
    }

    // type 1
    void consumeRequestMessage(RequestGameMessage message){
        gameInterface.addRequest(message.ip , message.name);
    }

    // type 5
    public void consumeApplyStatusMessage(ApplyStatusMessage message) {
        if (message.status == 1) {
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
        System.out.println("hj;jiosfknewlsfkefnesfklednklfaenkflnae");
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
                consumeRequestMessage((RequestGameMessage)baseMessage);
                System.out.println("reqyest game switch case");
                break;
        }
    }

    @Override
    public void onSocketClosed() {

    }
}

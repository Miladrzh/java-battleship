package ir.aut.logic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Milad on 7/5/2017.
 */
public class ServerSocketHandler extends Thread {

    private ServerSocket serverSocket;
    private INetworkHandlerCallback iNetworkHandlerCallback;
    private IServerSocketHandlerCallback iServerSocketHandlerCallback;

    ServerSocketHandler(int port, INetworkHandlerCallback iNetworkHandlerCallback, IServerSocketHandlerCallback iServerSocketHandlerCallback) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.iNetworkHandlerCallback = iNetworkHandlerCallback;
        this.iServerSocketHandlerCallback = iServerSocketHandlerCallback;
    }


    /**
     * While server socket is connected and stop is not called:
     * if a connection receives, then create a network handler and pass it through onNewConnectionReceived
     * else sleep for 100 ms.
     */
    @Override
    public void run() {
        while (!serverSocket.isClosed()) {
            try {
                Socket jadid = serverSocket.accept();
                iServerSocketHandlerCallback.onNewConnectionReceived(new NetworkHandler(jadid, iNetworkHandlerCallback));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Kill the thread and close the server socket.
     */
    public void stopSelf() {
        //todo: what is this ?
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.interrupt();
    }

}

package ir.aut.logic;

import ir.aut.logic.messages.*;

import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Milad on 7/5/2017.
 */
public class NetworkHandler extends Thread {
    String id;
    private TcpChannel mTcpChannel;
    private Queue<byte[]> mSendQueue;
    private Queue<byte[]> mReceivedQueue;
    private ReceivedMessageConsumer mConsumerThread;
    INetworkHandlerCallback iNetworkHandlerCallback;

    public NetworkHandler(SocketAddress socketAddress, INetworkHandlerCallback iNetworkHandlerCallback) {

        mTcpChannel = new TcpChannel(socketAddress, 100);
        this.iNetworkHandlerCallback = iNetworkHandlerCallback;
        mSendQueue = new LinkedList<>();
        mReceivedQueue = new LinkedList<>();
        mConsumerThread = new ReceivedMessageConsumer();
        id = mTcpChannel.mSocket.getInetAddress().toString();
    }

    public NetworkHandler(Socket socket, INetworkHandlerCallback iNetworkHandlerCallback) {
        mTcpChannel = new TcpChannel(socket, 100);
        this.iNetworkHandlerCallback = iNetworkHandlerCallback;
        mSendQueue = new LinkedList<>();
        mReceivedQueue = new LinkedList<>();
        mConsumerThread = new ReceivedMessageConsumer();
        id = mTcpChannel.mSocket.getInetAddress().toString();
    }

    /**
     * Add serialized bytes of message to the sendQueue.
     */
    public void sendMessage(BaseMessage baseMessage) {
        mSendQueue.add(baseMessage.getSerialized());
    }

    /**
     * While channel is connected and stop is not called:
     * if sendQueue is not empty, then poll a message and send it
     * else if readChannel() is returning bytes, then add it to receivedQueue.
     */
    public void run() {
        byte[] x = new byte[0];
        try {
            x = this.readChannel();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        if (mTcpChannel.isConnected() && !mSendQueue.isEmpty()) {
            mTcpChannel.write(mSendQueue.remove());
        } else if (x != null) {
            mReceivedQueue.add(x);
        }
    }

    /**
     * Kill the thread and close the channel.
     */
    public void stopSelf() {
        this.interrupt();
    }

    /**
     * Try to read some bytes from the channel.
     */
    private byte[] readChannel() throws Throwable {
        byte[] messageBytes = mTcpChannel.read(4);
        ByteBuffer messageBytesBuffer = ByteBuffer.wrap(messageBytes);
        int length = messageBytesBuffer.getInt();
        messageBytesBuffer.put(mTcpChannel.read(length - 4));
        return messageBytesBuffer.array();
    }

    private class ReceivedMessageConsumer extends Thread {

        /**
         * While channel is connected and stop is not called:
         * if there exists message in receivedQueue, then create a message object
         * from appropriate class based on message type byte and pass it through onMessageReceived
         * else if receivedQueue is empty, then sleep 100 ms.
         */
        @Override
        public void run() {
            if (mTcpChannel.isConnected() && NetworkHandler.this.isAlive()) {
                if (!mReceivedQueue.isEmpty()) {
                    byte[] message = mReceivedQueue.remove();
                    switch (message[5]) {
                        case 1: {
                            iNetworkHandlerCallback.onMessageReceived(new RequestGameMessage(message));
                            break;
                        }
                        case 2: {
                            iNetworkHandlerCallback.onMessageReceived(new ChatMessage(message));
                            break;
                        }
                        case 3: {
                            iNetworkHandlerCallback.onMessageReceived(new HitMessage(message));
                            break;
                        }
                        case 4: {
                            iNetworkHandlerCallback.onMessageReceived(new FeedbackMessage(message));
                            break;
                        }
                        default: {
                            System.out.println("tu network handler run consumer ridim!");
                        }
                    }
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
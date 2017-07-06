package ir.aut.logic;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

/**
 * Created by Milad on 7/4/2017.
 */

public class TcpChannel {
    public Socket mSocket;
    private ObjectOutputStream mOutputStream;
    private ObjectInputStream mInputStream;

    public TcpChannel(SocketAddress socketAddress, int timeout) {
        mSocket = new Socket();
        try {
            mSocket.connect(socketAddress, timeout);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            mInputStream = new ObjectInputStream(mSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mOutputStream = new ObjectOutputStream(mSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TcpChannel(Socket socket, int timeout) {
        mSocket = socket;

        try {
            socket.setSoTimeout(timeout);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        try {
            if(mSocket.isConnected())
                mInputStream = new ObjectInputStream(mSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mOutputStream = new ObjectOutputStream(mSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Try to read specific count from input stream.
     */
    public byte[] read(final int count) {
        byte[] x = new byte[count];
        for (int i = 0; i < count; i++) {
            try {
                x[i] = mInputStream.readByte();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return x;
    }

    /**
     * Write bytes on output stream.
     */
    public void write(byte[] data) {
        try {
            mOutputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Check socket’s connectivity.
     */
    public boolean isConnected() {
        return mSocket.isConnected();
    }

    /**
     * Try to close socket and input-output streams.
     */
    public void closeChannel() {
        try {
            mInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

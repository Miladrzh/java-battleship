package ir.aut.logic;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;

/**
 * Created by Milad on 7/4/2017.
 */

public class TcpChannel {
    public Socket mSocket;
    private OutputStream mOutputStream;
    private InputStream mInputStream;

    public TcpChannel(SocketAddress socketAddress, int timeout) {
        mSocket = new Socket();
        try {
            mSocket.connect(socketAddress, timeout);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mSocket.setSoTimeout(timeout);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        try {
            mInputStream = mSocket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mOutputStream = mSocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TcpChannel(Socket socket, int timeout) {
        mSocket = socket;

        try {
            socket.setSoTimeout(timeout);
            System.out.println("timeoutset");
        } catch (SocketException e) {
            e.printStackTrace();
        }

        try {
            if(mSocket.isConnected()) {
                System.out.println("Input stream get");
                mInputStream = mSocket.getInputStream();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mOutputStream = mSocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Try to read specific count from input stream.
     */
    public byte[] read(final int count) {
        byte[] x = new byte[count];
        try {
            mInputStream.read(x);
        } catch (SocketTimeoutException ste){

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return x;
    }

    /**
     * Write bytes on output stream.
     */
    public void write(byte[] data) {
        try {
            System.out.println("message namusan write shod");
            mOutputStream.write(data);
            mOutputStream.flush();
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

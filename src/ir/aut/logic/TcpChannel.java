package ir.aut.logic;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;

/**
 * Created by Milad on 7/4/2017.
 */

public class TcpChannel {
    Socket mSocket;
    private OutputStream mOutputStream;
    private InputStream mInputStream;

    TcpChannel(SocketAddress socketAddress, int timeout) {
        mSocket = new Socket();
        try {
            mSocket.connect(socketAddress, timeout);
        } catch (IOException e) {
            
        }
        try {
            mSocket.setSoTimeout(timeout);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        try {
            mInputStream = mSocket.getInputStream();
        } catch (IOException e) {

        }
        try {
            mOutputStream = mSocket.getOutputStream();
        } catch (IOException e) {

        }
    }

    TcpChannel(Socket socket, int timeout) {
        mSocket = socket;
        System.out.println(socket.getInetAddress());
        try {
            socket.setSoTimeout(timeout);
        } catch (SocketException e) {

        }

        try {
            if (mSocket.isConnected()) {
                mInputStream = mSocket.getInputStream();
            }
        } catch (IOException e) {

        }
        try {
            mOutputStream = mSocket.getOutputStream();
        } catch (IOException e) {
        }
    }

    /**
     * Try to read specific count from input stream.
     */
    byte[] read(final int count) {
        byte[] x = new byte[count];
        try {
            mInputStream.read(x);
        } catch (SocketTimeoutException ignored) {

        } catch (IOException e) {

        }
        return x;
    }

    /**
     * Write bytes on output stream.
     */
    void write(byte[] data) {
        try {
            mOutputStream.write(data);
            mOutputStream.flush();
        } catch (IOException e) {

        }
    }


    /**
     * Check socket’s connectivity.
     */
    boolean isConnected() {
        return mSocket.isConnected();
    }

    /**
     * Try to close socket and input-output streams.
     */
    public void closeChannel() {
        try {
            mInputStream.close();
            mSocket.close();
            mOutputStream.close();
        } catch (IOException e) {
        }
    }
}

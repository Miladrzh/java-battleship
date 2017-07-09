package ir.aut.logic.messages;

import java.nio.ByteBuffer;

/**
 * Created by Milad on 7/10/2017.
 */
public class ConnectionLostMessage extends BaseMessage {
    private byte iAmServer;

    public ConnectionLostMessage(byte iAmServer) {
        this.iAmServer = iAmServer;
        serialize();
    }

    public ConnectionLostMessage(byte[] bytes) {
        mSerialized = bytes;
        deserialize();
    }

    @Override
    protected void serialize() {
        int messageLength = 4 + 1 + 1 + 1;
        ByteBuffer byteBuffer = ByteBuffer.allocate(messageLength);
        byteBuffer.putInt(messageLength);
        byteBuffer.put(MessageTypes.PROTOCOL_VERSION);
        byteBuffer.put(MessageTypes.CONNECTION_LOST);
        byteBuffer.put(iAmServer);
        mSerialized = byteBuffer.array();
    }

    @Override
    protected void deserialize() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(mSerialized);
        int messageLength = byteBuffer.getInt();
        byte protocolVersion = byteBuffer.get();
        byte messageType = byteBuffer.get();
        iAmServer = byteBuffer.get();
    }

    @Override
    public byte getMessageType() {
        return MessageTypes.CONNECTION_LOST;
    }
}

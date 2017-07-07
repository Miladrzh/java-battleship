package ir.aut.logic.messages;

import java.nio.ByteBuffer;

/**
 * Created by Milad on 7/4/2017.
 */
public class HitMessage extends BaseMessage {
    private int xCor, yCor;

    public HitMessage(int xCore, int yCore) {
        this.xCor = xCore;
        this.yCor = yCore;
        serialize();
    }


    public HitMessage(byte[] b) {
        mSerialized = b;
        deserialize();
    }

    public int getxCor() {
        return xCor;
    }

    public int getyCor() {
        return yCor;
    }

    @Override
    protected void serialize() {
        int messageLength = 4 + 1 + 1 + 4 + 4;
        ByteBuffer byteBuffer = ByteBuffer.allocate(messageLength);
        byteBuffer.putInt(messageLength);
        byteBuffer.put(MessageTypes.PROTOCOL_VERSION);
        byteBuffer.put(MessageTypes.HIT);
        byteBuffer.putInt(xCor);
        byteBuffer.putInt(yCor);
        mSerialized = byteBuffer.array();
    }

    @Override
    protected void deserialize() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(mSerialized);
        int messageLength = byteBuffer.getInt();
        byte protocolVersion = byteBuffer.get();
        byte messageType = byteBuffer.get();
        xCor = byteBuffer.getInt();
        yCor = byteBuffer.getInt();
    }

    @Override
    public byte getMessageType() {
        return MessageTypes.HIT;
    }
}
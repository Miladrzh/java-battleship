package ir.aut.logic.messages;

import java.nio.ByteBuffer;

/**
 * Created by Milad on 7/4/2017.
 */
public class HitMessage extends BaseMessage {
    int xCore, yCore;

    public HitMessage(int xCore, int yCore) {
        this.xCore = xCore;
        this.yCore = yCore;
    }

    @Override
    protected void serialize() {
        int messageLength = 4 + 1 + 1 + 4 + 4;
        ByteBuffer byteBuffer = ByteBuffer.allocate(messageLength);
        byteBuffer.putInt(messageLength);
        byteBuffer.put(MessageTypes.PROTOCOL_VERSION);
        byteBuffer.put(MessageTypes.HIT);
        byteBuffer.putInt(xCore);
        byteBuffer.putInt(yCore);
        mSerialized = byteBuffer.array();
    }

    @Override
    protected void deserialize() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(mSerialized);
        int messageLength = byteBuffer.getInt();
        byte protocolVersion = byteBuffer.get();
        byte messageType = byteBuffer.get();
        xCore = byteBuffer.getInt();
        yCore = byteBuffer.getInt();
    }

    @Override
    public byte getMessageType() {
        return MessageTypes.HIT;
    }
}
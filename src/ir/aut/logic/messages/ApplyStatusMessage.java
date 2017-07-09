package ir.aut.logic.messages;

import java.nio.ByteBuffer;

/**
 * Created by Milad on 7/5/2017.
 */
public class ApplyStatusMessage extends BaseMessage {
    public byte status;

    public ApplyStatusMessage(byte status) {
        this.status = status;
        serialize();
    }

    public ApplyStatusMessage(byte[] bytes) {
        mSerialized = bytes;
        deserialize();
    }

    @Override
    protected void serialize() {
        int messageLength = 4 + 1 + 1 + 1;
        ByteBuffer byteBuffer = ByteBuffer.allocate(messageLength);
        byteBuffer.putInt(messageLength);
        byteBuffer.put(MessageTypes.PROTOCOL_VERSION);
        byteBuffer.put(MessageTypes.APPLY_STATUS);
        byteBuffer.put(status);
        mSerialized = byteBuffer.array();
    }

    @Override
    protected void deserialize() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(mSerialized);
        int messageLength = byteBuffer.getInt();
        byte protocol = byteBuffer.get();
        byte messageType = byteBuffer.get();
        status = byteBuffer.get();
    }

    @Override
    public byte getMessageType() {
        return MessageTypes.APPLY_STATUS;
    }
}

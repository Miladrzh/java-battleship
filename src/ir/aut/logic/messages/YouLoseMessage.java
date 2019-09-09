package ir.aut.logic.messages;

import java.nio.ByteBuffer;

/**
 * Created by Milad on 7/7/2017.
 */
public class YouLoseMessage extends BaseMessage {
    public YouLoseMessage() {
        serialize();
    }

    public YouLoseMessage(byte[] bytes) {
        mSerialized = bytes;
        deserialize();
    }

    @Override

    protected void serialize() {
        int messageLength = 4 + 1 + 1;
        ByteBuffer byteBuffer = ByteBuffer.allocate(messageLength);
        byteBuffer.putInt(messageLength);
        byteBuffer.put(MessageTypes.PROTOCOL_VERSION);
        byteBuffer.put(MessageTypes.READY);
        mSerialized = byteBuffer.array();
    }

    @Override
    protected void deserialize() {

    }


    @Override
    public byte getMessageType() {
        return MessageTypes.YOU_LOSE;
    }
}

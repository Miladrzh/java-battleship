package ir.aut.logic.messages;

import java.nio.ByteBuffer;

/**
 * Created by Milad on 7/4/2017.
 */
public class FeedbackMessage extends BaseMessage{
    public int xCor;
    public int yCor;
    public int status;

    public FeedbackMessage(int xCor, int yCor, int status) {
        this.xCor = xCor;
        this.yCor = yCor;
        this.status = status;
        serialize();
    }

    public FeedbackMessage(byte[] b){
        mSerialized = b;
        deserialize();
    }

    @Override
    protected void serialize() {
        int messageLength = 4 + 1 + 1 + 4 + 4 + 4;
        ByteBuffer byteBuffer = ByteBuffer.allocate(messageLength);
        byteBuffer.putInt(messageLength);
        byteBuffer.put(MessageTypes.PROTOCOL_VERSION);
        byteBuffer.put(MessageTypes.FEEDBACK);
        byteBuffer.putInt(status);
        byteBuffer.putInt(xCor);
        byteBuffer.putInt(yCor);
        mSerialized = byteBuffer.array();
    }

    @Override
    protected void deserialize() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(mSerialized);
        int messageLength = byteBuffer.getInt();

        byte protocol = byteBuffer.get();
        byte messageType = byteBuffer.get();
        status = byteBuffer.getInt();
        xCor = byteBuffer.getInt();
        yCor = byteBuffer.getInt();
    }

    @Override
    public byte getMessageType() {
        return (byte)4;
    }
}

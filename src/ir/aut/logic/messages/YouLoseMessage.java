package ir.aut.logic.messages;

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

    }

    @Override
    protected void deserialize() {

    }

    @Override
    public byte getMessageType() {
        return MessageTypes.YOU_LOSE;
    }
}

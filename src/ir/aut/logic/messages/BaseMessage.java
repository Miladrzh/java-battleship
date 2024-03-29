package ir.aut.logic.messages;

/**
 * Created by Milad on 7/4/2017.
 */
public abstract class BaseMessage {
    protected byte[] mSerialized;

    /**
     * Fields are stored into serial bytes in this method.
     */
    protected abstract void serialize();

    /**
     * Fields are restored from serial bytes in this method.
     */
    protected abstract void deserialize();

    /**
     * Return message type code.
     */
    public abstract byte getMessageType();

    public byte[] getSerialized() {
        return mSerialized;
    }
}

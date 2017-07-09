package ir.aut.logic.messages;

/**
 * Created by Milad on 7/10/2017.
 */
public class ConnectionLostMessage extends  BaseMessage {

    @Override
    protected void serialize() {

    }

    @Override
    protected void deserialize() {

    }

    @Override
    public byte getMessageType() {
        return 0;
    }
}

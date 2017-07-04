package ir.aut.logic.messages;

import ir.aut.logic.messages.BaseMessage;

/**
 * Created by Milad on 7/4/2017.
 */
public class RequestGameMessage extends BaseMessage {

    public String ip;
    public String name;

    public RequestGameMessage(String ip, String name) {
        this.ip = ip;
        this.name = name;
        serialize();
    }

    public RequestGameMessage(byte[] b){
        mSerialized = b;
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
        return (byte)1;
    }


}

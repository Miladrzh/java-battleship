package ir.aut.logic.messages;

import ir.aut.logic.messages.BaseMessage;

import java.nio.ByteBuffer;

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

    public RequestGameMessage(byte[] b) {
        mSerialized = b;
        deserialize();
    }

    @Override
    protected void serialize() {
        int ipLength = ip.getBytes().length;
        int nameLength = name.getBytes().length;
        int messageLength = 4 + 1 + 1 + 4 + ipLength + 4 + nameLength;

        ByteBuffer byteBuffer = ByteBuffer.allocate(messageLength);
        byteBuffer.putInt(messageLength);
        byteBuffer.put(MessageTypes.PROTOCOL_VERSION);
        byteBuffer.put(MessageTypes.REQUEST_GAME);
        byteBuffer.putInt(ipLength);
        byteBuffer.put(ip.getBytes());
        byteBuffer.putInt(nameLength);
        byteBuffer.put(name.getBytes());
        mSerialized = byteBuffer.array();
    }

    @Override
    protected void deserialize() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(mSerialized);
        int messageLength = byteBuffer.getInt();
        byte protocolVersion = byteBuffer.get();
        byte messageType = byteBuffer.get();

        int ipLength = byteBuffer.getInt();
        byte[] ipByte = new byte[ipLength];
        byteBuffer.get(ipByte);
        ip = new String(ipByte);

        int nameLength = byteBuffer.getInt();
        byte[] nameBytes = new byte[nameLength];
        byteBuffer.get(nameBytes);
        name = new String(nameBytes);
    }

    @Override
    public byte getMessageType() {
        return (byte) 1;
    }
}

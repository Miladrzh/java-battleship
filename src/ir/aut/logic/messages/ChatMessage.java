package ir.aut.logic.messages;

import java.nio.ByteBuffer;

/**
 * Created by Milad on 7/4/2017.
 */
public class ChatMessage extends BaseMessage {
    String name;
    String textMessage;

    public ChatMessage(String name, String messageText) {
        this.name = name;
        this.textMessage = messageText;
        serialize();
    }

    public ChatMessage(byte[] b) {
        mSerialized = b;
        deserialize();
    }

    @Override
    protected void serialize() {
        int nameLength = name.getBytes().length;
        int messageTextLength = textMessage.getBytes().length;
        int messageLength = 4 + 1 + 1 + 4 + nameLength + 4 + messageTextLength;
        ByteBuffer byteBuffer = ByteBuffer.allocate(messageLength);
        byteBuffer.putInt(messageLength);
        byteBuffer.put(MessageTypes.PROTOCOL_VERSION);
        byteBuffer.put(MessageTypes.CHAT);
        byteBuffer.putInt(nameLength);
        byteBuffer.put(name.getBytes());
        byteBuffer.putInt(messageTextLength);
        byteBuffer.put(textMessage.getBytes());
        mSerialized = byteBuffer.array();
    }

    @Override
    protected void deserialize() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(mSerialized);
        int messageLength = byteBuffer.getInt();
        byte protocolVersion = byteBuffer.get();
        byte messageType = byteBuffer.get();
        int nameLength = byteBuffer.getInt();
        byte[] nameBytes = new byte[nameLength];
        byteBuffer.get(nameBytes);
        name = new String(nameBytes);
        int textMessageLength = byteBuffer.getInt();
        byte[] textMessageBytes = new byte[textMessageLength];
        byteBuffer.get(textMessageBytes);
        textMessage = new String(textMessageBytes);
    }

    @Override
    public byte getMessageType() {
        return MessageTypes.CHAT;
    }
}
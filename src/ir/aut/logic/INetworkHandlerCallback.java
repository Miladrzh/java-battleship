package ir.aut.logic;

import ir.aut.logic.messages.BaseMessage;

/**
 * Created by Milad on 7/5/2017.
 */
public interface INetworkHandlerCallback {
    public abstract void onMessageReceived(BaseMessage baseMessage);

    public abstract void onSocketClosed();
}

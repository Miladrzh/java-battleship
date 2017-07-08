package ir.aut.game;

import ir.aut.logic.messages.ChatMessage;

/**
 * Created by Milad on 7/5/2017.
 */
public interface GameFrameCallBack {
    void sendReady();

    void sendMessage(ChatMessage chatMessage);
}

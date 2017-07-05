package ir.aut.game;

import ir.aut.logic.MessageManager;
import ir.aut.logic.messages.MessageTypes;

/**
 * Created by Milad on 7/5/2017.
 */
public interface ModeFrameCallback {
    void setMessageManager(MessageManager messageManager);
    void closeModeFrame();
    void startWaitForConnectionFrame();
    void startPleaseWaitFrame();
    void setNameOfPlayer(String x);
}
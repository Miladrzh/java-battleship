package ir.aut.game;

import ir.aut.logic.MessageManager;

/**
 * Created by Milad on 7/5/2017.
 */
public interface ModeFrameCallback {
    void setMessageManager(MessageManager messageManager);

    void closeModeFrame();

    void startWaitForConnectionFrame();

    void startPleaseWaitFrame();

    void setMyName(String name);

    void setEnemyName(String name);

    void setMyIP(String ip);

    void setEnemyIp(String ip);

    void sendRequest(String ip, String name);
//    void setHostIP(String ip);
}

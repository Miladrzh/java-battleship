package ir.aut.game;

import ir.aut.logic.messages.ApplyStatusMessage;

/**
 * Created by Milad on 7/5/2017.
 */
public interface WaitForConnectionCallBack {
    void hostResponse(String ip, ApplyStatusMessage applyStatusMessage);
    void setEnemyName(String name);
    void setEnemyIp(String ip);
}

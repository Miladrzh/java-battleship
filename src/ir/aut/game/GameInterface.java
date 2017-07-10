package ir.aut.game;

import ir.aut.logic.messages.ChatMessage;

/**
 * Created by Milad on 7/5/2017.
 */
public interface GameInterface {
    void start ();

    void applyAccepted();

    void applyRejected();

    void addRequest(String ip, String name);

    void hitResponse(int i, int j);

    void attackFeedback(int i, int j, boolean isShip);

    void ready();

    void youLose();

    void addChatMessage(ChatMessage chatMessage);

    void setEnemyName(String name);

    void meStart();

    void enemyStart();

    void connectionLostEffect(boolean opponentIsServer);

}

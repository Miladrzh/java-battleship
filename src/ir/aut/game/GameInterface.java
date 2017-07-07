package ir.aut.game;

/**
 * Created by Milad on 7/5/2017.
 */
public interface GameInterface {
    void applyAccepted();

    void applyRejected();

    void addRequest(String ip, String name);

    void hit(int i, int j);

    void attackFeedback(int i, int j, boolean isShip);
}

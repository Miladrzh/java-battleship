import ir.aut.game.Game;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Milad on 6/14/2017.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
        try {
            System.out.println(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

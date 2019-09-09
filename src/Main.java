import ir.aut.game.Game;

import java.net.InetAddress;

/**
 * Created by Milad on 6/14/2017.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
        System.out.println();

        System.out.println(InetAddress.getLoopbackAddress());
    }
}

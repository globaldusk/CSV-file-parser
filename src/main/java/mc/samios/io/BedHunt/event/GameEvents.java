package mc.samios.io.BedHunt.event;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class GameEvents implements Listener {

    public static boolean gameStarted = false;

    public static void startGame() {
        // Players are moved into the game.
        // Cube is also created in the centre of world border.

    }

    public static void stopGame() {
        // Stops game, restarts server and moves players back to Lobby.
    }

    public static void restartGame() {
        // /game restart command
        // essentially stops game and moves players back into lobby, then immediately into new world.
        // just stopping and starting game.
    }


}

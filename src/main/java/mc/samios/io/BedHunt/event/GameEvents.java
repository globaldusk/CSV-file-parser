package mc.samios.io.BedHunt.event;

import mc.samios.io.BedHunt.team.PickTeams;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import java.util.List;

public class GameEvents implements Listener {

    public static boolean gameStarted = false;

    public static void startGame() {
        // Here we move the players from lobby
        sortTeams();


    }

    public static void forceStartGame() {
        // /game start command
        // doesn't rely on players
        sortTeams();
    }

    public static void stopGame() {

    }

    public static void forceStopGame() {

    }

    public static void restartGame() {
        // /game restart command
        // essentially stops game and moves players back into lobby, then immediately into new world.
        // just stopping and starting game.
    }

    public static void sortTeams() {
        // here we sort the teams
        // we take see how many players are in the lobby and divide it by 2 for the team number.
        int players = Bukkit.getOnlinePlayers().size();
        int teams = players/2;
        PickTeams.pick(teams);
        System.out.println(teams);
    }


}

package mc.samios.io.BedHunt.event;

import mc.samios.io.BedHunt.Main;
import mc.samios.io.BedHunt.util.C;
import mc.samios.io.BedHunt.util.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.*;

public class JoinQuitEvent implements Listener {

    FileManager fm;
    public static int players;
    public static boolean waiting = false;

    public JoinQuitEvent() {
        this.fm = FileManager.getInstance();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        e.setJoinMessage(C.prefix("Join", player.getDisplayName()));
        // add 1 player to players int to check when limit is reached (10);
        players++;
        Bukkit.getConsoleSender().sendMessage("Players: " + players);
        if (!waiting) {
            if (players >= 1) {
                Bukkit.broadcastMessage(C.prefix("Bed Hunt", "Minimum players have been met. Game will start in 30 seconds."));
                waiting = true;
                checkPlayers();
            } else {
                // do nothing.
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(C.error("Quit", player.getDisplayName()));
        players--;
        Bukkit.getConsoleSender().sendMessage("Players: " + players);
        if (players < 2) {
            waiting = false;
            checkPlayers();
        }
    }

    public static void checkPlayers() {
        if (waiting = true) {
            // 30 seconds until game begins.
            Main.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                        public void run() {
                            if (players < 2) {
                                JoinQuitEvent.waiting = false;
                                checkPlayers();
                            } else {
                                GameEvents.gameStarted = true;
                                GameEvents.startGame();
                            }
                        }
                    }
                    , 20 * 30);
        } else if (waiting = false) {
            Bukkit.broadcastMessage(C.error("Bed Hunt", "Not enough players. Required players to start: " + C.green + (2 - Bukkit.getOnlinePlayers().size())));
        }
    }


}


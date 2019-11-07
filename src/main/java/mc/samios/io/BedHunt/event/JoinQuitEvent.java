package mc.samios.io.BedHunt.event;

import mc.samios.io.BedHunt.Main;
import mc.samios.io.BedHunt.team.PickTeams;
import mc.samios.io.BedHunt.util.C;
import mc.samios.io.BedHunt.util.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.util.UUID;

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
                startCounter();
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
        }
    }
    public static int count = 30;

    public void startCounter() {
        if (players >= 1) {
            //Bukkit.broadcastMessage("Game starting in " + count + " seconds..");
            new BukkitRunnable() {

                @Override
                public void run() {
                    if (players < 1) {
                        Bukkit.broadcastMessage(C.error("Bed Hunt", "Not enough players. Required players to start: " + C.green + (2 - Bukkit.getOnlinePlayers().size())));
                        waiting = false;
                        cancel(); // Cancels timer
                        count = 30; // Resets timer
                    }
                    else if (count == 0) {
                        // Start game method
                        GameEvents.startGame();
                        cancel(); // Cancels timer
                        count = 30; // Resets timer
                        Bukkit.getServer().getScheduler().cancelTasks(Main.getInstance());
                    } else {
                        count--;
                        if (count<=10) {
                            Bukkit.broadcastMessage(C.green + C.bold + "Game starting in " + count + " seconds..");
                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                pl.playSound(pl.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 5, 2);
                            }
                        }
                        if (count<=5) {
                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                pl.sendTitle(C.red + count, C.yellow + "Good luck!");
                            }
                        }
                    }
                }
            }.runTaskTimer(Bukkit.getServer().getPluginManager().getPlugin("BedHunt"), 20L, 20L);
        } else {
            // do nothing.
        }

    }


}


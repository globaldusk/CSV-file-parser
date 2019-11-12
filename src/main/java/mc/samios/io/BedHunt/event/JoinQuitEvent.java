package mc.samios.io.BedHunt.event;

import mc.samios.io.BedHunt.util.C;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinQuitEvent implements Listener {

    public static int players;
    public static boolean waiting = false;

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        e.setJoinMessage(C.prefix("Join", player.getDisplayName()));
        // get sql player data incl team
        Bukkit.getConsoleSender().sendMessage("Players: " + players);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        // remove player from team. Once they leave they are eliminated. (even in pre-game)
        e.setQuitMessage(C.error("Quit", player.getDisplayName()));
        Bukkit.broadcastMessage(C.error("Elimination", e.getPlayer().getName() + " has been eliminated!"));
    }
    public static int count = 30;
    public int stop;

    public void startCounter() {
        // needs work
        if (players >= 1) {
            new BukkitRunnable() {

                @Override
                public void run() {
                    if (players < 1) {
                        Bukkit.broadcastMessage(C.error("Bed Hunt", "Not enough players. Required players to start: " + C.green + (2 - Bukkit.getOnlinePlayers().size())));
                        waiting = false;
                        this.cancel(); // Cancels timer
                        count = 30; // Resets timer
                    }
                    else if (count == 0) {
                        // Start game method
                        GameEvents.startGame();
                        this.cancel(); // Cancels timer
                        count = 30; // Resets timer
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


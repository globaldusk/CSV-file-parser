package mc.samios.io.BedHunt.team;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Scoreboard implements Listener {

    int remaining = 6 - Bukkit.getOnlinePlayers().size();

    // Waiting lobby scoreboard
    private void createLobbyScoreboard(Player player) {
        ScoreHelper helper = ScoreHelper.createScore(player);
        helper.setTitle("&b&lBed Hunt");
        helper.setSlot(8, "&7&m--------------------------------");
        helper.setSlot(7, "&eStatus: &fWaiting....");
        helper.setSlot(6, "&b" + remaining + "&e more players until start");
        helper.setSlot(5, "&ePlayers: &a" + Bukkit.getOnlinePlayers().size() + "&f/10");
        helper.setSlot(4, " ");
        helper.setSlot(3, "&eFor information type &b/info");
        helper.setSlot(2, "&eBedHunt v0.1");
        helper.setSlot(1, "&7&m--------------------------------");
    }

    // Update lobby scoreboard
    public static void updateLobbyScoreboard(Player player) {
        int remaining = 6 - Bukkit.getOnlinePlayers().size();
        if(ScoreHelper.hasScore(player)) {
            ScoreHelper helper = ScoreHelper.getByPlayer(player);
            int players = Bukkit.getOnlinePlayers().size();
            helper.setSlot(6, "&b" + remaining + "&e more players until start");
            helper.setSlot(5, "&ePlayers: &a" + players + "&f/10");
        }
    }

    private void createScoreboard(Player player) {
        ScoreHelper helper = ScoreHelper.createScore(player);
        helper.setTitle("&a&lBed Hunt");
    }

    private static String getLocation(Player player) {
        Location l = player.getLocation();
        return l.getBlockX() + ", " + l.getBlockY() + ", " + l.getBlockZ();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        // make an if statement to see if player is joining after game has started, or is waiting.
        createLobbyScoreboard(player);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if(ScoreHelper.hasScore(player)) {
            ScoreHelper.removeScore(player);
        }
    }

}

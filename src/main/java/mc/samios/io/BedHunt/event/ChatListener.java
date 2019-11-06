package mc.samios.io.BedHunt.event;

import mc.samios.io.BedHunt.Main;
import mc.samios.io.BedHunt.team.TeamPlayer;
import mc.samios.io.BedHunt.util.C;
import mc.samios.io.BedHunt.util.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.UUID;

public class ChatListener implements Listener {

    FileManager fm;
    private Main plugin;
    public static boolean TeamChat = true;

    public ChatListener(final Main instance) {
        this.fm = FileManager.getInstance();
        this.plugin = instance;
    }

    @EventHandler
    public void onPlayerChat(final PlayerChatEvent e) {
        if (this.fm.getTeams().getString("players." + e.getPlayer().getUniqueId() + ".team") != null) {
            // if player is in a team
            // if player has team chat toggled
            if (TeamChat == true) {
                final String teamname = "players." + e.getPlayer().getUniqueId() + ".team";
                final String team = this.fm.getTeams().getString(teamname);
                e.setCancelled(true);
                for (final String s : this.fm.getTeams().getStringList(String.valueOf(team) + ".memberlist")) {
                    final OfflinePlayer player = this.plugin.getServer().getOfflinePlayer(UUID.fromString(s));
                    if (player.isOnline()) {
                        final Player pl = (Player)player;
                        pl.sendMessage(C.darkAqua + "[TEAM] " + C.yellow + e.getPlayer().getName() + ":§f " + e.getMessage());
                    }
                }
                return;
            } else {
                e.setFormat(String.valueOf(this.getPrefix().replaceAll("%team%", this.fm.getTeams().getString(new StringBuilder("players.").append(e.getPlayer().getUniqueId()).append(".team").toString()))) + "§f" + e.getFormat());
            }
        }
    }

    public String getPrefix() {
        return this.fm.getConfig().getString("team-prefix").replaceAll("&", "§");
    }
}

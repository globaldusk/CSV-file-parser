package mc.samios.io.BedHunt.team;

import mc.samios.io.BedHunt.util.FileManager;
import org.bukkit.Bukkit;

import java.util.UUID;

public class TeamPlayer {

    private UUID uuid;
    private FileManager fm;

    public TeamPlayer(final String name) {
        this.fm = FileManager.getInstance();
        if (this.fm.getTeams().get("players." + Bukkit.getOfflinePlayer(name).getUniqueId()) == null) {
            return;
        }
        this.uuid = Bukkit.getOfflinePlayer(name).getUniqueId();
    }

    public Team getTeam() {
        return new Team(this.fm.getTeams().getString("players." + this.uuid + ".team"));
    }

    public boolean isTeamChatting() {
        return this.fm.getTeams().getString("players." + this.uuid + ".teamchat").equalsIgnoreCase("true");
    }
}

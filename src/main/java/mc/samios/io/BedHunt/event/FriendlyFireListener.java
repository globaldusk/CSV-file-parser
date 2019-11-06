package mc.samios.io.BedHunt.event;

import mc.samios.io.BedHunt.util.FileManager;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class FriendlyFireListener implements Listener {
    FileManager fm;

    public FriendlyFireListener() {
        this.fm = FileManager.getInstance();
    }

    @EventHandler
    public void onPlayerHit(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            if (e.getDamager() instanceof Player) {
                final Player d = (Player)e.getDamager();
                final String team = this.fm.getTeams().getString("players." + p.getUniqueId() + ".team");
                if (team == null) {
                    return;
                }
                final String dteam = this.fm.getTeams().getString("players." + d.getUniqueId() + ".team");
                if (dteam == null) {
                    return;
                }
                if (team.equals(dteam) && this.fm.getTeams().getString(String.valueOf(team) + ".ff").equalsIgnoreCase("false")) {
                    e.setCancelled(true);
                }
            }
            if (e.getDamager() instanceof Arrow) {
                final Projectile pr = (Projectile)e.getDamager();
                if (!(pr.getShooter() instanceof Player)) {
                    return;
                }
                final Player d2 = (Player)pr.getShooter();
                final String team2 = this.fm.getTeams().getString("players." + p.getUniqueId() + ".team");
                if (team2 == null) {
                    return;
                }
                final String dteam2 = this.fm.getTeams().getString("players." + d2.getUniqueId() + ".team");
                if (dteam2 == null) {
                    return;
                }
                if (team2.equals(dteam2) && this.fm.getTeams().getString(String.valueOf(team2) + ".ff").equalsIgnoreCase("false")) {
                    e.setCancelled(true);
                }
            }
        }
    }
}

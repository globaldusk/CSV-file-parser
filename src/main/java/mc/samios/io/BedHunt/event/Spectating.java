package mc.samios.io.BedHunt.event;

import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerRespawnEvent;


public class Spectating implements Listener {
    @EventHandler
    public void Spectate(PlayerRespawnEvent e) {
        Player player = e.getPlayer();
        player.setGameMode(GameMode.SPECTATOR);
        Player killer = player.getKiller();
        player.setSpectatorTarget(killer);
    }

    public void spectate2(PlayerInteractEntityEvent e){
        Player player = e.getPlayer();
        if (player.getGameMode() == GameMode.SPECTATOR){
            e.setCancelled(true);
        }
    }

}

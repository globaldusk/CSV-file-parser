package mc.samios.io.BedHunt.event;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PlayerCannotDropBeds implements Listener {
        @EventHandler
        public void PickupItem(PlayerPickupItemEvent e) {
            Player player = e.getPlayer();
            Item item = e.getItem();
            if (item.getName().contains("_BED")){
                item.remove();
            }
        }
    }

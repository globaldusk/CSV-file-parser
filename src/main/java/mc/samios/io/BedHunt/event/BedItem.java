package mc.samios.io.BedHunt.event;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class BedItem implements Listener{

    @EventHandler
    public void DropItem(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        Item item = e.getItemDrop();
        if (item.getName().contains("_BED")){
            item.remove();
        }
    }

    @Deprecated
    public void PickupItem(PlayerPickupItemEvent e) {
        Player player = e.getPlayer();
        Item item = e.getItem();
        if (item.getName().contains("_BED")){
            item.eject();
        }
    }
}

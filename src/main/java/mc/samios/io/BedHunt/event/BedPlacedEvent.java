package mc.samios.io.BedHunt.event;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BedPlacedEvent implements Listener {
    @EventHandler
    public void place(BlockPlaceEvent e) {
        Block block = e.getBlock();
        Player player = e.getPlayer();
        if (!block.getType().equals(Material.DIAMOND_BLOCK)) {
            player.sendMessage("Hello");
        }

    }
}

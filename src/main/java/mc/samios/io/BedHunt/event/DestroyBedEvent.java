package mc.samios.io.BedHunt.event;

import mc.samios.io.BedHunt.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class DestroyBedEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBedBreak(BlockBreakEvent e) {
        Block g = e.getBlock();
        if (Main.getInstance().checkBed(g)) {
        //if (e.getBlock().getType().equals(Material.BLACK_BED) || e.getBlock().getType().equals(Material.LIME_BED) || e.getBlock().getType().equals(Material.BLUE_BED) || e.getBlock().getType().equals(Material.BROWN_BED) || e.getBlock().getType().equals(Material.CYAN_BED) || e.getBlock().getType().equals(Material.GRAY_BED) || e.getBlock().getType().equals(Material.GREEN_BED) || e.getBlock().getType().equals(Material.LIGHT_BLUE_BED) || e.getBlock().getType().equals(Material.LIGHT_GRAY_BED) || e.getBlock().getType().equals(Material.MAGENTA_BED) || e.getBlock().getType().equals(Material.YELLOW_BED) || e.getBlock().getType().equals(Material.WHITE_BED) || e.getBlock().getType().equals(Material.RED_BED) || e.getBlock().getType().equals(Material.PINK_BED) || e.getBlock().getType().equals(Material.PURPLE_BED) || e.getBlock().getType().equals(Material.ORANGE_BED)) {
            // if team bed, deny.
            e.getPlayer().sendMessage("no");
            // if enemy bed, destroy
        } else {
        }
    }
}

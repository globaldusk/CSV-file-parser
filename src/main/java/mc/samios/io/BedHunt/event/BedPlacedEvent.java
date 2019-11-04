package mc.samios.io.BedHunt.event;

import mc.samios.io.BedHunt.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Bed;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class BedPlacedEvent implements Listener {
    @EventHandler
    public void place(BlockPlaceEvent e) {

        Player player = e.getPlayer();
        Block block = e.getBlock();
        if (Main.getInstance().checkBed(block) == true) {
        //if (block.getType().equals(Material.BLACK_BED) || block.getType().equals(Material.LIME_BED) || block.getType().equals(Material.BLUE_BED) || block.getType().equals(Material.BROWN_BED) || block.getType().equals(Material.CYAN_BED) || block.getType().equals(Material.GRAY_BED) || block.getType().equals(Material.GREEN_BED) || block.getType().equals(Material.LIGHT_BLUE_BED) || block.getType().equals(Material.LIGHT_GRAY_BED) || block.getType().equals(Material.MAGENTA_BED) || block.getType().equals(Material.YELLOW_BED) || block.getType().equals(Material.WHITE_BED) || block.getType().equals(Material.RED_BED) || block.getType().equals(Material.PINK_BED) ||block.getType().equals(Material.PURPLE_BED) ||block.getType().equals(Material.ORANGE_BED)) {
            Location loc1 = e.getBlock().getLocation();
            // here we need to save where the bed is, so it can be destroyed for deathmatch (or modifier where there is no deathmatch, but it reveals location)

            player.setBedSpawnLocation(loc1);
            player.sendMessage("Team spawn set");
        }
    }

    @EventHandler
    public void sleep(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        if (block != null){
            if (Main.getInstance().checkBed(block) == true) {
           // if (block.getType().equals(Material.BLACK_BED) || block.getType().equals(Material.LIME_BED) || block.getType().equals(Material.BLUE_BED) || block.getType().equals(Material.BROWN_BED) || block.getType().equals(Material.CYAN_BED) || block.getType().equals(Material.GRAY_BED) || block.getType().equals(Material.GREEN_BED) || block.getType().equals(Material.LIGHT_BLUE_BED) || block.getType().equals(Material.LIGHT_GRAY_BED) || block.getType().equals(Material.MAGENTA_BED) || block.getType().equals(Material.YELLOW_BED) || block.getType().equals(Material.WHITE_BED) || block.getType().equals(Material.RED_BED) || block.getType().equals(Material.PINK_BED) ||block.getType().equals(Material.PURPLE_BED) ||block.getType().equals(Material.ORANGE_BED)) {
                e.setCancelled(true);
            }
        }
    }

    public void saveLocation(Location bedLocation) {
        // here we get the block of the bed, and destroy it.
        // as it is a bed and has two blocks, we may as well

    }
}
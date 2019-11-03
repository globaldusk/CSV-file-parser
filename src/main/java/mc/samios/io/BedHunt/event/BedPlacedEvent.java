package mc.samios.io.BedHunt.event;

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
        if (block.getType().equals(Material.BLACK_BED)) {
            Location loc1 = e.getBlock().getLocation();
            {
            }
            player.setBedSpawnLocation(loc1);
            player.sendMessage("SPAWN SET TO BLACK BED");
        }
        if (block.getType().equals(Material.LIME_BED)) {
            Location loc1 = e.getBlock().getLocation();
            {
            }
            player.setBedSpawnLocation(loc1);
            player.sendMessage("SPAWN SET TO LIME BED");
        }
        if (block.getType().equals(Material.BLUE_BED)) {
            Location loc1 = e.getBlock().getLocation();
            {
            }
            player.setBedSpawnLocation(loc1);
            player.sendMessage("SPAWN SET TO BLUE BED");
        }
        if (block.getType().equals(Material.BROWN_BED)) {
            Location loc1 = e.getBlock().getLocation();
            {
            }
            player.setBedSpawnLocation(loc1);
            player.sendMessage("SPAWN SET TO BROWN BED");
        }
        if (block.getType().equals(Material.CYAN_BED)) {
            Location loc1 = e.getBlock().getLocation();
            {
            }
            player.setBedSpawnLocation(loc1);
            player.sendMessage("SPAWN SET TO CYAN BED");
        }
        if (block.getType().equals(Material.GRAY_BED)) {
            Location loc1 = e.getBlock().getLocation();
            {
            }
            player.setBedSpawnLocation(loc1);
            player.sendMessage("SPAWN SET TO GRAY BED");
        }
        if (block.getType().equals(Material.GREEN_BED)) {
            Location loc1 = e.getBlock().getLocation();
            {
            }
            player.setBedSpawnLocation(loc1);
            player.sendMessage("SPAWN SET TO GREEN BED");
        }
        if (block.getType().equals(Material.LIGHT_BLUE_BED)) {
            Location loc1 = e.getBlock().getLocation();
            {
            }
            player.setBedSpawnLocation(loc1);
            player.sendMessage("SPAWN SET TO LIGHT BLUE BED");
        }
        if (block.getType().equals(Material.LIGHT_GRAY_BED)) {
            Location loc1 = e.getBlock().getLocation();
            {
            }
            player.setBedSpawnLocation(loc1);
            player.sendMessage("SPAWN SET TO LIGHT GRAY BED");
        }
        if (block.getType().equals(Material.MAGENTA_BED)) {
            Location loc1 = e.getBlock().getLocation();
            {
            }
            player.setBedSpawnLocation(loc1);
            player.sendMessage("SPAWN SET TO MAGENTA BED");
        }
        if (block.getType().equals(Material.ORANGE_BED)) {
            Location loc1 = e.getBlock().getLocation();
            {
            }
            player.setBedSpawnLocation(loc1);
            player.sendMessage("SPAWN SET TO ORANGE BED");
        }
        if (block.getType().equals(Material.PINK_BED)) {
            Location loc1 = e.getBlock().getLocation();
            {
            }
            player.setBedSpawnLocation(loc1);
            player.sendMessage("SPAWN SET TO PINK BED");
        }
        if (block.getType().equals(Material.PURPLE_BED)) {
            Location loc1 = e.getBlock().getLocation();
            {
            }
            player.setBedSpawnLocation(loc1);
            player.sendMessage("SPAWN SET TO PURPLE BED");
        }
        if (block.getType().equals(Material.RED_BED)) {
            Location loc1 = e.getBlock().getLocation();
            {
            }
            player.setBedSpawnLocation(loc1);
            player.sendMessage("SPAWN SET TO RED BED");
        }
        if (block.getType().equals(Material.WHITE_BED)) {
            Location loc1 = e.getBlock().getLocation();
            {
            }
            player.setBedSpawnLocation(loc1);
            player.sendMessage("SPAWN SET TO WHITE BED");
        }
        if (block.getType().equals(Material.YELLOW_BED)) {
            Location loc1 = e.getBlock().getLocation();
            {
            }
            player.setBedSpawnLocation(loc1);
            player.sendMessage("SPAWN SET TO YELLOW BED");
        }
    }

    @EventHandler
    public void sleep(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        if (block.getType().equals(Material.BLACK_BED)){
            e.setCancelled(true);
        }
    }
}

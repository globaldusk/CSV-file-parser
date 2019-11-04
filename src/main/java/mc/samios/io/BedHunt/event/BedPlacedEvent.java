package mc.samios.io.BedHunt.event;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
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
        if (block.getType().equals(Material.BLACK_BED) || block.getType().equals(Material.LIME_BED) || block.getType().equals(Material.BLUE_BED) || block.getType().equals(Material.BROWN_BED) || block.getType().equals(Material.CYAN_BED) || block.getType().equals(Material.GRAY_BED) || block.getType().equals(Material.GREEN_BED) || block.getType().equals(Material.LIGHT_BLUE_BED) || block.getType().equals(Material.LIGHT_GRAY_BED) || block.getType().equals(Material.MAGENTA_BED) || block.getType().equals(Material.YELLOW_BED) || block.getType().equals(Material.WHITE_BED) || block.getType().equals(Material.RED_BED) || block.getType().equals(Material.PINK_BED) || block.getType().equals(Material.PURPLE_BED) || block.getType().equals(Material.ORANGE_BED)) {
            Location loc1 = e.getBlock().getLocation();

            int above = block.getY() + 1;
            int side1 = block.getX() + 1;
            int side2 = block.getX() - 1;
            int side3 = block.getZ() + 1;
            int side4 = block.getZ() - 1;

            loc1.setX(side1);
            if (loc1.getBlock().getType().equals(Material.AIR)) {
                loc1.setX(side2);
                if (loc1.getBlock().getType().equals(Material.AIR)) {
                    loc1.setZ(side3);
                    if (loc1.getBlock().getType().equals(Material.AIR)) {
                        loc1.setZ(side4);
                        if (loc1.getBlock().getType().equals(Material.AIR)) {
                            loc1.setZ(side4);
                            loc1.setY(above);
                            if (loc1.getBlock().getType().equals(Material.AIR)) {
                                loc1.setZ(side1);
                                loc1.setY(above);
                                if (loc1.getBlock().getType().equals(Material.AIR)) {
                                    loc1.setZ(side2);
                                    loc1.setY(above);
                                    if (loc1.getBlock().getType().equals(Material.AIR)) {
                                        loc1.setZ(side3);
                                        loc1.setY(above);
                                        if (loc1.getBlock().getType().equals(Material.AIR)) {
                                            loc1.setZ(side4);
                                            loc1.setY(above);
                                            if (loc1.getBlock().getType().equals(Material.AIR)) {
                                                loc1.setZ(block.getZ());
                                                loc1.setY(above);
                                                if (loc1.getBlock().getType().equals(Material.AIR)) {
                                                    if (loc1.getY() <= 40) {
                                                        e.setCancelled(true);
                                                        player.sendMessage(ChatColor.RED + "You cannot place the bed this deep!");
                                                    } else {
                                                        player.setBedSpawnLocation(loc1);
                                                        player.sendMessage(ChatColor.GOLD + "Team spawn set");
                                                    }
                                                }
                                                else{
                                                    e.setCancelled(true);
                                                    player.sendMessage(ChatColor.RED + "Blocks are too close to the bed!10");
                                                }
                                            }
                                            else{
                                                e.setCancelled(true);
                                                player.sendMessage(ChatColor.RED + "Blocks are too close to the bed!9");
                                            }
                                        }
                                        else{
                                            e.setCancelled(true);
                                            player.sendMessage(ChatColor.RED + "Blocks are too close to the bed!8");
                                        }
                                    }
                                    else{
                                        e.setCancelled(true);
                                        player.sendMessage(ChatColor.RED + "Blocks are too close to the bed!7");
                                    }
                                }
                                else{
                                    e.setCancelled(true);
                                    player.sendMessage(ChatColor.RED + "Blocks are too close to the bed!6");
                                }
                            }
                            else{
                                e.setCancelled(true);
                                player.sendMessage(ChatColor.RED + "Blocks are too close to the bed!5");
                            }
                        }
                        else{
                            e.setCancelled(true);
                            player.sendMessage(ChatColor.RED + "Blocks are too close to the bed!4");
                        }
                    }
                    else{
                        e.setCancelled(true);
                        player.sendMessage(ChatColor.RED + "Blocks are too close to the bed!3");
                    }
                }
                else{
                    e.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "Blocks are too close to the bed!2");
                }
            }
            else{
                e.setCancelled(true);
                player.sendMessage(ChatColor.RED + "Blocks are too close to the bed!1");
            }
        }
    }



    @EventHandler
    public void sleep(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        if (block != null){
            if (block.getType().equals(Material.BLACK_BED) || block.getType().equals(Material.LIME_BED) || block.getType().equals(Material.BLUE_BED) || block.getType().equals(Material.BROWN_BED) || block.getType().equals(Material.CYAN_BED) || block.getType().equals(Material.GRAY_BED) || block.getType().equals(Material.GREEN_BED) || block.getType().equals(Material.LIGHT_BLUE_BED) || block.getType().equals(Material.LIGHT_GRAY_BED) || block.getType().equals(Material.MAGENTA_BED) || block.getType().equals(Material.YELLOW_BED) || block.getType().equals(Material.WHITE_BED) || block.getType().equals(Material.RED_BED) || block.getType().equals(Material.PINK_BED) ||block.getType().equals(Material.PURPLE_BED) ||block.getType().equals(Material.ORANGE_BED)) {
                e.setCancelled(true);
            }
        }
    }
}
package mc.samios.io.BedHunt.event;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockNextToBedEvent implements Listener {
    @EventHandler
    public void place(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        Block block = e.getBlock();
        Location loc1 = e.getBlock().getLocation();
        
        int below = block.getY() - 1;
        int side1 = block.getX() + 1;
        int side2 = block.getX() - 1;
        int side3 = block.getZ() + 1;
        int side4 = block.getZ() - 1;

        if (block.getType().equals(Material.BLACK_BED) || block.getType().equals(Material.LIME_BED) || block.getType().equals(Material.BLUE_BED) || block.getType().equals(Material.BROWN_BED) || block.getType().equals(Material.CYAN_BED) || block.getType().equals(Material.GRAY_BED) || block.getType().equals(Material.GREEN_BED) || block.getType().equals(Material.LIGHT_BLUE_BED) || block.getType().equals(Material.LIGHT_GRAY_BED) || block.getType().equals(Material.MAGENTA_BED) || block.getType().equals(Material.YELLOW_BED) || block.getType().equals(Material.WHITE_BED) || block.getType().equals(Material.RED_BED) || block.getType().equals(Material.PINK_BED) || block.getType().equals(Material.PURPLE_BED) || block.getType().equals(Material.ORANGE_BED)) {
        }
        else{
            loc1.setX(side1);
            if (!loc1.getBlock().getType().equals(Material.BLACK_BED) && !loc1.getBlock().getType().equals(Material.LIME_BED) && !loc1.getBlock().getType().equals(Material.BLUE_BED) && !loc1.getBlock().getType().equals(Material.BROWN_BED) && !loc1.getBlock().getType().equals(Material.CYAN_BED) && !loc1.getBlock().getType().equals(Material.GRAY_BED) && !loc1.getBlock().getType().equals(Material.GREEN_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_BLUE_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_GRAY_BED) && !loc1.getBlock().getType().equals(Material.MAGENTA_BED) && !loc1.getBlock().getType().equals(Material.YELLOW_BED) && !loc1.getBlock().getType().equals(Material.WHITE_BED) && !loc1.getBlock().getType().equals(Material.RED_BED) && !loc1.getBlock().getType().equals(Material.PINK_BED) && !loc1.getBlock().getType().equals(Material.PURPLE_BED) && !loc1.getBlock().getType().equals(Material.ORANGE_BED)) {
                loc1.setX(side2);

                if (!loc1.getBlock().getType().equals(Material.BLACK_BED) && !loc1.getBlock().getType().equals(Material.LIME_BED) && !loc1.getBlock().getType().equals(Material.BLUE_BED) && !loc1.getBlock().getType().equals(Material.BROWN_BED) && !loc1.getBlock().getType().equals(Material.CYAN_BED) && !loc1.getBlock().getType().equals(Material.GRAY_BED) && !loc1.getBlock().getType().equals(Material.GREEN_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_BLUE_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_GRAY_BED) && !loc1.getBlock().getType().equals(Material.MAGENTA_BED) && !loc1.getBlock().getType().equals(Material.YELLOW_BED) && !loc1.getBlock().getType().equals(Material.WHITE_BED) && !loc1.getBlock().getType().equals(Material.RED_BED) && !loc1.getBlock().getType().equals(Material.PINK_BED) && !loc1.getBlock().getType().equals(Material.PURPLE_BED) && !loc1.getBlock().getType().equals(Material.ORANGE_BED)) {
                    loc1.setX(block.getX());
                    loc1.setZ(side3);

                    if (!loc1.getBlock().getType().equals(Material.BLACK_BED) && !loc1.getBlock().getType().equals(Material.LIME_BED) && !loc1.getBlock().getType().equals(Material.BLUE_BED) && !loc1.getBlock().getType().equals(Material.BROWN_BED) && !loc1.getBlock().getType().equals(Material.CYAN_BED) && !loc1.getBlock().getType().equals(Material.GRAY_BED) && !loc1.getBlock().getType().equals(Material.GREEN_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_BLUE_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_GRAY_BED) && !loc1.getBlock().getType().equals(Material.MAGENTA_BED) && !loc1.getBlock().getType().equals(Material.YELLOW_BED) && !loc1.getBlock().getType().equals(Material.WHITE_BED) && !loc1.getBlock().getType().equals(Material.RED_BED) && !loc1.getBlock().getType().equals(Material.PINK_BED) && !loc1.getBlock().getType().equals(Material.PURPLE_BED) && !loc1.getBlock().getType().equals(Material.ORANGE_BED)) {
                        loc1.setZ(side4);

                        if (!loc1.getBlock().getType().equals(Material.BLACK_BED) && !loc1.getBlock().getType().equals(Material.LIME_BED) && !loc1.getBlock().getType().equals(Material.BLUE_BED) && !loc1.getBlock().getType().equals(Material.BROWN_BED) && !loc1.getBlock().getType().equals(Material.CYAN_BED) && !loc1.getBlock().getType().equals(Material.GRAY_BED) && !loc1.getBlock().getType().equals(Material.GREEN_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_BLUE_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_GRAY_BED) && !loc1.getBlock().getType().equals(Material.MAGENTA_BED) && !loc1.getBlock().getType().equals(Material.YELLOW_BED) && !loc1.getBlock().getType().equals(Material.WHITE_BED) && !loc1.getBlock().getType().equals(Material.RED_BED) && !loc1.getBlock().getType().equals(Material.PINK_BED) && !loc1.getBlock().getType().equals(Material.PURPLE_BED) && !loc1.getBlock().getType().equals(Material.ORANGE_BED)) {
                            loc1.setZ(block.getZ());
                            loc1.setY(below);

                            if (!loc1.getBlock().getType().equals(Material.BLACK_BED) && !loc1.getBlock().getType().equals(Material.LIME_BED) && !loc1.getBlock().getType().equals(Material.BLUE_BED) && !loc1.getBlock().getType().equals(Material.BROWN_BED) && !loc1.getBlock().getType().equals(Material.CYAN_BED) && !loc1.getBlock().getType().equals(Material.GRAY_BED) && !loc1.getBlock().getType().equals(Material.GREEN_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_BLUE_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_GRAY_BED) && !loc1.getBlock().getType().equals(Material.MAGENTA_BED) && !loc1.getBlock().getType().equals(Material.YELLOW_BED) && !loc1.getBlock().getType().equals(Material.WHITE_BED) && !loc1.getBlock().getType().equals(Material.RED_BED) && !loc1.getBlock().getType().equals(Material.PINK_BED) && !loc1.getBlock().getType().equals(Material.PURPLE_BED) && !loc1.getBlock().getType().equals(Material.ORANGE_BED)) {
                                loc1.setY(block.getY());
                                loc1.setX(side1);
                                loc1.setZ(side3);

                                if (!loc1.getBlock().getType().equals(Material.BLACK_BED) && !loc1.getBlock().getType().equals(Material.LIME_BED) && !loc1.getBlock().getType().equals(Material.BLUE_BED) && !loc1.getBlock().getType().equals(Material.BROWN_BED) && !loc1.getBlock().getType().equals(Material.CYAN_BED) && !loc1.getBlock().getType().equals(Material.GRAY_BED) && !loc1.getBlock().getType().equals(Material.GREEN_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_BLUE_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_GRAY_BED) && !loc1.getBlock().getType().equals(Material.MAGENTA_BED) && !loc1.getBlock().getType().equals(Material.YELLOW_BED) && !loc1.getBlock().getType().equals(Material.WHITE_BED) && !loc1.getBlock().getType().equals(Material.RED_BED) && !loc1.getBlock().getType().equals(Material.PINK_BED) && !loc1.getBlock().getType().equals(Material.PURPLE_BED) && !loc1.getBlock().getType().equals(Material.ORANGE_BED)) {
                                    loc1.setX(side2);
                                    loc1.setZ(side4);

                                    if (!loc1.getBlock().getType().equals(Material.BLACK_BED) && !loc1.getBlock().getType().equals(Material.LIME_BED) && !loc1.getBlock().getType().equals(Material.BLUE_BED) && !loc1.getBlock().getType().equals(Material.BROWN_BED) && !loc1.getBlock().getType().equals(Material.CYAN_BED) && !loc1.getBlock().getType().equals(Material.GRAY_BED) && !loc1.getBlock().getType().equals(Material.GREEN_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_BLUE_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_GRAY_BED) && !loc1.getBlock().getType().equals(Material.MAGENTA_BED) && !loc1.getBlock().getType().equals(Material.YELLOW_BED) && !loc1.getBlock().getType().equals(Material.WHITE_BED) && !loc1.getBlock().getType().equals(Material.RED_BED) && !loc1.getBlock().getType().equals(Material.PINK_BED) && !loc1.getBlock().getType().equals(Material.PURPLE_BED) && !loc1.getBlock().getType().equals(Material.ORANGE_BED)) {
                                        loc1.setX(side1);
                                        loc1.setZ(side4);

                                        if (!loc1.getBlock().getType().equals(Material.BLACK_BED) && !loc1.getBlock().getType().equals(Material.LIME_BED) && !loc1.getBlock().getType().equals(Material.BLUE_BED) && !loc1.getBlock().getType().equals(Material.BROWN_BED) && !loc1.getBlock().getType().equals(Material.CYAN_BED) && !loc1.getBlock().getType().equals(Material.GRAY_BED) && !loc1.getBlock().getType().equals(Material.GREEN_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_BLUE_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_GRAY_BED) && !loc1.getBlock().getType().equals(Material.MAGENTA_BED) && !loc1.getBlock().getType().equals(Material.YELLOW_BED) && !loc1.getBlock().getType().equals(Material.WHITE_BED) && !loc1.getBlock().getType().equals(Material.RED_BED) && !loc1.getBlock().getType().equals(Material.PINK_BED) && !loc1.getBlock().getType().equals(Material.PURPLE_BED) && !loc1.getBlock().getType().equals(Material.ORANGE_BED)) {
                                            loc1.setX(side2);
                                            loc1.setZ(side3);

                                            if (!loc1.getBlock().getType().equals(Material.BLACK_BED) && !loc1.getBlock().getType().equals(Material.LIME_BED) && !loc1.getBlock().getType().equals(Material.BLUE_BED) && !loc1.getBlock().getType().equals(Material.BROWN_BED) && !loc1.getBlock().getType().equals(Material.CYAN_BED) && !loc1.getBlock().getType().equals(Material.GRAY_BED) && !loc1.getBlock().getType().equals(Material.GREEN_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_BLUE_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_GRAY_BED) && !loc1.getBlock().getType().equals(Material.MAGENTA_BED) && !loc1.getBlock().getType().equals(Material.YELLOW_BED) && !loc1.getBlock().getType().equals(Material.WHITE_BED) && !loc1.getBlock().getType().equals(Material.RED_BED) && !loc1.getBlock().getType().equals(Material.PINK_BED) && !loc1.getBlock().getType().equals(Material.PURPLE_BED) && !loc1.getBlock().getType().equals(Material.ORANGE_BED)) {
                                                loc1.setY(below);
                                                loc1.setX(side1);

                                                if (!loc1.getBlock().getType().equals(Material.BLACK_BED) && !loc1.getBlock().getType().equals(Material.LIME_BED) && !loc1.getBlock().getType().equals(Material.BLUE_BED) && !loc1.getBlock().getType().equals(Material.BROWN_BED) && !loc1.getBlock().getType().equals(Material.CYAN_BED) && !loc1.getBlock().getType().equals(Material.GRAY_BED) && !loc1.getBlock().getType().equals(Material.GREEN_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_BLUE_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_GRAY_BED) && !loc1.getBlock().getType().equals(Material.MAGENTA_BED) && !loc1.getBlock().getType().equals(Material.YELLOW_BED) && !loc1.getBlock().getType().equals(Material.WHITE_BED) && !loc1.getBlock().getType().equals(Material.RED_BED) && !loc1.getBlock().getType().equals(Material.PINK_BED) && !loc1.getBlock().getType().equals(Material.PURPLE_BED) && !loc1.getBlock().getType().equals(Material.ORANGE_BED)) {
                                                    loc1.setX(side2);

                                                    if (!loc1.getBlock().getType().equals(Material.BLACK_BED) && !loc1.getBlock().getType().equals(Material.LIME_BED) && !loc1.getBlock().getType().equals(Material.BLUE_BED) && !loc1.getBlock().getType().equals(Material.BROWN_BED) && !loc1.getBlock().getType().equals(Material.CYAN_BED) && !loc1.getBlock().getType().equals(Material.GRAY_BED) && !loc1.getBlock().getType().equals(Material.GREEN_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_BLUE_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_GRAY_BED) && !loc1.getBlock().getType().equals(Material.MAGENTA_BED) && !loc1.getBlock().getType().equals(Material.YELLOW_BED) && !loc1.getBlock().getType().equals(Material.WHITE_BED) && !loc1.getBlock().getType().equals(Material.RED_BED) && !loc1.getBlock().getType().equals(Material.PINK_BED) && !loc1.getBlock().getType().equals(Material.PURPLE_BED) && !loc1.getBlock().getType().equals(Material.ORANGE_BED)) {
                                                        loc1.setX(block.getX());
                                                        loc1.setZ(side3);

                                                        if (!loc1.getBlock().getType().equals(Material.BLACK_BED) && !loc1.getBlock().getType().equals(Material.LIME_BED) && !loc1.getBlock().getType().equals(Material.BLUE_BED) && !loc1.getBlock().getType().equals(Material.BROWN_BED) && !loc1.getBlock().getType().equals(Material.CYAN_BED) && !loc1.getBlock().getType().equals(Material.GRAY_BED) && !loc1.getBlock().getType().equals(Material.GREEN_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_BLUE_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_GRAY_BED) && !loc1.getBlock().getType().equals(Material.MAGENTA_BED) && !loc1.getBlock().getType().equals(Material.YELLOW_BED) && !loc1.getBlock().getType().equals(Material.WHITE_BED) && !loc1.getBlock().getType().equals(Material.RED_BED) && !loc1.getBlock().getType().equals(Material.PINK_BED) && !loc1.getBlock().getType().equals(Material.PURPLE_BED) && !loc1.getBlock().getType().equals(Material.ORANGE_BED)) {
                                                            loc1.setZ(side4);

                                                            if (!loc1.getBlock().getType().equals(Material.BLACK_BED) && !loc1.getBlock().getType().equals(Material.LIME_BED) && !loc1.getBlock().getType().equals(Material.BLUE_BED) && !loc1.getBlock().getType().equals(Material.BROWN_BED) && !loc1.getBlock().getType().equals(Material.CYAN_BED) && !loc1.getBlock().getType().equals(Material.GRAY_BED) && !loc1.getBlock().getType().equals(Material.GREEN_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_BLUE_BED) && !loc1.getBlock().getType().equals(Material.LIGHT_GRAY_BED) && !loc1.getBlock().getType().equals(Material.MAGENTA_BED) && !loc1.getBlock().getType().equals(Material.YELLOW_BED) && !loc1.getBlock().getType().equals(Material.WHITE_BED) && !loc1.getBlock().getType().equals(Material.RED_BED) && !loc1.getBlock().getType().equals(Material.PINK_BED) && !loc1.getBlock().getType().equals(Material.PURPLE_BED) && !loc1.getBlock().getType().equals(Material.ORANGE_BED)) {

                                                            } else {
                                                                e.setCancelled(true);
                                                                player.sendMessage(ChatColor.RED + "Cannot place blocks next to bed!");
                                                            }
                                                        } else {
                                                            e.setCancelled(true);
                                                            player.sendMessage(ChatColor.RED + "Cannot place blocks next to bed!");
                                                        }
                                                    } else {
                                                        e.setCancelled(true);
                                                        player.sendMessage(ChatColor.RED + "Cannot place blocks next to bed!");
                                                    }
                                                } else {
                                                    e.setCancelled(true);
                                                    player.sendMessage(ChatColor.RED + "Cannot place blocks next to bed!");
                                                }
                                            } else {
                                                e.setCancelled(true);
                                                player.sendMessage(ChatColor.RED + "Cannot place blocks next to bed!");
                                            }
                                        } else {
                                            e.setCancelled(true);
                                            player.sendMessage(ChatColor.RED + "Cannot place blocks next to bed!");
                                        }
                                    } else {
                                        e.setCancelled(true);
                                        player.sendMessage(ChatColor.RED + "Cannot place blocks next to bed!");
                                    }
                                } else {
                                    e.setCancelled(true);
                                    player.sendMessage(ChatColor.RED + "Cannot place blocks next to bed!");
                                }
                            } else {
                                e.setCancelled(true);
                                player.sendMessage(ChatColor.RED + "Cannot place blocks next to bed!");
                            }
                        } else {
                            e.setCancelled(true);
                            player.sendMessage(ChatColor.RED + "Cannot place blocks next to bed!");
                        }
                    }
                } else {
                    e.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "Cannot place blocks next to bed!");
                }
            } else {
                e.setCancelled(true);
                player.sendMessage(ChatColor.RED + "Cannot place blocks next to bed!");
            }
        }
    }
}
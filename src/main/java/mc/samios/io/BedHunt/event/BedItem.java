package mc.samios.io.BedHunt.event;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BedItem implements Listener {

    @EventHandler
    public void DropItem(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        Item item = e.getItemDrop();

        if (item.getItemStack().getType().equals(Material.BLACK_BED) || item.getItemStack().getType().equals(Material.LIME_BED) || item.getItemStack().getType().equals(Material.BLUE_BED) || item.getItemStack().getType().equals(Material.BROWN_BED) || item.getItemStack().getType().equals(Material.CYAN_BED) || item.getItemStack().getType().equals(Material.GRAY_BED) || item.getItemStack().getType().equals(Material.GREEN_BED) || item.getItemStack().getType().equals(Material.LIGHT_BLUE_BED) || item.getItemStack().getType().equals(Material.LIGHT_GRAY_BED) || item.getItemStack().getType().equals(Material.MAGENTA_BED) || item.getItemStack().getType().equals(Material.YELLOW_BED) || item.getItemStack().getType().equals(Material.WHITE_BED) || item.getItemStack().getType().equals(Material.RED_BED) || item.getItemStack().getType().equals(Material.PINK_BED) || item.getItemStack().getType().equals(Material.PURPLE_BED) || item.getItemStack().getType().equals(Material.ORANGE_BED)){
            e.setCancelled(true);
            player.sendMessage("dropping Beds is cancelled!");
        }
    }

    @EventHandler
    public void PickupItem(EntityPickupItemEvent e) {
        Entity mob = e.getEntity();
        Item item = e.getItem();

        if (item.getItemStack().getType().equals(Material.BLACK_BED) || item.getItemStack().getType().equals(Material.LIME_BED) || item.getItemStack().getType().equals(Material.BLUE_BED) || item.getItemStack().getType().equals(Material.BROWN_BED) || item.getItemStack().getType().equals(Material.CYAN_BED) || item.getItemStack().getType().equals(Material.GRAY_BED) || item.getItemStack().getType().equals(Material.GREEN_BED) || item.getItemStack().getType().equals(Material.LIGHT_BLUE_BED) || item.getItemStack().getType().equals(Material.LIGHT_GRAY_BED) || item.getItemStack().getType().equals(Material.MAGENTA_BED) || item.getItemStack().getType().equals(Material.YELLOW_BED) || item.getItemStack().getType().equals(Material.WHITE_BED) || item.getItemStack().getType().equals(Material.RED_BED) || item.getItemStack().getType().equals(Material.PINK_BED) || item.getItemStack().getType().equals(Material.PURPLE_BED) || item.getItemStack().getType().equals(Material.ORANGE_BED)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public final void onChestMove(InventoryClickEvent event) {
        Inventory top = event.getView().getTopInventory();
        Inventory bottom = event.getView().getBottomInventory();
        if ((top.getType() == InventoryType.CHEST || top.getType() == InventoryType.BARREL || top.getType() == InventoryType.BLAST_FURNACE || top.getType() == InventoryType.DISPENSER || top.getType() == InventoryType.BREWING || top.getType() == InventoryType.DROPPER || top.getType() == InventoryType.HOPPER || top.getType() == InventoryType.STONECUTTER || top.getType() == InventoryType.SMOKER || top.getType() == InventoryType.FURNACE) && bottom.getType() == InventoryType.PLAYER) {
            ItemStack item = event.getCurrentItem();
            assert item != null;
            if (item.getType().equals(Material.BLACK_BED) || item.getType().equals(Material.LIME_BED) || item.getType().equals(Material.BLUE_BED) || item.getType().equals(Material.BROWN_BED) || item.getType().equals(Material.CYAN_BED) || item.getType().equals(Material.GRAY_BED) || item.getType().equals(Material.GREEN_BED) || item.getType().equals(Material.LIGHT_BLUE_BED) || item.getType().equals(Material.LIGHT_GRAY_BED) || item.getType().equals(Material.MAGENTA_BED) || item.getType().equals(Material.YELLOW_BED) || item.getType().equals(Material.WHITE_BED) || item.getType().equals(Material.RED_BED) || item.getType().equals(Material.PINK_BED) || item.getType().equals(Material.PURPLE_BED) || item.getType().equals(Material.ORANGE_BED)){
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public final void bedItemDrop(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (block.getType().equals(Material.BLACK_BED) || block.getType().equals(Material.LIME_BED) || block.getType().equals(Material.BLUE_BED) ||
                block.getType().equals(Material.BROWN_BED)
                || block.getType().equals(Material.CYAN_BED) || block.getType().equals(Material.GRAY_BED) || block.getType().equals(Material.GREEN_BED) ||
                block.getType().equals(Material.LIGHT_BLUE_BED) || block.getType().equals(Material.LIGHT_GRAY_BED) || block.getType().equals(Material.MAGENTA_BED) || block.getType().equals(Material.YELLOW_BED)
                || block.getType().equals(Material.WHITE_BED) || block.getType().equals(Material.RED_BED) || block.getType().equals(Material.PINK_BED) || block.getType().equals(Material.PURPLE_BED) || block.getType().equals(Material.ORANGE_BED)) {

           block.getDrops().clear();

        }

    }
    @EventHandler
    public final void bedExplode(BlockExplodeEvent event) {
        Block block = event.getBlock();
        if (block.getType().equals(Material.BLACK_BED) || block.getType().equals(Material.LIME_BED) || block.getType().equals(Material.BLUE_BED) ||
                block.getType().equals(Material.BROWN_BED)
                || block.getType().equals(Material.CYAN_BED) || block.getType().equals(Material.GRAY_BED) || block.getType().equals(Material.GREEN_BED) ||
                block.getType().equals(Material.LIGHT_BLUE_BED) || block.getType().equals(Material.LIGHT_GRAY_BED) || block.getType().equals(Material.MAGENTA_BED) || block.getType().equals(Material.YELLOW_BED)
                || block.getType().equals(Material.WHITE_BED) || block.getType().equals(Material.RED_BED) || block.getType().equals(Material.PINK_BED) || block.getType().equals(Material.PURPLE_BED) || block.getType().equals(Material.ORANGE_BED)) {

            block.getDrops().clear();

        }

    }
}


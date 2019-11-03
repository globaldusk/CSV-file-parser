package mc.samios.io.BedHunt.event;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class CraftingBlacklistEvent implements Listener{
    @EventHandler
    public void craftItem(PrepareItemCraftEvent e) {
        Material itemType = Objects.requireNonNull(e.getRecipe()).getResult().getType();
        byte itemData = Objects.requireNonNull(e.getRecipe().getResult().getData()).getData();
        if(itemType == Material.BLACK_BED ||itemType==Material.BLUE_BED||(itemType==Material.BROWN_BED||(itemType==Material.CYAN_BED||(itemType==Material.GRAY_BED||(itemType==Material.GREEN_BED||(itemType==Material.LIGHT_BLUE_BED||(itemType==Material.LIGHT_GRAY_BED||(itemType==Material.LIME_BED||(itemType==Material.MAGENTA_BED||(itemType==Material.ORANGE_BED||(itemType==Material.PINK_BED||(itemType==Material.PURPLE_BED||(itemType==Material.RED_BED||(itemType==Material.WHITE_BED||(itemType==Material.YELLOW_BED&&itemData==1))))))))))))))) {
            e.getInventory().setResult(new ItemStack(Material.AIR));
            for(HumanEntity he:e.getViewers()) {
                if(he instanceof Player) {
                    ((Player)he).sendMessage(ChatColor.RED+"You cannot craft this!");
                }
            }
        }
    }//MENTION THIS METHOD SOMEWHERE!
}

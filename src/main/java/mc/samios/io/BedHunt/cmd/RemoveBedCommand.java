package mc.samios.io.BedHunt.cmd;

import mc.samios.io.BedHunt.Main;
import mc.samios.io.BedHunt.util.C;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class RemoveBedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        Player player = (Player) sender;
        if (player.isOp()) {
            if (args.length == 0) {
                Block bed = player.getTargetBlock(null, 5);
                if (Main.checkBed(bed)) {
                    Location halfX = bed.getLocation().add(1, 0, 0);
                    Location halfZ = bed.getLocation().add(0, 0, 1);
                    Location subHalfX = bed.getLocation().subtract(1, 0, 0);
                    Location subHalfZ = bed.getLocation().subtract(0, 0, 1);
                    halfX.getBlock().setType(Material.AIR);
                    halfZ.getBlock().setType(Material.AIR);
                    subHalfX.getBlock().setType(Material.AIR);
                    subHalfZ.getBlock().setType(Material.AIR);
                    bed.setType(Material.AIR);
                    player.sendMessage(C.staff("Admin", "Targeted bed destroyed successfully!"));
                } else {
                    player.sendMessage(C.staff("Admin", "You are not looking at a bed!"));
                }
            } if (args.length == 1 && args[0].equalsIgnoreCase("all")) {
                // remove all beds
            } // add method for removing individual team beds
        } else {
            player.sendMessage(C.error("Permissions", "You are not allowed to do this."));
        }

        return true;
    }

}

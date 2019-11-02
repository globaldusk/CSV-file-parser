package mc.samios.io.BedHunt.cmd;

import mc.samios.io.BedHunt.lobby.Cuboid;
import mc.samios.io.BedHunt.util.C;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CubeCommand implements CommandExecutor {



    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        Player player = (Player) sender;

        org.bukkit.World world = Bukkit.getWorld("world");
        double startX = player.getLocation().getX();
        double startY = player.getLocation().getY();
        double startZ = player.getLocation().getZ();
        Material material = Material.GLASS;

        for (int x = 0; x < 10; x++) {
            for (int z = 0; z < 10; z++) {
                for (int y = 0; y <= 10; y++) {
                    Location loc = new Location(world, startX + x, startY + y, startZ + z);
                    if (y != 10 && y!=0) {
                        if ((x >= 0 && z == 0) || (x >= 0 && z == 9) ||( x == 0 && z >= 0) || (x == 9 && z >= 0))
                            loc.getBlock().setType(material);
                    } else {
                        loc.getBlock().setType(material);
                    }
                }
            }
        }
        //to change the size the first 3 values must be the same and then the next two x and z values must be 1 less than the first 3

        return false;
    }
}

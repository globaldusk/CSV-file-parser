package mc.samios.io.BedHunt.cmd;

import mc.samios.io.BedHunt.util.C;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeathmatchCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player player = (Player) sender;
        if (player.isOp()) {
            if (args.length == 0) {
                player.sendMessage(C.prefix("Deathmatch", "Are you sure you want to start deathmatch now? Type " + C.green + "/deathmatch confirm" + C.yellow + " to confirm."));
            }
            else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("confirm")) {
                    // start deathmatch
                    player.sendMessage(C.prefix("Deathmatch", "You have started the Deathmatch stage!"));
                    Bukkit.broadcastMessage(C.prefix("Deathmatch", C.red + C.bold + "The deathmatch stage has started early and will begin in 30 seconds."));
                } else {
                    player.sendMessage(C.prefix("Deathmatch", "Are you sure you want to start deathmatch now? Type " + C.green + "/deathmatch confirm" + C.yellow + " to confirm."));
                }
            }
        } else {
            player.sendMessage(C.error("Permissions", "You are not allowed to do this."));
        }
        return false;
    }
}

package mc.samios.io.BedHunt.cmd;

import mc.samios.io.BedHunt.util.C;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfoCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        Player player = (Player) sender;
        player.sendMessage(C.prefix("BedHunt", "Welcome to BedHunt!\n\nRULES HERE\n\nINSTRUCTIONS HERE"));
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 5, 1);
        return true;
    }
}

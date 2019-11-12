package mc.samios.io.BedHunt.cmd;

import mc.samios.io.BedHunt.util.C;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage(C.prefix("Chat", "Usage: /chat <team|all>"));
        }
        if (args.length >= 1) {
            String chatMode = args[0];
            if (chatMode.toLowerCase() == "team" || chatMode.toLowerCase() == "t") {
            } else if (chatMode.toLowerCase() == "all" || chatMode.toLowerCase() == "a") {
                player.sendMessage(C.prefix("Chat", "Changed chat channel to " + C.green + "ALL"));
            } else {
                player.sendMessage(C.prefix("Chat", "Usage: /chat <team|all>"));
            }
        }
        return true;
    }
}

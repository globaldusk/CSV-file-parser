package mc.samios.io.BedHunt.cmd;

import mc.samios.io.BedHunt.util.C;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RulesCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        Player player = (Player) sender;
        player.sendMessage(C.prefix("Rules", "These are the rules of BedHunt:" +
                "\n\n1. Teams consist of two players each\n\n2. There are minimum 6 players, and maximum 10." +
                "\n\n3. If you do not place your bed within the first hour, you will not respawn.\n\n" +
                "4. Beds must be placed between Y-levels 40 to 90.\n\n5. The Nether and The End are disabled.\n\n" +
                "6. There must be a 1-block radius around the bed, except under the bed.\n\nHave fun!"));
        return true;
    }
}

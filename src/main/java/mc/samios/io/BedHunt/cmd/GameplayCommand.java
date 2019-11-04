package mc.samios.io.BedHunt.cmd;

import mc.samios.io.BedHunt.util.C;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameplayCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        Player player = (Player) sender;
        player.sendMessage(C.prefix("Gameplay", "This is how to play Bed Hunt:\n\n\n&d" +
                "You will start in a team of two in a random location. You have an hour to gather resources " +
                "and hide your bed as best as you can. There are limits to where you can place your bed." +
                " After the hour passes, bed placement disables and PvP enables. You must then seek the other" +
                " teams beds, and once destroyed they can no longer respawn.\n\n\n&cThe deathmatch begins 2 hours into the game" +
                ", where all beds are instantly destroyed and the border shrinks. Whichever team survives, wins!"));
        return true;
    }
}

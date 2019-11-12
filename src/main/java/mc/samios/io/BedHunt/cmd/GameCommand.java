package mc.samios.io.BedHunt.cmd;

import mc.samios.io.BedHunt.event.GameEvents;
import mc.samios.io.BedHunt.util.C;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player player = (Player) sender;
        if (player.isOp()) {
            if (args.length == 0) {
                player.sendMessage(C.prefix("Game", "Usage: /game <start|stop|restart>"));
            }
            else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("start")) {
                    // start game
                    if (!GameEvents.gameStarted) {
                        player.sendMessage(C.prefix("Game", "You have successfully force-started the game countdown!"));
                        GameEvents.startGame();
                    } else if (GameEvents.gameStarted) {
                        // game has already started
                        player.sendMessage(C.error("Error", "Game has already started!"));
                    }
                } else if (args[0].equalsIgnoreCase("stop")) {
                    // stop game
                    // if game hasn't started then don't do anything.
                    if (GameEvents.gameStarted == false) {
                        player.sendMessage(C.error("Error", "Game hasn't started!"));
                        return false;
                    } else {
                        player.sendMessage(C.prefix("Game", "You have succesfully force-stopped the game!"));
                        GameEvents.startGame();
                    }
                } else if (args[0].equalsIgnoreCase("restart")) {
                    // restart game
                    player.sendMessage(C.prefix("Game", ""));
                }
            }
        } else {
            player.sendMessage(C.error("Permissions", "You are not allowed to do this."));
        }
        return false;
    }
}

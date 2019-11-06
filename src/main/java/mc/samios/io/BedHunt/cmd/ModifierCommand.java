package mc.samios.io.BedHunt.cmd;

import mc.samios.io.BedHunt.util.C;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ModifierCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        // Double Health: Player gets double health
        // Double Beds: Each player on the team gets a bed
        // Mystery Mode: Each player is nicked and doesn't know their teammate or opponents
        // Friendly Fire: Team mates can harm eachother but by doing so, they take equal damage.
        // Power-ups: Players can choose power-ups such as double-jump, etc.
        // Short-game: Game time is reduced by 1.25x.
        // No Grace Period: Damage/PvE/PvP is enabled as soon as the game starts.

        Player p = (Player) sender;
        if (p.isOp()) {
            // check if game has started.
            if (args.length == 0 || args.length == 1) {
                p.sendMessage(C.prefix("Modifiers", "Usage: /modifier <setting> <true|false>"));
                String spacer = C.aqua + ", " + C.yellow;
                p.sendMessage(C.prefix("Available Modifiers", "DOUBLEHEALTH" + spacer + "TWOBEDS" + spacer + "FRIENDLYFIRE" + spacer + "MYSTERY" + spacer + "SHORT" + spacer + "NOGRACE" + spacer + "POWERUP"));
            }
            if (args.length >= 2) {
                if (args[1] == "DOUBLEHEALTH") {
                    if (args[2] == "true") {
                        p.sendMessage(C.prefix("Modifier", "Double Heath Modifier enabled successfully!"));
                        Bukkit.broadcastMessage(C.prefix("Modifier", "Double Health Modifier has been enabled! All players will be given Double Heath!"));
                        growl();
                    } else if (args[2] == "false") {
                        p.sendMessage(C.prefix("Modifier", "Double Heath Modifier disabled successfully!"));
                        Bukkit.broadcastMessage(C.prefix("Modifier", "Double Health Modifier has been disabled!"));
                    } else {
                        p.sendMessage(C.error("Modifier", "Please specify either true or false for DOUBLE HEALTH."));
                    }
                } else if (args[1] == "TWOBEDS") {
                    if (args[2] == "true") {
                        p.sendMessage(C.prefix("Modifier", "Two Beds Modifier enabled successfully!"));
                        Bukkit.broadcastMessage(C.prefix("Modifier", "Two Beds Modifier has been enabled! Each team will be given two beds, meaning each player can set their own spawnpoint. Individual team beds must be within 100 blocks of eachother!"));
                        growl();
                    } else if (args[2] == "false") {
                        p.sendMessage(C.prefix("Modifier", "Two Beds Modifier disabled successfully!"));
                        Bukkit.broadcastMessage(C.prefix("Modifier", "Two Beds Modifier has been disabled!"));
                    } else {
                        p.sendMessage(C.error("Modifier", "Please specify either true or false for TWO BEDS."));
                    }
                } else if (args[1] == "FRIENDLYFIRE") {
                    if (args[2] == "true") {
                        p.sendMessage(C.prefix("Modifier", "Friendly Fire Modifier enabled successfully!"));
                        Bukkit.broadcastMessage(C.prefix("Modifier", "Friendly Fire Modifier has been enabled! You will be able to harm your teammate, but by doing so you will be punished... Be careful!"));
                        growl();
                    } else if (args[2] == "false") {
                        p.sendMessage(C.prefix("Modifier", "Friendly Fire Modifier disabled successfully!"));
                        Bukkit.broadcastMessage(C.prefix("Modifier", "Friendly Fire Modifier has been disabled!"));
                    } else {
                        p.sendMessage(C.error("Modifier", "Please specify either true or false for FRIENDLY FIRE."));
                    }
                } else {
                    p.sendMessage(C.error("Modifier", "Invalid modifier!"));
                }
            }
        } else {
            p.sendMessage(C.error("Permissions", "You are not allowed to do this."));
        }
        return false;
    }

    public void growl() {
        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.playSound(pl.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 5, 1);
        }
    }
}

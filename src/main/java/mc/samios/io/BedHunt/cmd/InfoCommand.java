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

public class InfoCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        Player player = (Player) sender;
        TextComponent info = new TextComponent(C.prefix("BedHunt", "Welcome to BedHunt!\n\n"));
        info.addExtra("§6For rules, CLICK HERE");
        info.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§b§lClick here for the rules!").create()));
        info.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/rules"));
        player.spigot().sendMessage(info);
        TextComponent gp = new TextComponent("§6For gameplay instructions, CLICK HERE\n");
        gp.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§b§lClick here for gameplay instructions!").create()));
        gp.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/gameplay"));
        player.spigot().sendMessage(gp);
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 5, 1);
        return true;
    }
}

package mc.samios.io.BedHunt;

import mc.samios.io.BedHunt.cmd.CubeCommand;
import mc.samios.io.BedHunt.cmd.InfoCommand;
import mc.samios.io.BedHunt.event.JoinQuitEvent;
import mc.samios.io.BedHunt.lobby.Lobby;
import mc.samios.io.BedHunt.util.C;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        cMsg(C.yellow + "Enabling BedHunt v0.1 by Australian and Jelly_Squid");
        cMsg(C.aqua + "Enabling commands...");
        registerCommands();
        cMsg(C.green + "Successfully enabled commands!");
        cMsg(C.aqua + "Registering events and listeners...");
        registerEvents();
        cMsg(C.green + "Successfully registered events and listeners!");
        cMsg(C.green + C.bold + "BedHunt has been enabled successfully!");

    }

    @Override
    public void onDisable() {
        cMsg(C.yellow + "Disabling BedHunt v0.1 by Australian and Jelly_Squid");
        cMsg(C.green + C.bold + "BedHunt has been disabled successfully!");
    }

    public void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new JoinQuitEvent(), this);
        this.getServer().getPluginManager().registerEvents(new Lobby(), this);

    }

    public void registerCommands() {
        getCommand("info").setExecutor(new InfoCommand());
        getCommand("cube").setExecutor(new CubeCommand());
    }

    public void cMsg(String message) {
        System.out.println(message);
    }
}

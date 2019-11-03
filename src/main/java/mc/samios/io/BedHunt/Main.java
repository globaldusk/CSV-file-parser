package mc.samios.io.BedHunt;

import mc.samios.io.BedHunt.cmd.CubeCommand;
import mc.samios.io.BedHunt.cmd.InfoCommand;
import mc.samios.io.BedHunt.event.JoinQuitEvent;
import mc.samios.io.BedHunt.team.Scoreboard;
import mc.samios.io.BedHunt.util.C;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin implements Listener {

    private static Main instance;
    public boolean gameStarted;

    public static Main getInstance() {
        return Main.instance;
    }

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
        gameStarted = false;
        new BukkitRunnable() {
            public void run() {
                for (final Player player : Bukkit.getOnlinePlayers()) {
                    if (!Main.this.gameStarted) {
                        Scoreboard.updateLobbyScoreboard(player);
                    }
                }
            }
        }.runTaskTimer((Plugin)this, 20L, 20L);
    }

    @Override
    public void onDisable() {
        cMsg(C.yellow + "Disabling BedHunt v0.1 by Australian and Jelly_Squid");
        cMsg(C.green + C.bold + "BedHunt has been disabled successfully!");
    }

    public void registerEvents() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getServer().getPluginManager().registerEvents(new JoinQuitEvent(), this);
        this.getServer().getPluginManager().registerEvents(new Scoreboard(), this);

    }

    public void registerCommands() {
        getCommand("info").setExecutor(new InfoCommand());
        getCommand("cube").setExecutor(new CubeCommand());
    }

    public void cMsg(String message) {
        System.out.println(message);
    }
}

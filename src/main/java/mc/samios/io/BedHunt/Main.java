package mc.samios.io.BedHunt;

import mc.samios.io.BedHunt.cmd.*;
import mc.samios.io.BedHunt.event.BedPlacedEvent;
import mc.samios.io.BedHunt.event.DestroyBedEvent;
import mc.samios.io.BedHunt.event.JoinQuitEvent;
import mc.samios.io.BedHunt.team.Scoreboard;
import mc.samios.io.BedHunt.util.C;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Main extends JavaPlugin implements Listener {

    private static Main instance;
    public boolean gameStarted;
    public static ArrayList<Material> beds = new ArrayList<>();

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
        bedList();
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getServer().getPluginManager().registerEvents(new JoinQuitEvent(), this);
        this.getServer().getPluginManager().registerEvents(new Scoreboard(), this);
        this.getServer().getPluginManager().registerEvents(new BedPlacedEvent(), this);
        this.getServer().getPluginManager().registerEvents(new DestroyBedEvent(), this);

    }

    public void registerCommands() {
        getCommand("info").setExecutor(new InfoCommand());
        getCommand("cube").setExecutor(new CubeCommand());
        getCommand("removebed").setExecutor(new RemoveBedCommand());
        getCommand("rules").setExecutor(new RulesCommand());
        getCommand("gameplay").setExecutor(new GameplayCommand());
    }

    public static boolean checkBed(Block bed) {
        if (bed.getType().equals(Material.BLACK_BED) || bed.getType().equals(Material.LIME_BED) || bed.getType().equals(Material.BLUE_BED) ||
                bed.getType().equals(Material.BROWN_BED)
                || bed.getType().equals(Material.CYAN_BED) || bed.getType().equals(Material.GRAY_BED) || bed.getType().equals(Material.GREEN_BED) ||
                bed.getType().equals(Material.LIGHT_BLUE_BED) || bed.getType().equals(Material.LIGHT_GRAY_BED) || bed.getType().equals(Material.MAGENTA_BED) || bed.getType().equals(Material.YELLOW_BED)
                || bed.getType().equals(Material.WHITE_BED) || bed.getType().equals(Material.RED_BED) || bed.getType().equals(Material.PINK_BED) || bed.getType().equals(Material.PURPLE_BED) || bed.getType().equals(Material.ORANGE_BED)) {
            return true;
        } else {
            return false;
        }
    }

    public void bedList() {
        beds.add(Material.WHITE_BED);
        beds.add(Material.BLACK_BED);
        beds.add(Material.ORANGE_BED);
        beds.add(Material.MAGENTA_BED);
        beds.add(Material.LIGHT_BLUE_BED);
        beds.add(Material.YELLOW_BED);
        beds.add(Material.LIME_BED);
        beds.add(Material.PINK_BED);
        beds.add(Material.GRAY_BED);
        beds.add(Material.LIGHT_GRAY_BED);
        beds.add(Material.CYAN_BED);
        beds.add(Material.PURPLE_BED);
        beds.add(Material.BROWN_BED);
        beds.add(Material.GREEN_BED);
        beds.add(Material.RED_BED);
    }

    public void cMsg(String message) {
        System.out.println(message);
    }
}

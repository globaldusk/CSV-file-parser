package mc.samios.io.BedHunt;

import mc.samios.io.BedHunt.cmd.*;
import mc.samios.io.BedHunt.event.*;
import mc.samios.io.BedHunt.team.Scoreboard;
import mc.samios.io.BedHunt.util.C;
import mc.samios.io.BedHunt.util.FileManager;
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
    public static ArrayList<Material> beds = new ArrayList<>();
    static FileManager fm;
    public static ArrayList<String> PlayersWaiting;
    public static ArrayList<String> PlayersPlaying;

    //TEAMS
    public static ArrayList<String> Boomers;
    public static ArrayList<String> Clowns;
    public static ArrayList<String> Nerds;
    public static ArrayList<String> Mutants;
    public static ArrayList<String> Cripples;
    public static ArrayList<String> Underdogs;
    public static ArrayList<String> Gamers;


    static {
        Main.fm = FileManager.getInstance();
        Main.PlayersWaiting = new ArrayList<String>();
        Main.PlayersPlaying = new ArrayList<String>();

        //TEAMS
        Main.Boomers = new ArrayList<String>();
        Main.Clowns = new ArrayList<String>();
        Main.Nerds = new ArrayList<String>();
        Main.Mutants = new ArrayList<String>();
        Main.Cripples = new ArrayList<String>();
        Main.Underdogs = new ArrayList<String>();
        Main.Gamers = new ArrayList<String>();
    }

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
        GameEvents.gameStarted = false;
        new BukkitRunnable() {
            public void run() {
                for (final Player player : Bukkit.getOnlinePlayers()) {
                    if (!GameEvents.gameStarted) {
                        Scoreboard.updateLobbyScoreboard(player);
                    } else if (GameEvents.gameStarted) {
                        // remove lobby scoreboard
                        // add game scoreboard
                        // this might cancel tho
                    }
                }
            }
        }.runTaskTimer((Plugin) this, 20L, 20L);

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
        this.getServer().getPluginManager().registerEvents(new BlockNextToBedEvent(), this);
        this.getServer().getPluginManager().registerEvents(new DestroyBedEvent(), this);
        this.getServer().getPluginManager().registerEvents(new GameEvents(), this);
        this.getServer().getPluginManager().registerEvents(new FriendlyFireListener(), this);

    }

    public void registerCommands() {
        getCommand("info").setExecutor(new InfoCommand());
        getCommand("cube").setExecutor(new CubeCommand());
        getCommand("removebed").setExecutor(new RemoveBedCommand());
        getCommand("rules").setExecutor(new RulesCommand());
        getCommand("gameplay").setExecutor(new GameplayCommand());
        getCommand("modifier").setExecutor(new ModifierCommand());
        getCommand("game").setExecutor(new GameCommand());
        getCommand("deathmatch").setExecutor(new DeathmatchCommand());
    }

    public void addDefault(final String s1, final String s2) {
        if (Main.fm.getConfig().get(s1) == null) {
            Main.fm.getConfig().set(s1, (Object)s2);
            Main.fm.saveConfig();
        }
    }

    public void addDefault(final String s1, final int s2) {
        if (Main.fm.getConfig().get(s1) == null) {
            Main.fm.getConfig().set(s1, (Object)s2);
            Main.fm.saveConfig();
        }
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

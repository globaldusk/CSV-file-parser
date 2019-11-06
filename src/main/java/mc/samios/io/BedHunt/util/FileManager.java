package mc.samios.io.BedHunt.util;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class FileManager {

    File tfile;
    FileConfiguration teams;
    File cfile;
    FileConfiguration config;
    static FileManager instance;

    static {
        FileManager.instance = new FileManager();
    }

    public static FileManager getInstance() {
        return FileManager.instance;
    }

    public void setup(final Plugin p) {
        if (!p.getDataFolder().exists()) {
            p.getDataFolder().mkdir();
        }
        this.tfile = new File(p.getDataFolder(), "teams.yml");
        if (!this.tfile.exists()) {
            try {
                this.tfile.createNewFile();
            }
            catch (IOException e) {
                p.getLogger().severe("§cCould not create teams.yml!");
            }
        }
        this.teams = (FileConfiguration)YamlConfiguration.loadConfiguration(this.tfile);
        this.cfile = new File(p.getDataFolder(), "config.yml");
        if (!this.cfile.exists()) {
            try {
                this.cfile.createNewFile();
            }
            catch (IOException e) {
                p.getLogger().severe("§cCould not create config.yml!");
            }
        }
        this.config = (FileConfiguration) YamlConfiguration.loadConfiguration(this.cfile);
    }

    public FileConfiguration getTeams() {
        return this.teams;
    }

    public void saveTeams() {
        try {
            this.teams.save(this.tfile);
        }
        catch (IOException e) {
            Bukkit.getLogger().severe("§cCould not save teams.yml!");
        }
    }

    public void reloadTeams() {
        this.teams = (FileConfiguration)YamlConfiguration.loadConfiguration(this.tfile);
    }

    public FileConfiguration getConfig() {
        return this.config;
    }

    public void saveConfig() {
        try {
            this.config.save(this.cfile);
        }
        catch (IOException e) {
            Bukkit.getLogger().severe("§cCould not save config.yml!");
        }
    }
}

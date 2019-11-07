package mc.samios.io.BedHunt.team;

import mc.samios.io.BedHunt.util.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.List;

public class Team {

    private FileManager fm;
    private String name;

    public Team(final String name) {
        this.fm = FileManager.getInstance();
        if (this.fm.getTeams().get(String.valueOf(name) + ".ff") == null) {
            return;
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getMemberList() {
        return (List<String>)this.fm.getTeams().getStringList(String.valueOf(this.name) + ".memberlist");
    }

    public int getCapacity() {
        return this.getMemberList().size();
    }

    public boolean friendlyFire() {
        return this.fm.getTeams().getString(String.valueOf(this.name) + ".ff").equalsIgnoreCase("true");
    }

    public Location getBedLocation() {
        final double x = this.fm.getTeams().getDouble(String.valueOf(this.name) + ".bl.x");
        final double y = this.fm.getTeams().getDouble(String.valueOf(this.name) + ".bl.y");
        final double z = this.fm.getTeams().getDouble(String.valueOf(this.name) + ".bl.z");
        final float yaw = (float)this.fm.getTeams().getInt(String.valueOf(this.name) + ".bl.yaw");
        final float pitch = (float)this.fm.getTeams().getInt(String.valueOf(this.name) + ".bl.pitch");
        final String world = this.fm.getTeams().getString(String.valueOf(this.name) + ".bl.world");
        return new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
    }

}

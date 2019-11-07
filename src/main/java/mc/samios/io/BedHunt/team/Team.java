package mc.samios.io.BedHunt.team;

import mc.samios.io.BedHunt.Main;
import mc.samios.io.BedHunt.util.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

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



    public static void teamsort(){

        float calc = (float)(Main.PlayersPlaying.size() / 2);
        int cap = (int)calc;
        int teamsActive = 0;
        boolean assigned = false;

        for (int assign = 0; assign < Main.PlayersPlaying.size(); assign++)
        {
            Random rand = new Random();
            int TeamSelector = 0;
            assigned = false;

            String p = Main.PlayersPlaying.get(assign);
            //Bukkit.broadcastMessage(p);
            //Bukkit.broadcastMessage(Main.PlayersPlaying.toString());
            while (!assigned){
                TeamSelector = rand.nextInt(7);
                if (TeamSelector == 1 && Main.Boomers.size() < 2){
                    if (teamsActive == cap ){
                        if (Main.Boomers.size() > 0){
                            Main.Boomers.add(p);
                            assigned = true;
                            Bukkit.broadcastMessage(p+" is on the Boomers team");
                        }
                    }
                    else{
                        teamsActive += 1;
                        Main.Boomers.add(p);
                        assigned = true;
                        Bukkit.broadcastMessage(p+" is on the Boomers team");
                    }
                }

                if (TeamSelector == 2 && Main.Clowns.size() < 2){
                    if (teamsActive == cap ){
                        if (Main.Clowns.size() > 0){
                            Main.Clowns.add(p);
                            assigned = true;
                            Bukkit.broadcastMessage(p+" is on the Clowns team");
                        }
                    }
                    else{
                        teamsActive += 1;
                        Main.Clowns.add(p);
                        assigned = true;
                        Bukkit.broadcastMessage(p+" is on the Clowns team");
                    }
                }
                if (TeamSelector == 3 && Main.Mutants.size() < 2){
                    if (teamsActive == cap ){
                        if (Main.Mutants.size() > 0){
                            Main.Mutants.add(p);
                            assigned = true;
                            Bukkit.broadcastMessage(p+" is on the Mutants team");
                        }
                    }
                    else{
                        teamsActive += 1;
                        Main.Mutants.add(p);
                        assigned = true;
                        Bukkit.broadcastMessage(p+" is on the Mutants team");
                    }
                }
                if (TeamSelector == 4 && Main.Gamers.size() < 2){
                    if (teamsActive == cap ){
                        if (Main.Gamers.size() > 0){
                            Main.Gamers.add(p);
                            assigned = true;
                            Bukkit.broadcastMessage(p+" is on the Gamers team");
                        }
                    }
                    else{
                        teamsActive += 1;
                        Main.Gamers.add(p);
                        assigned = true;
                        Bukkit.broadcastMessage(p+" is on the Gamers team");
                    }
                }
                if (TeamSelector == 5 && Main.Nerds.size() < 2){
                    if (teamsActive == cap ){
                        if (Main.Nerds.size() > 0){
                            Main.Nerds.add(p);
                            assigned = true;
                            Bukkit.broadcastMessage(p+" is on the Nerds team");
                        }
                    }
                    else{
                        teamsActive += 1;
                        Main.Nerds.add(p);
                        assigned = true;
                        Bukkit.broadcastMessage(p+" is on the Nerds team");
                    }
                }
                if (TeamSelector == 6 && Main.Cripples.size() < 2){
                    if (teamsActive == cap ){
                        if (Main.Cripples.size() > 0){
                            Main.Cripples.add(p);
                            assigned = true;
                            Bukkit.broadcastMessage(p+" is on the Cripples team");
                        }
                    }
                    else{
                        teamsActive += 1;
                        Main.Cripples.add(p);
                        assigned = true;
                        Bukkit.broadcastMessage(p+" is on the Cripples team");
                    }
                }
                if (TeamSelector == 7 && Main.Underdogs.size() < 2){
                    if (teamsActive == cap ){
                        if (Main.Underdogs.size() > 0){
                            Main.Underdogs.add(p);
                            assigned = true;
                            Bukkit.broadcastMessage(p+" is on the Underdogs team");
                        }
                    }
                    else{
                        teamsActive += 1;
                        Main.Underdogs.add(p);
                        assigned = true;
                        Bukkit.broadcastMessage(p+" is on the Underdogs team");
                    }
                }
            }
        }
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

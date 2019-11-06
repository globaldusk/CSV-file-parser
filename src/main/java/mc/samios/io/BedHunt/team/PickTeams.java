package mc.samios.io.BedHunt.team;

import java.util.List;

public class PickTeams {

    private static final String TEAMS = "src/main/resources/teamsDB.yml";

    public PickTeams(List<String> list) {
        this.list = list;
    }

    private static List<String> list = null;

    public static String pick(int teams) {
        return list.get(pickRandomNumber(teams));
    }

    private static int pickRandomNumber(int max) {
        return (int) (Math.random() * max);
    }
}

package mc.samios.io.BedHunt.util;

import net.md_5.bungee.api.ChatColor;

public class C {

    public static final char COLOR_CHAR = '§';
    public static final String bold = "§l";
    public static final String strike = "§m";
    public static final String underline = "§n";
    public static final String magic = "§k";
    public static final String italic = "§o";
    public static final String reset = "§r";
    public static final String black = "§0";
    public static final String darkBlue = "§1";
    public static final String darkGreen = "§2";
    public static final String darkAqua = "§3";
    public static final String darkRed = "§4";
    public static final String darkPurple = "§5";
    public static final String gold = "§6";
    public static final String gray = "§7";
    public static final String darkGray = "§8";
    public static final String blue = "§9";
    public static final String green = "§a";
    public static final String aqua = "§b";
    public static final String red = "§c";
    public static final String lightPurple = "§d";
    public static final String yellow = "§e";
    public static final String white = "§f";

    public static String replaceColors(final String colorless) {
        return ChatColor.translateAlternateColorCodes('&', colorless);
    }

    public static String error(final String prefix, final String msg) {
        return "§c" + prefix + "» " + "§e" + replaceColors(msg);
    }

    public static String prefix(final String prefix, final String msg) {
        return "§b" + prefix + "» " + "§e" + replaceColors(msg);
    }

    public static String staff(final String prefix, final String msg) {
        return "§6" + prefix + "» " + "§b" + replaceColors(msg);
    }
}


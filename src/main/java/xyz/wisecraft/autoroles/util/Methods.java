package xyz.wisecraft.autoroles.util;

import org.bukkit.Bukkit;
import org.bukkit.advancement.Advancement;

public class Methods {

    public static boolean isProgNull(Advancement a) {
        if (a == null) {
            Bukkit.getConsoleSender().sendMessage("The WiseCraft datapack isn't installed");
            return false;
        }
        return true;
    }

}

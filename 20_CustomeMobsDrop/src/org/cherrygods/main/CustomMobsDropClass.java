package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.listeners.CustomMobsDropListener;
import org.cherrygods.utils.CustomMobsDropPrefix;

/**
 * @author CherrGods
 * @since 2018-4-23 13:45:42
 */
public class CustomMobsDropClass extends JavaPlugin {
    private CustomMobsDropPrefix getPrefix;
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Disable");
        super.onDisable();
    }

    @Override
    public void onEnable() {
        getPrefix = new CustomMobsDropPrefix();
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Enable");
        getServer().getPluginManager().registerEvents(new CustomMobsDropListener(),this);
        super.onEnable();
    }
}

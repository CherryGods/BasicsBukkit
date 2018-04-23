package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.listeners.CustomScoreboardsListener;
import org.cherrygods.utils.CustomScoreboardsPrefix;

/**
 * @author CherrGods
 * @since 2018-4-23 21:54:19
 */
public class CustomScoreboardsClass extends JavaPlugin {
    private CustomScoreboardsPrefix getPrefix;
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Disable");
        super.onDisable();
    }

    @Override
    public void onEnable() {
        getPrefix = new CustomScoreboardsPrefix();
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Enable");
        getServer().getPluginManager().registerEvents(new CustomScoreboardsListener(),this);
        super.onEnable();
    }
}

package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.listeners.PlayerHeadListener;
import org.cherrygods.utils.PlayerHeadPrefix;

/**
 * @author CherrGods
 * @since 2018-4-24 14:06:00
 */
public class PlayerHeadClass extends JavaPlugin {
    private PlayerHeadPrefix getPrefix;

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Enable");
        super.onDisable();
    }

    @Override
    public void onEnable() {
        getPrefix = new PlayerHeadPrefix();
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Enable");
        getServer().getPluginManager().registerEvents(new PlayerHeadListener(),this);
        super.onEnable();
    }
}

package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.listeners.EventListener;
import org.cherrygods.utils.KickBanPluginPrefix;

/**
 * @author CherrGods
 * @since 2018-4-22 21:36:34
 */
public class KickBanPluginClass extends JavaPlugin {
    private KickBanPluginPrefix getPrefix;
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Enable");
        super.onDisable();
    }

    @Override
    public void onEnable() {
        getPrefix = new KickBanPluginPrefix();
        getServer().getPluginManager().registerEvents(new EventListener(),this);
        loadConfig();
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Enable");
        super.onEnable();
    }
    public void loadConfig(){
        getPrefix = new KickBanPluginPrefix();
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been loaded config");
    }
}

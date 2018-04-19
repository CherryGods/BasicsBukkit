package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.listeners.EventListener;

/**
 * @author CherrGods
 * @since 2018-4-18 20:31:50
 */
public class CustomFireWorkClass extends JavaPlugin {
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "CustomFireWorkClass >> "
                +ChatColor.YELLOW+"Plugin has been Disable");
    }

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "CustomFireWorkClass >> "
                +ChatColor.YELLOW+"Plugin has been Enable");
        loadConfig();
        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "CustomFireWorkClass >> "
                +ChatColor.YELLOW+"Config has been Loaded");
    }
}

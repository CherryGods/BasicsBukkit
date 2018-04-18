package org.cherrygods.main;

import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.listeners.EventClass;

/**
 * @author CherrGods
 * @since 2018-4-18 11:49:02
 */
public class CustomItemsClass extends JavaPlugin {
    @Override
    public void onDisable() {
        getLogger().info("CustomItems has been Disable");
    }

    @Override
    public void onEnable() {
        getLogger().info("CustomItems has been Enable");
        loadConfig();
        getServer().getPluginManager().registerEvents(new EventClass(), this);
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}

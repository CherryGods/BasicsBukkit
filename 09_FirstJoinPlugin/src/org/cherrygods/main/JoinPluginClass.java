package org.cherrygods.main;

import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.listeners.EventListener;

/**
 * @author CherrGods
 * @since 2018-4-18 15:33:59
 */
public class JoinPluginClass extends JavaPlugin {
    @Override
    public void onDisable() {
        getLogger().info("JoinPluginClass has been Disable");
    }

    @Override
    public void onEnable() {
        getLogger().info("JoinPluginClass has been Enable");
        loadConfig();
        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}

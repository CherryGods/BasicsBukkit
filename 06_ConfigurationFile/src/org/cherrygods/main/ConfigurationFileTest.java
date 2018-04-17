package org.cherrygods.main;

import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.listeners.EventClass;

/**
 * @author CherrGods
 * @since 2018-4-17 17:41:32
 */
public class ConfigurationFileTest extends JavaPlugin {
    @Override
    public void onDisable(){
        getLogger().info("ConfigurationFile has been Disable");
    }
    @Override
    public void onEnable(){
        getLogger().info("ConfigurationFile has been Enable");
        loadConfig();
        getServer().getPluginManager().registerEvents(new EventClass(),this);
    }
    public void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}

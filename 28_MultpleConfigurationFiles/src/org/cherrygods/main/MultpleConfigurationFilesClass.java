package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.utils.ConfigurationManager;

public class MultpleConfigurationFilesClass extends JavaPlugin {
    private ConfigurationManager cm;
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN+getName()+" >> "+ChatColor.AQUA+"has been Disable");
        super.onDisable();
    }

    @Override
    public void onEnable() {
        loadConfigManager();
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN+getName()+" >> "+ChatColor.AQUA+"has been Enable");
        loadConfig();
        super.onEnable();
    }
    public void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }
    public void loadConfigManager(){
        cm = new ConfigurationManager();
        cm.setupConfig();
        cm.savePlayers();
        cm.reloadPlyaers();
    }
}

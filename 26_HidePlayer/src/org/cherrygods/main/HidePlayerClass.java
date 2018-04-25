package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author CherrGods
 * @CherrGods : I am so sad;
 */
public class HidePlayerClass extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN+getName()+" >> "+ChatColor.AQUA+"has been Enable");
        loadConfig();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN+getName()+" >> "+ChatColor.AQUA+"has been Disable");
        super.onDisable();
    }
    public void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }
}

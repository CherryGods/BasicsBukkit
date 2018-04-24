package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.listeners.AntiCurseListener;

public class AntiCurseClass extends JavaPlugin {
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(
                ChatColor.GREEN + getName() + " >> "
                        + ChatColor.AQUA + "has been Disable!"
        );
        super.onDisable();
    }

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(
                ChatColor.GREEN + getName() + " >> "
                        + ChatColor.AQUA + "has been Enable!"
        );
        getServer().getPluginManager().registerEvents(new AntiCurseListener(),this);
        loadConfig();
        super.onEnable();
    }
    public void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }
}

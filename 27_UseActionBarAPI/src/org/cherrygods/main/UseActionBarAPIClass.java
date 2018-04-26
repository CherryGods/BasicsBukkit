package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.listeners.PlayerBreakBlockListener;

/**
 * @author CherrGods
 * @since 2018-04-26 10:26:21
 */
public class UseActionBarAPIClass extends JavaPlugin {
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN+getName()+" >> "
                +ChatColor.AQUA+"has been Enable");
    }

    @Override
public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN+getName()+" >> "
                +ChatColor.AQUA+"has been Enable");
        getServer().getPluginManager().registerEvents(new PlayerBreakBlockListener(),this);
    }
}

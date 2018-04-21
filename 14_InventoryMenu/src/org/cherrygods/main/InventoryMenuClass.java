package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.listeners.EventListener;
import org.cherrygods.utils.GetPrefix;

/**
 * @author CherrGods
 * @since 2018-4-21 09:37:12
 */
public class InventoryMenuClass extends JavaPlugin {
    private GetPrefix getPrefix;
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Disable");
    }

    @Override
    public void onEnable() {
        getPrefix = new GetPrefix();
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Enable");
        getServer().getPluginManager().registerEvents(new EventListener(),this);
    }
}

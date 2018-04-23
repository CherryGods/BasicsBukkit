package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.listeners.ItemBoomListener;
import org.cherrygods.utils.ItemBoomPrefix;

/**
 * @author CherrGods
 * @since 2018-4-23 11:47:30
 */
public class ItemBoomClass extends JavaPlugin {
    private ItemBoomPrefix getPrefix;
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Disable");
        super.onDisable();
    }

    @Override
    public void onEnable() {
        getPrefix = new ItemBoomPrefix();
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Enable");
        getServer().getPluginManager().registerEvents(new ItemBoomListener(),this);
        super.onEnable();
    }
}

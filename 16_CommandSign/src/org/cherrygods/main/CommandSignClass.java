package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.listeners.EventListener;
import org.cherrygods.utils.CommandSignPrefix;

/**
 * @author CherrGods
 * @since 2018-4-22 20:59:09
 */
public class CommandSignClass extends JavaPlugin {
    private CommandSignPrefix getPrefix;
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Disable");
        super.onDisable();
    }

    @Override
    public void onEnable() {
        getPrefix = new CommandSignPrefix();
        getServer().getPluginManager().registerEvents(new EventListener(),this);
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Enable");
        super.onEnable();
    }
}

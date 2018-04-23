package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.utils.RunnablePluginPrefix;

/**
 * @author CherrGods
 * @since
 */
public class RunnablePluginClass extends JavaPlugin implements Listener {
    private RunnablePluginPrefix getPrefix;
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Disable");
        super.onDisable();
    }

    @Override
    public void onEnable() {
        getPrefix = new RunnablePluginPrefix();
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Enable");
        super.onEnable();
    }
}

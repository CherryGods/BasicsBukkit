package org.cherrygods.utils;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.cherrygods.main.RunnablePluginClass;

/**
 * @author CherrGods
 * @since 2018-4-23 10:41:05
 */
public class RunnablePluginPrefix {
    private Plugin plugin = RunnablePluginClass.getPlugin(RunnablePluginClass.class);
    /**
     * serverPrefix:服务器里的插件前缀
     * cmdPrefix:控制台里的插件前缀
     */
    public String serverPrefix = ChatColor.GREEN + plugin.getName() + " >> ";
    public String cmdPrefix = ChatColor.AQUA + plugin.getName() + " >> ";
}


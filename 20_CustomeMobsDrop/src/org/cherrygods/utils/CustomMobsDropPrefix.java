package org.cherrygods.utils;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.cherrygods.main.CustomMobsDropClass;

/**
 * @author CherrGods
 * @since 2018-4-23 13:45:24
 */
public class CustomMobsDropPrefix {
    private Plugin plugin = CustomMobsDropClass.getPlugin(CustomMobsDropClass.class);
    /**
     * serverPrefix:服务器里的插件前缀
     * cmdPrefix:控制台里的插件前缀
     */
    public String serverPrefix = ChatColor.GREEN + plugin.getName() + " >> ";
    public String cmdPrefix = ChatColor.AQUA + plugin.getName() + " >> ";
}

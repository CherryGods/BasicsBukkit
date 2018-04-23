package org.cherrygods.utils;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.cherrygods.main.CustomScoreboardsClass;

public class CustomScoreboardsPrefix {
    private Plugin plugin = CustomScoreboardsClass.getPlugin(CustomScoreboardsClass.class);
    /**
     * serverPrefix:服务器里的插件前缀
     * cmdPrefix:控制台里的插件前缀
     */
    public String serverPrefix = ChatColor.GREEN + plugin.getName() + " >> ";
    public String cmdPrefix = ChatColor.AQUA + plugin.getName() + " >> ";
}

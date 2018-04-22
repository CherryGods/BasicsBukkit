package org.cherrygods.utils;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.cherrygods.main.TeleportingWarpingClass;

/**
 * @author CherrGods
 * @since 2018-4-22 00:17:36
 *
 */
public class TeleportingWarpingPrefix {
    public Plugin plugin = TeleportingWarpingClass.getPlugin(TeleportingWarpingClass.class);
    /**
     * serverPrefix:服务器里的插件前缀
     * cmdPrefix:控制台里的插件前缀
     */
    public String serverPrefix = ChatColor.GREEN + plugin.getName() + " >> ";
    public String cmdPrefix = ChatColor.AQUA + plugin.getName() + " >> ";
}

package org.cherrygods.utils;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.cherrygods.main.KickBanPluginClass;

/**
 * @author CherrGods
 * @since 2018-4-22 21:37:16
 */
public class KickBanPluginPrefix {
    public Plugin plugin = KickBanPluginClass.getPlugin(KickBanPluginClass.class);
    /**
     * serverPrefix:服务器里的插件前缀
     * cmdPrefix:控制台里的插件前缀
     */
    public String serverPrefix = ChatColor.GREEN + plugin.getName() + " >> ";
    public String cmdPrefix = ChatColor.AQUA + plugin.getName() + " >> ";
}

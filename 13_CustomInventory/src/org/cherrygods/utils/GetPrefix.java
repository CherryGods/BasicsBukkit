package org.cherrygods.utils;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.cherrygods.main.CustomInventoryClass;

/**
 * @author CherrGods
 * @since 2018-4-20 17:30:25
 */
public class GetPrefix {
    public Plugin plugin = CustomInventoryClass.getPlugin(CustomInventoryClass.class);
    /**
     * serverPrefix:服务器里的插件前缀
     * cmdPrefix:控制台里的插件前缀
     */
    public String serverPrefix = ChatColor.GREEN + plugin.getName() + " >> ";
    public String cmdPrefix = ChatColor.AQUA + plugin.getName() + " >> ";
}

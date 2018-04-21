package org.cherrygods.utils;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.cherrygods.main.InventoryMenuClass;

/**
 * 工具类
 * @author CherrGods
 * @since 2018-4-21 09:37:44
 */
public class GetPrefix {
    public Plugin plugin = InventoryMenuClass.getPlugin(InventoryMenuClass.class);
    /**
     * serverPrefix:服务器里的插件前缀
     * cmdPrefix:控制台里的插件前缀
     */
    public String serverPrefix = ChatColor.GREEN + plugin.getName() + " >> ";
    public String cmdPrefix = ChatColor.AQUA + plugin.getName() + " >> ";
}

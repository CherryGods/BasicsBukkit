package org.cherrygods.utils;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.cherrygods.main.ItemBoomClass;

public class ItemBoomPrefix {
    private Plugin plugin = ItemBoomClass.getPlugin(ItemBoomClass.class);
    /**
     * serverPrefix:服务器里的插件前缀
     * cmdPrefix:控制台里的插件前缀
     */
    public String serverPrefix = ChatColor.GREEN + plugin.getName() + " >> ";
    public String cmdPrefix = ChatColor.AQUA + plugin.getName() + " >> ";
}

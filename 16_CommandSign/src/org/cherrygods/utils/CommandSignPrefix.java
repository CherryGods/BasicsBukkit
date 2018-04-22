package org.cherrygods.utils;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.cherrygods.main.CommandSignClass;

/**
 * @author CherrGods
 * @since 2018-4-22 20:59:40
 */
public class CommandSignPrefix {
    public Plugin plugin = CommandSignClass.getPlugin(CommandSignClass.class);
    /**
     * serverPrefix:服务器里的插件前缀
     * cmdPrefix:控制台里的插件前缀
     */
    public String serverPrefix = ChatColor.GREEN + plugin.getName() + " >> ";
    public String cmdPrefix = ChatColor.AQUA + plugin.getName() + " >> ";
}

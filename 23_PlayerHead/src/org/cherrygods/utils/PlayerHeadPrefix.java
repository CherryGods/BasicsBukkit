package org.cherrygods.utils;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.cherrygods.main.PlayerHeadClass;

public class PlayerHeadPrefix {
    private Plugin plugin = PlayerHeadClass.getPlugin(PlayerHeadClass.class);
    public String cmdPrefix = ChatColor.GREEN+plugin.getName()+" >> ";
    public String serverPrefix = ChatColor.AQUA+plugin.getName()+" >> ";
}

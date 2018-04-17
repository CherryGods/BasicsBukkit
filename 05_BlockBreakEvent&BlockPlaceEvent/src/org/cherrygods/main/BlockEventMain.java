package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.listeners.BlockEventClass;

/**
 * @author CherrGods
 * @since 2018-4-17 13:20:58
 */
public class BlockEventMain extends JavaPlugin {
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW+"BlockEventClass has been Disable");
    }

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.BLUE+"BlockEventClass has been Enable");
        getServer().getPluginManager().registerEvents(new BlockEventClass(),this);
    }
}

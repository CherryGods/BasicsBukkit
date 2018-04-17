package org.cherrygods.mian;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.listeners.PlayerInteract_Event;

public class PlayerInteractEvent extends JavaPlugin {
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW+"PlayerInteractEvent has been Disable");
    }

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.BLUE+"PlayerInteractEvent has been Enable");
        getServer().getPluginManager().registerEvents(new PlayerInteract_Event(),this);
    }
}

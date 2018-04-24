package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.listeners.CustomBookListeners;

/**
 * @author CherrGods
 * @since 2018-4-24 16:30:38
 */
public class CustomBookClass extends JavaPlugin {
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(
                ChatColor.GREEN + getName() + " >> "
                        + ChatColor.AQUA + "has been Disable!"
        );
        super.onDisable();
    }

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(
                ChatColor.GREEN + getName() + " >> "
                        + ChatColor.AQUA + "has been Enable!"
        );
        getServer().getPluginManager().registerEvents(new CustomBookListeners(),this);
        super.onEnable();
    }
}

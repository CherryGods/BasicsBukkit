package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.commands.CustomInventoryCommand;
import org.cherrygods.listeners.EventListener;
import org.cherrygods.utils.GetPrefix1;

/**
 * @author CherrGods
 * @since 2018-4-21 09:37:12
 */
public class InventoryMenuClass extends JavaPlugin {
    private GetPrefix1 getPrefix1;
    private CustomInventoryCommand customInventoryCommand;
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(getPrefix1.cmdPrefix+ChatColor.AQUA+"has been Disable");
    }

    @Override
    public void onEnable() {
        customInventoryCommand = new CustomInventoryCommand();
        getPrefix1 = new GetPrefix1();
        getCommand(customInventoryCommand.cmd).setExecutor(customInventoryCommand);
        getServer().getConsoleSender().sendMessage(getPrefix1.cmdPrefix+ChatColor.AQUA+"has been Enable");
        getServer().ge tPluginManager().registerEvents(new EventListener(),this);
    }
}

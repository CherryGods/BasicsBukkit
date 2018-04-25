package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.commands.HideHelpCommand;
import org.cherrygods.commands.HidePlayerCommand;

/**
 * @author CherrGods
 * @CherrGods : I am so sad;
 */
public class HidePlayerClass extends JavaPlugin {
    @Override
    public void onEnable() {
        HidePlayerCommand hidePlayerCommand = new HidePlayerCommand();
        HideHelpCommand hideHelpCommand = new HideHelpCommand();
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + getName() + " >> " + ChatColor.AQUA + "has been Enable");
        getCommand(hidePlayerCommand.cmd1).setExecutor(hidePlayerCommand);
        getCommand(hidePlayerCommand.cmd2).setExecutor(hidePlayerCommand);
        getCommand(hideHelpCommand.cmd1).setExecutor(hideHelpCommand);
        loadConfig();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + getName() + " >> " + ChatColor.AQUA + "has been Disable");
        super.onDisable();
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }
}

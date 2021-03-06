package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.commands.WarpCommand;
import org.cherrygods.utils.TeleportingWarpingPrefix;

/**
 * @author CherrGods
 * @since 2018-4-22 00:15:36
 */
public class TeleportingWarpingClass extends JavaPlugin {
    private TeleportingWarpingPrefix getPrefix;
    private WarpCommand warpCommand;
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Disable");

    }

    @Override
    public void onEnable() {
        getPrefix = new TeleportingWarpingPrefix();
        warpCommand = new WarpCommand();
        loadConfig();
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Enable");
        getCommand(warpCommand.warpCommand).setExecutor(warpCommand);
        getCommand(warpCommand.setWarpCommand).setExecutor(warpCommand);
        super.onEnable();
    }
    public void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"Config has been loaded");
    }
}

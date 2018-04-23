package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.commands.MobCommand;
import org.cherrygods.utils.CustomMobPrefix;

/**
 * @author CherrGods
 * @since 2018-4-23 16:32:20
 */
public class CustomMobClass extends JavaPlugin {
    private CustomMobPrefix getPrefix;
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Enable");
        super.onDisable();
    }

    @Override
    public void onEnable() {
        MobCommand mobCommand = new MobCommand();
        getCommand(mobCommand.cmd1).setExecutor(mobCommand);
        getPrefix = new CustomMobPrefix();
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Enable");
        super.onEnable();
    }
}

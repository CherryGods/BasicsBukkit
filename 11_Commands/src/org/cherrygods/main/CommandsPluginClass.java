package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.commands.GiveItemCommand;
import org.cherrygods.listeners.EventListener;
import org.cherrygods.utils.GetPrefix;

/**
 * @author CherrGods
 * @since 2018-4-19 13:47:55
 */
public class CommandsPluginClass extends JavaPlugin {
    private GiveItemCommand gic = new GiveItemCommand();
    private GetPrefix prefix = null;
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(
                ChatColor.YELLOW+"Plugin has been Disable");
    }

    @Override
    public void onEnable() {
        //必须放这里new，放外面new数据加载不到服务器里，就会造成空指针NullPotionException
        prefix = new GetPrefix();
        //prefix.cmdPrefix
        getServer().getConsoleSender().sendMessage(prefix.cmdPrefix+ChatColor.YELLOW+"Plugin has been Enable");
        loadConfig();

        getServer().getPluginManager().registerEvents(new EventListener(), this);

        getCommand(gic.cmd1).setExecutor(gic);
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        getServer().getConsoleSender().sendMessage(prefix.cmdPrefix+ChatColor.YELLOW+"Config has been Loaded");
    }
}

package org.cherrygods.main;

import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.listeners.PlayerMove_Event;

/**
 * 插件入口类
 * @author CherrGods
 * @since 2018-4-16 17:34:07
 */
public class PlayerMoveEvent extends JavaPlugin {
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("PlayerMoveEvent has been Disable ^_^");
    }

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("PlayerMoveEvent has been Enable ^_^");
        getServer().getPluginManager().registerEvents(new PlayerMove_Event(),this);
    }
}

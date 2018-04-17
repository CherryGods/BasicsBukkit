package org.cherrygods.main;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.listeners.PlayerMove;

/**
 * @author CherrGods
 * @since 2018-4-16 13:29:22
 */
public class RegisterEvents extends JavaPlugin {
    @Override
    public void onLoad() {

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW+"RegisterEvents has been Disable ^_^");
    }

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(org.bukkit.ChatColor.BLUE +"RegisterEvents has been Enable ^_^");
        registerEvents();
    }

    /***
     * 存放注册监听器代码
     * 可不写此方法，把代码放onEnable就好了
     */
    public void registerEvents(){
        getServer().getPluginManager().registerEvents(new PlayerMove(),this);
    }
}

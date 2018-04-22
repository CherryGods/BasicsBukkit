package org.cherrygods.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.cherrygods.main.KickBanPluginClass;
import org.cherrygods.utils.KickBanPluginPrefix;

import java.util.UUID;

/**
 * @author CherrGods
 * @since 2018-4-22 21:36:12
 */
public class EventListener implements Listener {
    private KickBanPluginClass plugin = KickBanPluginClass.getPlugin(KickBanPluginClass.class);
    private KickBanPluginPrefix getPrefix = new KickBanPluginPrefix();
    @SuppressWarnings("noting")
    @EventHandler
    public void blockPlace(BlockPlaceEvent event) {
        //获取监听到的方块
        Block block = event.getBlock();
        //获取监听到的玩家
        Player player = event.getPlayer();
        //获取玩家的UUID
        UUID uuid = player.getUniqueId();
        //判断方块是否是TNT
        if (block.getType().equals(Material.TNT)) {
            //设置事件失效
            event.setCancelled(true);
            //拿到玩家被踢出的次数
            int playerKicks = plugin.getConfig().getInt(uuid + ".kicks");
            //拿到玩家被ban的次数
            int playerBanTicks = plugin.getConfig().getInt("KicksTillBan");
            //判断被踢出的次数是否比被ban的次数小
            if (playerKicks < playerBanTicks) {
                //踢出玩家,并且自定义一条消息
                player.kickPlayer(getPrefix.cmdPrefix+ChatColor.RED+"Placing TNT is  not allowed on this server!");
                //设置踢出次数+1
                plugin.getConfig().set(uuid+".kicks",playerKicks+1);
                //保存config
                plugin.saveConfig();
            }else {
                //否则在服务器内执行一条命令,ban掉这个玩家
                plugin.getServer().dispatchCommand(
                        plugin.getServer().getConsoleSender(),"ban"+uuid+" §4You have reached  the Maximum amount of TNT places!");
            }
        }
    }
}

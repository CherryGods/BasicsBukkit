package org.cherrygods.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * @author CherrGods
 * @since 2018-4-17 10:55:55
 */
public class PlayerInteract_Event implements Listener {
    @SuppressWarnings("实现玩家点击绿宝石治疗")
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        //获取本次交互的类型
        Action action = event.getAction();
        //获取监听的玩家
        Player player = event.getPlayer();
        //获取被点击的方块
        Block block = event.getClickedBlock();
        //判断交互类型是否为右击方块
        if (action.equals(Action.RIGHT_CLICK_BLOCK)) {
            //拿到方块类型之后判断是否为绿宝石
            if (block.getType().equals(Material.EMERALD_BLOCK)) {
                //判断玩家的生命中是否小于20
                if (player.getHealth() != 20) {
                    //如果小于20则+1点血
                    player.setHealth(player.getHealth() + 1);
                    player.sendMessage(ChatColor.GOLD + "You has been healed for" + ChatColor.RED + "+1 health!");
                } else {
                    //提示玩家血量是满的
                    player.sendMessage(ChatColor.BLUE + "You have full health!");
                }
            } else {
                //如果不是就提示玩家点击的是什么
                player.sendMessage(ChatColor.GOLD + "You clicked" +
                        ChatColor.RED + block.getType().toString().toUpperCase());
            }
        }
    }
}

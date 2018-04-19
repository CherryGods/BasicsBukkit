package org.cherrygods.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.cherrygods.main.CraftingRewardsClass;
import org.cherrygods.utils.GetPrefix;

/**
 * @author CherrGods
 * @since 2018-4-19 18:00:08
 */
public class EventListener implements Listener {
    private GetPrefix getPrefix;
    private Plugin plugin = CraftingRewardsClass.getPlugin(CraftingRewardsClass.class);
    @EventHandler
    public void craftingReward(CraftItemEvent event){
        getPrefix = new GetPrefix();
        //拿到操作工作台的玩家
        Player player = (Player) event.getWhoClicked();
        //创建一个item,这个item就是被监听到的物品
        ItemStack item = event.getCurrentItem();
        //判断这个物品是否是钻石斧头
        if(item.getType().equals(Material.CHEST)){
            //给予玩家10经验
            player.giveExp(10);
            //给玩家发送消息，增加经验了
            player.sendMessage(getPrefix.serverPrefix
                    +ChatColor.LIGHT_PURPLE + "Your experience rose by: " + ChatColor.GREEN + "10");
            //做一个全服消息，提示某某玩家合成了钻石斧头
            plugin.getServer().broadcastMessage(getPrefix.serverPrefix+ChatColor.YELLOW + player.getName() + ChatColor.LIGHT_PURPLE
                    + " has crafted " + ChatColor.AQUA + item.getType().toString().toUpperCase()+" OF CherryGods");
            //遍历所有在线玩家，并且给玩家们生成一个雷电音效
            for(Player onlinePlayer : plugin.getServer().getOnlinePlayers()){
                onlinePlayer.getWorld().playSound(onlinePlayer.getLocation(),Sound.BLAZE_BREATH,1,1);
            }
        }
    }
}

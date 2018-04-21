package org.cherrygods.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.cherrygods.utils.GetPrefix;

/**
 * @author CherrGods
 * @since 2018-4-21 09:40:56
 */
public class EventListener implements Listener {
    private GetPrefix getPrefix = new GetPrefix();
    @EventHandler
    public void InvenClick(InventoryClickEvent event){
        //拿到点击的玩家
        Player player = (Player) event.getWhoClicked();
        //打开监听到被点击的容器
        Inventory open = event.getClickedInventory();
        //拿到被点击的item
        ItemStack item = event.getCurrentItem();
        //判断玩家点击的是否是监听到的容器
        if(open == null){
            return;
        }
        //判断点击的容器是否是创建的自定义容器
        if(open.getName().equals(ChatColor.DARK_GREEN+"CustomInventory")){
            //设置监听失效
            event.setCancelled(true);
            //判断被点击的item是否为null，并且item是否没有meta
            if(item == null || !item.hasItemMeta()){
                return;
            }
            //判断被点击的item是否是自定义item的health
            if(item.getItemMeta().getDisplayName().equals(ChatColor.RED+"HEALTH")){
                //如果是的话，那么就关闭容器
                player.closeInventory();
                CustomInventory customInventory = new CustomInventory();
                player.setHealth(20);
                customInventory.newInventory(player);
            }
            //判断被点击的item是否是自定义item的food
            if(item.getItemMeta().getDisplayName().equals(ChatColor.RED+"FOOD")){
                //如果是的话，那么就关闭容器
                player.closeInventory();

                CustomInventory customInventory = new CustomInventory();
                player.setFoodLevel(20);
                customInventory.newInventory(player);
            }
        }
    }
}

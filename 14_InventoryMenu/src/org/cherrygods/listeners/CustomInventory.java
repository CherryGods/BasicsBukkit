package org.cherrygods.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.cherrygods.main.InventoryMenuClass;
import org.bukkit.plugin.Plugin;

/**
 * @author CherrGods
 * @since 2018-4-21 09:49:56
 */
public class CustomInventory implements Listener{
    public void newInventory(Player player){
        //创建一个容器
        Inventory inventory = player.getServer().createInventory(null,9,ChatColor.AQUA+"InventoryMenu");
        //定义生命值变量
        int healthInt = (int) player.getHealth();
        //定义饥饿值变量
        int foodInt = player.getFoodLevel();
        //生成一个站位item，具体效果看游戏内
        ItemStack emptyItem = new ItemStack(Material.STAINED_GLASS_PANE,1,(byte)15);
        ItemMeta emptyMeta = emptyItem.getItemMeta();
        emptyMeta.setDisplayName(ChatColor.MAGIC+"啥也没有QAQ");
        emptyItem.setItemMeta(emptyMeta);
        //生成生命值item，具体效果看游戏内
        ItemStack healthItem = new ItemStack(Material.INK_SACK,healthInt,(byte)15);
        ItemMeta healthMeta = healthItem.getItemMeta();
        healthMeta.setDisplayName(ChatColor.RED+"HEALTH");
        healthItem.setItemMeta(healthMeta);
        //生成饥饿值item，具体效果看游戏内
        ItemStack foodItem = new ItemStack(Material.APPLE,foodInt);
        ItemMeta foodMeta = healthItem.getItemMeta();
        foodMeta.setDisplayName(ChatColor.RED+"FOOD");
        foodItem.setItemMeta(foodMeta);
        //设置容器从1-9格内分别是什么物品
        inventory.setItem(0,emptyItem);
        inventory.setItem(1,emptyItem);
        inventory.setItem(2,emptyItem);
        inventory.setItem(3,healthItem);
        inventory.setItem(4,emptyItem);
        inventory.setItem(5,foodItem);
        inventory.setItem(6,emptyItem);
        inventory.setItem(7,emptyItem);
        inventory.setItem(8,emptyItem);
        //打开容器
        player.openInventory(inventory);
    }
}

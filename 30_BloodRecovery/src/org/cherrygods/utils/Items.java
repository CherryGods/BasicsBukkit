package org.cherrygods.utils;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Items {
    public ItemStack getItem(String itemName){
        if(itemName.equalsIgnoreCase("回血书")){
            ItemStack 回血书 = new ItemStack(Material.BOOK, 1);
            ItemMeta meta = 回血书.getItemMeta();
            meta.setDisplayName("§c回血书");
            ArrayList lore = new ArrayList();
            lore.add("§b右键回血，每秒回血1滴血");
            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            回血书.setItemMeta(meta);
            return 回血书;
        }else if (itemName.equalsIgnoreCase("升级宝石")){
            ItemStack 升级宝石 = new ItemStack(Material.DIAMOND,1);
            ItemMeta meta = 升级宝石.getItemMeta();
            meta.setDisplayName("§a升级宝石");
            ArrayList lore = new ArrayList();
            lore.add("§b手持该物品持续加经验,每500毫秒加1经验");
            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            升级宝石.setItemMeta(meta);
            return 升级宝石;
        }
        return null;
    }
}

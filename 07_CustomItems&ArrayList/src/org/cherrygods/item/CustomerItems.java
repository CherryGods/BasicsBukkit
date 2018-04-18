package org.cherrygods.item;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

/**
 * @author CherrGods
 */
public class CustomerItems implements Listener {
    public void getItem(Player player) {
        //创建一个item，类型是钻石斧头
        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        //创建一个meta(也就是item的复制品)
        ItemMeta meta = item.getItemMeta();
        //设置meta的名称
        meta.setDisplayName(ChatColor.AQUA + "AXE OF CherryGods");
        //创建一个List存放Lore
        ArrayList loreList = new ArrayList();
        //设置list的值
        loreList.add(ChatColor.WHITE + "Used by CherryGods in the great gold battle");
        //给这个meta设置Lore
        meta.setLore(loreList);
        //将minecraft自带的lore隐藏
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        //将meta放进item中
        item.setItemMeta(meta);
        //获取玩家背包，并且将item放进玩家背包中
        player.getInventory().addItem(item);
    }
}

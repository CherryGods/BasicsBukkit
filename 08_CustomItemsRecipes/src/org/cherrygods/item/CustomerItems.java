package org.cherrygods.item;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.cherrygods.main.CustomItemsRecipesClass;

import java.util.ArrayList;

/**
 * @author CherrGods
 * @since 2018-4-18 13:31:23
 */
public class CustomerItems implements Listener {
    private Plugin plugin = CustomItemsRecipesClass.getPlugin(CustomItemsRecipesClass.class);

    public void customRecipe() {
        ItemStack item = new ItemStack(Material.DIAMOND_AXE,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "AXE OF CherryGods");
        ArrayList loreList = new ArrayList();
        loreList.add(ChatColor.WHITE + "Used by CherryGods in the great gold battle");
        meta.setLore(loreList);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        //有序自定义合成
        ShapedRecipe sr = new ShapedRecipe(item);
        //设置摆放的位置
        sr.shape("#% ","#$ "," $ ");
        sr.setIngredient('#',Material.DIAMOND);
        sr.setIngredient('%',Material.IRON_INGOT);
        sr.setIngredient('$',Material.STICK);
        //丢进服务器里
        plugin.getServer().addRecipe(sr);
    }
    public void unShaped(){
        ItemStack item = new ItemStack(Material.ENDER_CHEST,1);
        //无序自定义合成
        ShapelessRecipe slr = new ShapelessRecipe(item);
        slr.addIngredient(3,Material.CHEST);
        slr.addIngredient(3,Material.ENDER_PEARL);
        //丢进服务器里
        plugin.getServer().addRecipe(slr);
    }
}

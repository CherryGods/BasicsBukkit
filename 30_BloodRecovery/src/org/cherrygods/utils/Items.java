package org.cherrygods.utils;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Items {
    public ItemStack getItem(String itemName){
        if(itemName.equalsIgnoreCase("��Ѫ��")){
            ItemStack ��Ѫ�� = new ItemStack(Material.BOOK, 1);
            ItemMeta meta = ��Ѫ��.getItemMeta();
            meta.setDisplayName("��c��Ѫ��");
            ArrayList lore = new ArrayList();
            lore.add("��b�Ҽ���Ѫ��ÿ���Ѫ1��Ѫ");
            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            ��Ѫ��.setItemMeta(meta);
            return ��Ѫ��;
        }else if (itemName.equalsIgnoreCase("������ʯ")){
            ItemStack ������ʯ = new ItemStack(Material.DIAMOND,1);
            ItemMeta meta = ������ʯ.getItemMeta();
            meta.setDisplayName("��a������ʯ");
            ArrayList lore = new ArrayList();
            lore.add("��b�ֳָ���Ʒ�����Ӿ���,ÿ500�����1����");
            meta.setLore(lore);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            ������ʯ.setItemMeta(meta);
            return ������ʯ;
        }
        return null;
    }
}

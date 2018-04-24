package org.cherrygods.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class PlayerHeadListener implements Listener {
    @EventHandler
    public void join(PlayerJoinEvent event){
        Player player = event.getPlayer();
        //创建一个item，类型是玩家头颅
        ItemStack playerSkull = new ItemStack(Material.SKULL_ITEM,1,(short)SkullType.PLAYER.ordinal());

        //创建一个头颅
        SkullMeta skullMeta = (SkullMeta)playerSkull.getItemMeta();

        skullMeta.setOwner(player.getName());
        skullMeta.setDisplayName("Player Info");

        playerSkull.setItemMeta(skullMeta);

        player.getInventory().addItem(playerSkull);

        player.sendMessage(ChatColor.DARK_PURPLE+"Please refer  to your heard  for Player Info");

    }
}

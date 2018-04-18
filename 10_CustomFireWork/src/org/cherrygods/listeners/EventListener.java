package org.cherrygods.listeners;


import org.bukkit.*;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.FireworkEffect.*;

import java.util.ArrayList;

/**
 * @author CherrGods
 * @since 2018-4-18 20:33:27
 */
public class EventListener implements Listener {
    private String prefix = (ChatColor.AQUA + "CustomFireWork>> ");

    @EventHandler
    public void onNewPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        //判断玩家是否进入过服务器
        if (!player.hasPlayedBefore()) {
            player.setHealth(1);
            event.setJoinMessage("");
            player.sendMessage(prefix + "Welcome Back" + ChatColor.GOLD + player.getName());
            ItemStack item = new ItemStack(Material.BOOK, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.AQUA + "Welcome Book");
            ArrayList loreList = new ArrayList();
            loreList.add(ChatColor.WHITE + "Read this for instructions and rules");
            meta.setLore(loreList);
            item.setItemMeta(meta);
            player.getInventory().setItem(0, item);
            Location spawn = new Location(player.getWorld(), 155, 70, -17);
            player.teleport(spawn);
            //创建一个FireWork，位置就是上面设置的出生点
            Firework fw = player.getWorld().spawn(player.getLocation(), Firework.class);
            FireworkMeta fwm = fw.getFireworkMeta();
            Builder builder = FireworkEffect.builder();
            //设置FireWork的样式
            fwm.addEffect(builder.flicker(true).withColor(Color.BLUE).build());
            fwm.addEffect(builder.trail(true).build());
            fwm.addEffect(builder.withFade(Color.ORANGE).build());
            fwm.addEffect(builder.with(Type.CREEPER).build());
            //设置FireWork的威力
            fwm.setPower(1);
            fw.setFireworkMeta(fwm);
        }
    }
}

package org.cherrygods.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

/**
 * @author CherrGods
 * @since 2018-4-18 15:49:20
 */
public class EventListener implements Listener {
    private Plugin plugin = Bukkit.getPluginManager().getPlugin("FistJoinPlugin");
    private String prefix = (ChatColor.GREEN + "JoinPlugin >>>");

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        //可以把run()里面的代码翻出来，把↓代码删掉
        Bukkit.getScheduler().runTaskLater(plugin, new BukkitRunnable() {
            @Override
            public void run() {
                Player player = event.getPlayer();
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
            }
        }, 1L);
    }
}



package org.cherrygods.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;

/**
 * @author CherrGods
 * @since 2018-4-24 16:39:29
 */
public class CustomBookListeners implements Listener {
    @EventHandler
    public void join(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(!player.hasPlayedBefore()){
            ItemStack bookItem = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta bookMeta = (BookMeta) bookItem.getItemMeta();
            bookMeta.setAuthor("Admin");
            bookMeta.setDisplayName("Rule Book");
            bookMeta.setTitle("Server Rule");
            ArrayList <String> pages = new ArrayList<String>();
            pages.add("1.Don't place TNT"+"\n"+"2.Don't speak fuck shit ...");
            pages.add("3.Test");
            bookMeta.setPages(pages);
            bookItem.setItemMeta(bookMeta);
            player.getInventory().addItem(bookItem);
        }
    }
}

package org.cherrygods.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import org.cherrygods.main.CustomInventoryClass;

/**
 * @author CherrGods
 * @since 2018-4-20 17:33:27
 */
public class EventListener implements Listener {
    private Plugin plugin = CustomInventoryClass.getPlugin(CustomInventoryClass.class);
    public void newInventory(Player player){
        Inventory inventory = player.getServer().
                createInventory(null,27,ChatColor.DARK_AQUA+"CustomInventory");
        player.openInventory(inventory);
    }
}

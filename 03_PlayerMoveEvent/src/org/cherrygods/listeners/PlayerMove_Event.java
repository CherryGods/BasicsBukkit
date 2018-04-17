package org.cherrygods.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * @author CherrGods
 * @since 2018-4-16 17:33:48
 */
public class PlayerMove_Event implements Listener {
    @SuppressWarnings("玩家移动给金苹果")
    @EventHandler
    public void  onMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        Inventory inventory = player.getInventory();
        ItemStack stack = new ItemStack(Material.GOLDEN_APPLE,1);
        if(!player.isOnGround()){
            player.sendMessage("§b you are running");
            inventory.addItem(stack);
        }
    }
}

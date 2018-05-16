package org.cherrygods.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.cherrygods.main.BloodRecoveryClass;
import org.cherrygods.utils.Items;
import java.util.ArrayList;

/**
 * 实现玩家手拿着回血书就回血
 */
public class BloodRecoveryListener implements Listener {
    private Plugin plugin = BloodRecoveryClass.getPlugin(BloodRecoveryClass.class);
    private Items items = new Items();
    @EventHandler
    public void onPlayerJoinServer(PlayerJoinEvent event){
        for(int i=0;i<event.getPlayer().getInventory().getSize();i++){
            if(!event.getPlayer().getInventory().contains(items.getItem("回血书"))){
                event.getPlayer().getInventory().addItem(items.getItem("回血书"));
            }else if(!event.getPlayer().getInventory().contains(items.getItem("升级宝石"))){
                event.getPlayer().getInventory().addItem(items.getItem("升级宝石"));
            }
        }
    }
}

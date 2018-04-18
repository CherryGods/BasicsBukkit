package org.cherrygods.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.cherrygods.item.CustomerItems;

/**
 * @author CherrGods
 * @since 2018-4-18 12:00:31
 */
public class EventClass implements Listener {
    private CustomerItems ci = new CustomerItems();

    @SuppressWarnings("把监听到的玩家传给ci的getItem方法，进行功能实现")
    @EventHandler
    public void onPunch(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ci.getItem(player);
    }
}

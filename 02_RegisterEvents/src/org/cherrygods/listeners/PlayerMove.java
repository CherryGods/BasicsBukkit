package org.cherrygods.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * @author CherrGods
 * @since 2018-4-16 12:26:52
 */
public class PlayerMove implements Listener {
    /**
     * 玩家移动时事触发的代码(镜头移动也触发)
     */
    @EventHandler
    public void onMove(PlayerMoveEvent event){
        System.out.println(1);

    }
}

package org.cherrygods.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.cherrygods.main.AntiCurseClass;

/**
 * @author CherrGods
 * @since 17点25分
 */
public class AntiCurseListener implements Listener {
    AntiCurseClass ac = AntiCurseClass.getPlugin(AntiCurseClass.class);
    @EventHandler
    public void chatEvent(AsyncPlayerChatEvent event){
        for (String message : event.getMessage().split(" ")){
            if (ac.getConfig().getStringList("KickOutWords").contains(message)){
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.YELLOW+"["+ac.getName()+"] >> "
                        +ChatColor.RED+"Don't curse on this server!");
            }
        }
    }
}

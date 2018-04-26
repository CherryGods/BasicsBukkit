package org.cherrygods.listeners;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.cherrygods.main.UseActionBarAPIClass;

/**
 * @author CherrGods
 * @since 2018-04-26 10:28:27
 */
public class PlayerBreakBlockListener implements Listener {
    private UseActionBarAPIClass plugin = new UseActionBarAPIClass();
    int breakCount = 0;
    @EventHandler
    public void setBreakCount(BlockBreakEvent event){
        Player player = event.getPlayer();
        if(breakCount == 0){
            ActionBarAPI.sendActionBar(player,ChatColor.YELLOW+plugin.getName()+"\n"
                    +ChatColor.LIGHT_PURPLE+"You have broken"+(breakCount+1)+"times of ¡ìb¡ìl"+event.getBlock().getType());
            breakCount++;
            breakCount++;
        }else {
                    ActionBarAPI.sendActionBar(player, ChatColor.YELLOW+plugin.getName()+"\n"
                    +ChatColor.DARK_AQUA + "You have broke " + ChatColor.AQUA
                    + (breakCount++) + ChatColor.DARK_AQUA + " blocks.");
        }

        if (breakCount == 10) {
            ActionBarAPI.sendActionBarToAllPlayers(
                    ChatColor.YELLOW+plugin.getName()+"\n"
                    +ChatColor.GOLD + player.getName() + ChatColor.GREEN + " has broken 10 blocks!");

        }
    }
}

package org.cherrygods.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.cherrygods.utils.CommandSignPrefix;

/**
 * @author CherrGods
 * @since 2018-4-22 21:02:34
 */
public class EventListener implements Listener {
    private CommandSignPrefix getPrefix = new CommandSignPrefix();
    public void signCommand(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Block clickedBlcok = event.getClickedBlock();
        BlockState state = clickedBlcok.getState();
        if(state instanceof Sign){
            Sign sign = (Sign) state;
            String line1 = sign.getLine(0);
            String line2 = sign.getLine(1);
            if(line1.equalsIgnoreCase("[Creative]")){
                sign.setLine(0,ChatColor.LIGHT_PURPLE+"[Creative]");
                sign.update();
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(getPrefix.serverPrefix+ChatColor.YELLOW+"Your gamemode changed to creative");
            }
            if(line1.equalsIgnoreCase("[Survival]")){
                sign.setLine(0,ChatColor.LIGHT_PURPLE+"[Survival]");
                sign.update();
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(getPrefix.serverPrefix+ChatColor.YELLOW+"Your gamemode changed to creative");
            }

        }
    }
}

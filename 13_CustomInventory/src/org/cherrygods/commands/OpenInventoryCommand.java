package org.cherrygods.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cherrygods.listeners.EventListener;
import org.cherrygods.utils.GetPrefix;

/**
 * @author CherrGods
 * @since 2018-4-21 14:22:32
 */
public class OpenInventoryCommand implements CommandExecutor {
    public String openInventory = "openinventory";
    private GetPrefix getPrefix = new GetPrefix();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            if(command.getName().equalsIgnoreCase(openInventory)){
                Player player = (Player) commandSender;
                EventListener eventListener = new EventListener();
                eventListener.newInventory(player);
                return false;
            }
            commandSender.sendMessage(getPrefix+"Only Player can use this command");
            return false;
        }
        return false;
    }
}

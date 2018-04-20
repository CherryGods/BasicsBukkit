package org.cherrygods.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cherrygods.listeners.EventListener;

public class OpenInventoryCommand implements CommandExecutor {
    public String openInventory = "openinventory";
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            if(command.getName().equalsIgnoreCase(openInventory)){
                Player player = (Player) commandSender;
                EventListener eventListener = new EventListener();
                eventListener.newInventory(player);
            }
            return true;
        }
        return false;
    }
}

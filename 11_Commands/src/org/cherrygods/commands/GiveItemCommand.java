package org.cherrygods.commands;

import net.minecraft.server.v1_8_R3.CommandExecute;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.cherrygods.utils.GetPrefix;

/**
 * @author CherrGods
 * @since 2018-4-19 14:05:09
 */
public class GiveItemCommand implements CommandExecutor {
    public String cmd1 = "giveitem";
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender instanceof Player){
            if(command.getName().equalsIgnoreCase(cmd1)){
                if(args.length !=0){
                    Material item = Material.getMaterial(args[0].toUpperCase());
                    if(item != null){
                        Inventory inventory = ((Player)commandSender).getInventory();
                        inventory.addItem(new ItemStack(item,1));
                        return true;
                    }else{
                        //new GetPrefix().serverPrefix+
                        commandSender.sendMessage(new GetPrefix().serverPrefix+
                                ChatColor.YELLOW+args[0]+ChatColor.RED+" is no valid item");
                        return true;
                    }
                }else {
                    commandSender.sendMessage(
                            new GetPrefix().serverPrefix+
                            ChatColor.RED + "Not enough arguments!");
                    return true;
                }
            }
        }else{
            commandSender.sendMessage(
                    new GetPrefix().serverPrefix+
                    ChatColor.RED+"Only player can use the command!");
            return true;
        }

        return false;
    }
}

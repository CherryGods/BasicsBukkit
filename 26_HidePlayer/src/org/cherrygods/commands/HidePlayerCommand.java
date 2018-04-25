package org.cherrygods.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cherrygods.main.HidePlayerClass;

/**
 * @author CherrGods
 */
public class HidePlayerCommand implements CommandExecutor {
    private HidePlayerClass plugin = HidePlayerClass.getPlugin(HidePlayerClass.class);
    public String cmd1="hide";
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            if(command.getName().equalsIgnoreCase(cmd1)){
                for (Player online: Bukkit.getOnlinePlayers()){
                    online.hidePlayer(player);
                }
                return true;
            }
        }else{
            commandSender.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "+ChatColor.RED+"Only players can use this command!");
            return true;
        }
        return false;
    }
}

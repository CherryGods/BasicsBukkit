package org.cherrygods.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cherrygods.main.HidePlayerClass;

/**
 * /hide help
 * @author CherrGods
 */
public class HideHelpCommand implements CommandExecutor {
    private HidePlayerClass plugin = HidePlayerClass.getPlugin(HidePlayerClass.class);
    public String cmd1 = "sh";
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            if(strings.length==1){
                if(command.getName().equalsIgnoreCase(cmd1)){
                    if(strings[0].equalsIgnoreCase("help")){
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "+ChatColor.GOLD+"===========================================");
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> " +ChatColor.LIGHT_PURPLE+"/sh help"+ChatColor.GREEN+"-----查看帮助");
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "
                                +ChatColor.LIGHT_PURPLE+"/sh help"+ChatColor.GREEN+"-----查看帮助.");
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "
                                +ChatColor.LIGHT_PURPLE+"/hide me"+ChatColor.GREEN+"-----隐藏自己.");
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "
                                +ChatColor.LIGHT_PURPLE+"/hide all"+ChatColor.GREEN+"-----屏蔽所有人.");
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "
                                +ChatColor.LIGHT_PURPLE+"/hide player [玩家名称]"+ChatColor.GREEN+"-----屏蔽玩家.");
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "
                                +ChatColor.LIGHT_PURPLE+"/show me"+ChatColor.GREEN+"-----取消屏蔽自己。");
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "
                                +ChatColor.LIGHT_PURPLE+"/show all"+ChatColor.GREEN+"-----取消屏蔽所有人");
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "
                                +ChatColor.LIGHT_PURPLE+"/show player [玩家名称]"+ChatColor.GREEN+"-----取消屏蔽玩家");
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> " +ChatColor.LIGHT_PURPLE+"/sh help"+ChatColor.GREEN+"-----查看帮助");
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "+ChatColor.GOLD+"===========================================");
                        return true;
                    }
                    return true;
                }
            }else{
                player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "
                        +ChatColor.DARK_RED+"你可以输入/<sh> <help>查看帮助！");
                return true;
            }
        }else{
            commandSender.sendMessage(ChatColor.GREEN+plugin.getName()+" >> "
                    +ChatColor.DARK_RED+"你必须是一名玩家！");
            return true;
        }
        return false;
    }
}

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
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> " +ChatColor.LIGHT_PURPLE+"/sh help"+ChatColor.GREEN+"-----�鿴����");
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "
                                +ChatColor.LIGHT_PURPLE+"/sh help"+ChatColor.GREEN+"-----�鿴����.");
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "
                                +ChatColor.LIGHT_PURPLE+"/hide me"+ChatColor.GREEN+"-----�����Լ�.");
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "
                                +ChatColor.LIGHT_PURPLE+"/hide all"+ChatColor.GREEN+"-----����������.");
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "
                                +ChatColor.LIGHT_PURPLE+"/hide player [�������]"+ChatColor.GREEN+"-----�������.");
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "
                                +ChatColor.LIGHT_PURPLE+"/show me"+ChatColor.GREEN+"-----ȡ�������Լ���");
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "
                                +ChatColor.LIGHT_PURPLE+"/show all"+ChatColor.GREEN+"-----ȡ������������");
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "
                                +ChatColor.LIGHT_PURPLE+"/show player [�������]"+ChatColor.GREEN+"-----ȡ���������");
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> " +ChatColor.LIGHT_PURPLE+"/sh help"+ChatColor.GREEN+"-----�鿴����");
                        player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "+ChatColor.GOLD+"===========================================");
                        return true;
                    }
                    return true;
                }
            }else{
                player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "
                        +ChatColor.DARK_RED+"���������/<sh> <help>�鿴������");
                return true;
            }
        }else{
            commandSender.sendMessage(ChatColor.GREEN+plugin.getName()+" >> "
                    +ChatColor.DARK_RED+"�������һ����ң�");
            return true;
        }
        return false;
    }
}

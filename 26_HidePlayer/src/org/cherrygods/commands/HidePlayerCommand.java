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
    public String cmd1 = "hide";
    public String cmd2 = "show";

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (strings.length >= 1) {
                if (command.getName().equalsIgnoreCase(cmd1)) {
//                    判断show下一个指令是否为me
                    if (strings[0].equalsIgnoreCase("me")) {
                        player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + ChatColor.AQUA + "谁都看不见你了！");
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.hidePlayer(player);
                        }
                        return true;
//                        判断hide下一个指令是否为player
                    } else if (player.hasPermission("hide.player")) {
                        if (strings[0].equalsIgnoreCase("player")) {
                            if (strings.length >= 2) {
//                            拿到要隐藏的玩家
                                Player hidePlayer = Bukkit.getPlayer(strings[1]);
//                        判断指定的那个玩家是否在线
                                if (hidePlayer.isOnline()) {
                                    player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + ChatColor.AQUA + "你屏蔽了§4" + strings[1]);
//                            将玩家隐藏出来
                                    player.hidePlayer(hidePlayer);
                                    return true;
                                } else {
                                    player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + "§4" + strings[1] + " 不在线");
                                    return true;
                                }
                            } else {
                                player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + "§4" + "你他妈不能不输入玩家，还要老子+个非空验证");
                                return true;
                            }
                        } else {
                            player.sendMessage(ChatColor.YELLOW + plugin.getName() + ChatColor.RED + "你没有/<hide> <player>的权限，Permission:hide.player");
                            return true;
                        }

//                        判断hide下一个指令是否为all
                    } else if (strings[0].equalsIgnoreCase("all")) {
                        player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + ChatColor.AQUA + "你现在看不见所有人!必须得退服重进才行!");
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            player.hidePlayer(online);
                        }
                        return true;
                    }
                } else if (command.getName().equalsIgnoreCase(cmd2)) {
                    if (player.hasPermission("show.player")) {
//                        判断show下一个指令是否为player
                        if (strings[0].equalsIgnoreCase("player")) {
                            if (strings.length == 2) {
//                        拿到要显示的玩家
                                Player showPlayer = Bukkit.getPlayer(strings[1]);
//                        判断指定的那个玩家是否在线
                                if (showPlayer.isOnline()) {
                                    player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + ChatColor.AQUA + "你现在可以看见§4" + strings[1]);
//                            将玩家显示出来
                                    player.showPlayer(showPlayer);
                                    return true;
                                } else {
                                    player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + "§4" + strings[1] + " 不在线！");
                                    return true;
                                }
                            } else {
                                player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + "§4" + "你他妈不能不输入玩家，还要老子+个非空验证");
                                return true;
                            }
                        }
                    }else{
                            player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + ChatColor.DARK_RED + "你没有/<show> <player>的使用权限，Permission:show.player");
                            return true;
                    }if (player.hasPermission("show.all")) {
                        if (strings[0].equalsIgnoreCase("all")) {
                            player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + ChatColor.AQUA + "你现在能看见所有人！");
                            for (Player online : Bukkit.getOnlinePlayers()) {
                                player.showPlayer(online);
                            }
                            return true;
                        }
                    } else {
                        player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + ChatColor.DARK_RED + "你没有/<show> <all>的使用权限，Permission:show.all");
                        return true;
                    }
//                    判断show下一个指令是否为me
                    if (strings[0].equalsIgnoreCase("me")) {
                        player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + ChatColor.AQUA + "你现在能被所有人看见！");
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.showPlayer(player);
                        }
                        return true;
//                        判断show下一个指令是否为all
                    }
                }
            }else {
                player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "+ChatColor.GOLD+"你可以输入/<hide> <help>查看帮助！");
            }
        } else {
            commandSender.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + ChatColor.RED + "Only players can use this command!");
            return true;
        }
        return false;
    }
}

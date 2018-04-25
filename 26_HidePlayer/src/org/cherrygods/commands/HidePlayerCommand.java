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
//                    �ж�show��һ��ָ���Ƿ�Ϊme
                    if (strings[0].equalsIgnoreCase("me")) {
                        player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + ChatColor.AQUA + "˭�����������ˣ�");
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.hidePlayer(player);
                        }
                        return true;
//                        �ж�hide��һ��ָ���Ƿ�Ϊplayer
                    } else if (player.hasPermission("hide.player")) {
                        if (strings[0].equalsIgnoreCase("player")) {
                            if (strings.length >= 2) {
//                            �õ�Ҫ���ص����
                                Player hidePlayer = Bukkit.getPlayer(strings[1]);
//                        �ж�ָ�����Ǹ�����Ƿ�����
                                if (hidePlayer.isOnline()) {
                                    player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + ChatColor.AQUA + "�������ˡ�4" + strings[1]);
//                            ��������س���
                                    player.hidePlayer(hidePlayer);
                                    return true;
                                } else {
                                    player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + "��4" + strings[1] + " ������");
                                    return true;
                                }
                            } else {
                                player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + "��4" + "�����費�ܲ�������ң���Ҫ����+���ǿ���֤");
                                return true;
                            }
                        } else {
                            player.sendMessage(ChatColor.YELLOW + plugin.getName() + ChatColor.RED + "��û��/<hide> <player>��Ȩ�ޣ�Permission:hide.player");
                            return true;
                        }

//                        �ж�hide��һ��ָ���Ƿ�Ϊall
                    } else if (strings[0].equalsIgnoreCase("all")) {
                        player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + ChatColor.AQUA + "�����ڿ�����������!������˷��ؽ�����!");
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            player.hidePlayer(online);
                        }
                        return true;
                    }
                } else if (command.getName().equalsIgnoreCase(cmd2)) {
                    if (player.hasPermission("show.player")) {
//                        �ж�show��һ��ָ���Ƿ�Ϊplayer
                        if (strings[0].equalsIgnoreCase("player")) {
                            if (strings.length == 2) {
//                        �õ�Ҫ��ʾ�����
                                Player showPlayer = Bukkit.getPlayer(strings[1]);
//                        �ж�ָ�����Ǹ�����Ƿ�����
                                if (showPlayer.isOnline()) {
                                    player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + ChatColor.AQUA + "�����ڿ��Կ�����4" + strings[1]);
//                            �������ʾ����
                                    player.showPlayer(showPlayer);
                                    return true;
                                } else {
                                    player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + "��4" + strings[1] + " �����ߣ�");
                                    return true;
                                }
                            } else {
                                player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + "��4" + "�����費�ܲ�������ң���Ҫ����+���ǿ���֤");
                                return true;
                            }
                        }
                    }else{
                            player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + ChatColor.DARK_RED + "��û��/<show> <player>��ʹ��Ȩ�ޣ�Permission:show.player");
                            return true;
                    }if (player.hasPermission("show.all")) {
                        if (strings[0].equalsIgnoreCase("all")) {
                            player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + ChatColor.AQUA + "�������ܿ��������ˣ�");
                            for (Player online : Bukkit.getOnlinePlayers()) {
                                player.showPlayer(online);
                            }
                            return true;
                        }
                    } else {
                        player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + ChatColor.DARK_RED + "��û��/<show> <all>��ʹ��Ȩ�ޣ�Permission:show.all");
                        return true;
                    }
//                    �ж�show��һ��ָ���Ƿ�Ϊme
                    if (strings[0].equalsIgnoreCase("me")) {
                        player.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + ChatColor.AQUA + "�������ܱ������˿�����");
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.showPlayer(player);
                        }
                        return true;
//                        �ж�show��һ��ָ���Ƿ�Ϊall
                    }
                }
            }else {
                player.sendMessage(ChatColor.YELLOW+plugin.getName()+" >> "+ChatColor.GOLD+"���������/<hide> <help>�鿴������");
            }
        } else {
            commandSender.sendMessage(ChatColor.YELLOW + plugin.getName() + " >> " + ChatColor.RED + "Only players can use this command!");
            return true;
        }
        return false;
    }
}

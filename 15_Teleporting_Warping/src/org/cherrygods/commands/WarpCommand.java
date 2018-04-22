package org.cherrygods.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.cherrygods.main.TeleportingWarpingClass;
import org.cherrygods.utils.TeleportingWarpingPrefix;

/**
 * @author CherrGods
 * @since 2018-4-22 00:24:16
 */
public class WarpCommand implements CommandExecutor {
    public String warpCommand = "warp";
    public String setWarpCommand = "setwarp";
    private TeleportingWarpingPrefix getPrefix = new TeleportingWarpingPrefix();
    private Plugin plugin = TeleportingWarpingClass.getPlugin(TeleportingWarpingClass.class);
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        //判断指令输入者是否为玩家
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            //判断输入的指令是否为warp
            if(command.getName().equalsIgnoreCase(warpCommand)){
                //条件是用户输入的指令的集合等于为1或者下标为0的指令不能是location
                if(strings.length == 1 && !strings[0].equalsIgnoreCase("location")){
                    //遍历当前服务器的在线玩家
                    for (Player onlinePlayer : plugin.getServer().getOnlinePlayers()){
                        //条件是下标为0的要等于在线玩家的名字
                        if(strings[0].equalsIgnoreCase(onlinePlayer.getDisplayName())){
                            player.teleport(onlinePlayer);
                            player.sendMessage(getPrefix.serverPrefix
                                    +ChatColor.YELLOW+"You have teleported tp: "+onlinePlayer.getDisplayName());
                            return true;
                        }else{
                            player.sendMessage(getPrefix.serverPrefix+ChatColor.RED+"That is not a valid player");
                            return true;
                        }
                    }
                }
                //条件是命令下标为0的是否等于location
                if(strings[0].equalsIgnoreCase("location")){
                    float yaw = plugin.getConfig().getInt("Warp."+strings[1]+".Yaw");
                    float pitch = plugin.getConfig().getInt("Warp."+strings[1]+".Pitch");
                    float x = plugin.getConfig().getInt("Warp."+strings[1]+".X");
                    float y = plugin.getConfig().getInt("Warp."+strings[1]+".Y");
                    float z = plugin.getConfig().getInt("Warp."+strings[1]+".Z");
                    Location location = new Location(player.getWorld(),x,y,z,yaw,pitch);
                    player.teleport(location);
                    return true;
                }
            }

            if(command.getName().equalsIgnoreCase(setWarpCommand)){
                if(strings.length == 1){
                    Location location = player.getLocation();
                    plugin.getConfig().set("warps."+strings[0]+".Yaw",location.getYaw());
                    plugin.getConfig().set("warps."+strings[0]+".Pitch",location.getPitch());
                    plugin.getConfig().set("warps."+strings[0]+".X",location.getY());
                    plugin.getConfig().set("warps."+strings[0]+".Y",location.getX());
                    plugin.getConfig().set("warps."+strings[0]+".Z",location.getZ());
                    plugin.saveConfig();
                    player.sendMessage(getPrefix.serverPrefix+ChatColor.YELLOW+"Location has saved to config");
                    return true;
                }else {
                    return true;
                }
            }
            return true;
        }
        commandSender.sendMessage(getPrefix.serverPrefix+ChatColor.YELLOW+"Only player can use this command");
        return false;
    }
}

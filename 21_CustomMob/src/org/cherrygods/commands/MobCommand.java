package org.cherrygods.commands;

import net.minecraft.server.v1_8_R3.EntitySkeleton;
import net.minecraft.server.v1_8_R3.WorldServer;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.cherrygods.utils.CustomMobPrefix;

/**
 * @author CherrGods
 * @since 2018-4-23 16:35:10
 */
public class MobCommand implements CommandExecutor {
    public String cmd1 = "mob";
    private CustomMobPrefix getPrefix = new CustomMobPrefix();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
//        判断输入命名者是否为玩家
        if(commandSender instanceof Player){
//            把输入命令者转为玩家对象
            Player player = (Player) commandSender;
//            获取玩家位置
            Location loc_player  = player.getLocation();
            WorldServer world = ((CraftWorld)player.getWorld()).getHandle();
//            判断命令是否为cmd1
            if(command.getName().equalsIgnoreCase(cmd1)){
                EntitySkeleton skeleton = new EntitySkeleton(world);
                skeleton.setCustomName(ChatColor.RED+"Skeleton");
                skeleton.setCustomNameVisible(true);

                skeleton.setLocation(
                        loc_player.getX(),loc_player.getY(),loc_player.getZ(),
                        loc_player.getYaw(),loc_player.getPitch());
                world.addEntity(skeleton);
                return true;
            }

        }else
        {
            commandSender.sendMessage(getPrefix.serverPrefix+ChatColor.RED+"Only players can use this command!");
        }
        return false;
    }
}

package org.cherrygods.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;
import org.cherrygods.main.BlockEventMain;

/**
 * @author CherrGods
 * @since 2018-4-17 13:23:41
 */
public class BlockEventClass implements Listener {
    Plugin plugin = BlockEventMain.getPlugin(BlockEventMain.class);

    @SuppressWarnings("破坏方块时显示被破坏方块的名字、位置、所在世界、坐标")
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        //拿到玩家
        Player player = event.getPlayer();
        //拿到监听到的方块
        Block block = event.getBlock();
        //拿到方块所在的位置
        Location loc_block = block.getLocation();
        //开始输出消息
        player.sendMessage(ChatColor.GOLD + "You broke:" +
                ChatColor.AQUA + block.getType().toString().toUpperCase());
        player.sendMessage(ChatColor.GOLD + "Location:");
        player.sendMessage(ChatColor.BLUE + "  X:" + ChatColor.WHITE + loc_block.getBlockX());
        player.sendMessage(ChatColor.BLUE + "  Y:" + ChatColor.WHITE + loc_block.getBlockY());
        player.sendMessage(ChatColor.BLUE + "  Z:" + ChatColor.WHITE + loc_block.getBlockZ());
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        //拿到玩家
        Player player =  event.getPlayer();
        //拿到监听到的方块
        Block block = event.getBlock();
        //拿到方块所在的位置
        Location loc_block = block.getLocation();

        if (block.getType().equals(Material.TNT)) {
            plugin.getServer().broadcastMessage(ChatColor.GREEN + ">>>>>> " +
                    ChatColor.YELLOW + player.getName() + ChatColor.RED + " Place " +
                    ChatColor.AQUA + block.getType().toString().toUpperCase());
        }else{
            //开始输出消息
            player.sendMessage(ChatColor.GOLD + "You place:" +
                    ChatColor.AQUA + block.getType().toString().toUpperCase());
            player.sendMessage(ChatColor.GOLD + "Location:");
            player.sendMessage(ChatColor.BLUE + "X: " + ChatColor.WHITE + loc_block.getBlockX());
            player.sendMessage(ChatColor.BLUE + "Y: " + ChatColor.WHITE + loc_block.getBlockY());
            player.sendMessage(ChatColor.BLUE + "Z: " + ChatColor.WHITE + loc_block.getBlockZ());
        }
    }

}

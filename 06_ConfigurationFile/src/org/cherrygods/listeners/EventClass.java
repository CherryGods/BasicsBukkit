package org.cherrygods.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;
import org.cherrygods.main.ConfigurationFileTest;

/**
 * @author CherrGods
 * @since 2018-4-17 17:48:34
 */
public class EventClass implements Listener {
    private Plugin plugin = ConfigurationFileTest.getPlugin(ConfigurationFileTest.class);
    private int blockCount;

    @EventHandler
    public void onPlaceTNTSaveConfig(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Location loc_block = block.getLocation();
        if (block.getType().equals(Material.TNT)) {
            player.sendMessage(ChatColor.YELLOW+">>>>>> "+ChatColor.AQUA+"Placing TNT has added you to out logs!");
            plugin.getConfig().set("Users." + player.getUniqueId() + ".Block_" + blockCount +
                    ".World", loc_block.getWorld().getName());
            plugin.getConfig().set("Users." + player.getUniqueId() + ".Block_" + blockCount +
                    ".X", loc_block.getBlockX());
            plugin.getConfig().set("Users." + player.getUniqueId() + ".Block_" + blockCount +
                    ".Y", loc_block.getBlockY());
            plugin.getConfig().set("Users." + player.getUniqueId() + ".Block_" + blockCount +
                    ".Z", loc_block.getBlockZ());
            plugin.saveConfig();
            blockCount++;
        }
    }
}

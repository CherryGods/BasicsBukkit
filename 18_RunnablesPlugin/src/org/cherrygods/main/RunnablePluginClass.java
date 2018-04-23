package org.cherrygods.main;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.cherrygods.utils.RunnablePluginPrefix;

/**
 * @author CherrGods
 * @since
 */
public class RunnablePluginClass extends JavaPlugin implements Listener {
    private RunnablePluginPrefix getPrefix;
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Disable");
        super.onDisable();
    }

    @Override
    public void onEnable() {
        getPrefix = new RunnablePluginPrefix();
        getServer().getConsoleSender().sendMessage(getPrefix.cmdPrefix+ChatColor.AQUA+"has been Enable");
        runnable();
        runnableDelayed();
        super.onEnable();
    }
    public void runnable() {
        new BukkitRunnable() {

            @SuppressWarnings("deprecation")
            @Override
            public void run() {
                for (LivingEntity e : getServer().getWorld("world").getLivingEntities()) {

                    e.setCustomName(e.getType() + "ยง4[" + ChatColor.RED + e.getHealth()
                            + "ยง8/ยงc" + e.getMaxHealth() + "ยง4]");
                    e.setCustomNameVisible(true);

                }

            }

        }.runTaskTimerAsynchronously(this, 0, 5);

    }

    public void runnableDelayed() {
        new BukkitRunnable() {

            @Override
            public void run() {
                getServer().broadcastMessage(ChatColor.GREEN + "Server Has Started");
            }

        }.runTaskLaterAsynchronously(this, 40);
    }
}

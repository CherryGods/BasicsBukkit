package org.cherrygods.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.cherrygods.listeners.BloodRecoveryListener;
import org.cherrygods.utils.Items;
import sun.plugin2.main.server.Plugin;

/**
 * 主类
 *
 * @author CherrGods
 * @since 2018-5-14 13:06:21
 */
public class BloodRecoveryClass extends JavaPlugin {
    private Items items = new Items();

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + getName() + " >> " + ChatColor.AQUA + "has been Enable.");
        super.onDisable();
    }

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + getName() + " >> " + ChatColor.AQUA + "has been Enable.");
        getServer().getPluginManager().registerEvents(new BloodRecoveryListener(), this);
        一直要执行的代码();
        super.onEnable();
    }

    public void 一直要执行的代码() {

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (player.getItemInHand().isSimilar(items.getItem("回血书"))) {
                        if (player.getMaxHealth()-player.getHealth()>1) {
                            player.setHealth(player.getHealth() + 1);
                        } else {
                            player.sendMessage(ChatColor.YELLOW + getName() + " >> " + ChatColor.RED + "Your health has max!");
                        }
                    }
                }
            }
        }.runTaskTimer(this, 20, 20);
        new BukkitRunnable(){
            @Override
            public void run(){
                for (Player player : Bukkit.getOnlinePlayers()){
                    if(player.getItemInHand().isSimilar(items.getItem("升级宝石"))){
                        player.giveExp((int) (player.getExp()+1));
                    }
                }
            }
        }.runTaskTimer(this,10,10);
    }
}

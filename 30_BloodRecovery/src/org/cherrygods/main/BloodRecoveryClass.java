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
 * ����
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
        һֱҪִ�еĴ���();
        super.onEnable();
    }

    public void һֱҪִ�еĴ���() {

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (player.getItemInHand().isSimilar(items.getItem("��Ѫ��"))) {
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
                    if(player.getItemInHand().isSimilar(items.getItem("������ʯ"))){
                        player.giveExp((int) (player.getExp()+1));
                    }
                }
            }
        }.runTaskTimer(this,10,10);
    }
}

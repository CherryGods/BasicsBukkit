package org.cherrygods.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.cherrygods.main.ItemBoomClass;

/**
 * @author CherrGods
 * @since 2018-4-23 12:17:08
 */
public class ItemBoomListener implements Listener {
    private Plugin plugin = ItemBoomClass.getPlugin(ItemBoomClass.class);
    @EventHandler
    public void grenadeLaunch(PlayerInteractEvent event){
//        物品
        ItemStack item = event.getItem();
//        操作
        Action action = event.getAction();
//        玩家
        Player player = event.getPlayer();
//        位置
        Location loc = player.getLocation();
//        设置Y轴
        loc.setY(loc.getY()+1.5F);
//        判断物品是否为null
        if(item == null){
            return;
        }
//        判断操作是否是鼠标右键空气或者鼠标右键方块
        if(action.equals(Action.RIGHT_CLICK_AIR)||action.equals(Action.RIGHT_CLICK_BLOCK)){
//            判断item的类型是否为钻石
            if(item.getType().equals(Material.DIAMOND)){
//                设置item的数量
                item.setAmount(item.getAmount()-1);
//                创建一个会boom的item
                ItemStack boom = new ItemStack(item.getType(),1);
//                创建一个实体，位置是随机发射出去的，物品是boom，是从loc开始发射
                Entity drop = loc.getWorld().dropItemNaturally(loc,boom);
//                设置实体的数量
                drop.setVelocity(loc.getDirection().multiply(2));
//                创建一个任务调度
                new BukkitRunnable(){
                    @Override
                    public void run() {
//                        将物品的位置生成一个爆炸效果
                        loc.getWorld().createExplosion(drop.getLocation(),10,true);
                    }
                }.runTaskLater(plugin,40L);
            }
        }
    }
}

package org.cherrygods.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class CustomMobsDropListener implements Listener {
    @EventHandler
    public void mobDeath(EntityDeathEvent event) {
        event.getDrops().clear();
        event.setDroppedExp(0);

        LivingEntity e = event.getEntity();

        if (e instanceof Pig) {
            e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(Material.GRILLED_PORK));
            e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(Material.WHEAT));
        } else if (e instanceof Creeper) {
            e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(Material.TNT));
            e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(Material.FIREBALL));
        }else if (e instanceof Player) {
            e.getLocation().getWorld().dropItem(e.getLocation(), new ItemStack(Material.APPLE));
        }
    }
}

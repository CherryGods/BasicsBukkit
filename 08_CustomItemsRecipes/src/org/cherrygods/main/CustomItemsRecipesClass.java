package org.cherrygods.main;

import org.bukkit.plugin.java.JavaPlugin;
import org.cherrygods.item.CustomerItems;
import org.cherrygods.listeners.EventClass;

public class CustomItemsRecipesClass extends JavaPlugin {
    @Override
    public void onDisable() {
        getLogger().info("CustomItemsRecipesClass has been Disable");
    }

    @Override
    public void onEnable() {
        getLogger().info("CustomItemsRecipesClass has been Enable");
        loadConfig();
        getServer().getPluginManager().registerEvents(new EventClass(), this);
        CustomerItems ci = new CustomerItems();
        ci.customRecipe();
        ci.unShaped();
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}

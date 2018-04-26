package org.cherrygods.utils;

import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.cherrygods.main.MultpleConfigurationFilesClass;

import java.io.File;
import java.io.IOException;

public class ConfigurationManager {
    private MultpleConfigurationFilesClass plugin = MultpleConfigurationFilesClass
            .getPlugin(MultpleConfigurationFilesClass.class);
    /**
     * Files & File Configs Here
     */
    public FileConfiguration playercfg;
    public File playersfile;
    //------------------------

    /**
     * °²×°²å¼þ
     */
    public void setupConfig() {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }
        playersfile = new File(plugin.getDataFolder(), "players.yml");
        if (!playersfile.exists()) {
            try {
                playersfile.createNewFile();
                plugin.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + plugin.getName() + " >> "
                        + ChatColor.AQUA + "The player.yml file has been created");
            } catch (IOException e) {
                plugin.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + plugin.getName() + " >> "
                        + ChatColor.RED + "Could not create player.yml file.\n"
                        + ChatColor.DARK_RED + "Message:" + e.getMessage());
            }
        }
        playercfg = YamlConfiguration.loadConfiguration(playersfile);
    }

    public FileConfiguration getPlayers() {
        return playercfg;
    }

    public void savePlayers() {
        try {
            playercfg.save(playersfile);
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + plugin.getName() + " >> "
                    + ChatColor.AQUA + "The players.yml file has been saved");
        } catch (IOException e) {
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.GREEN+plugin.getName()+" >> "
                    +ChatColor.RED+"Could not save players.yml file.\n"
                    +ChatColor.DARK_RED+"Message:"+e.getMessage());
        }
    }

    public void reloadPlyaers(){
        playercfg = YamlConfiguration.loadConfiguration(playersfile);
        plugin.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + plugin.getName() + " >> "
                + ChatColor.AQUA + "The players.yml file has been reload");
    }
}

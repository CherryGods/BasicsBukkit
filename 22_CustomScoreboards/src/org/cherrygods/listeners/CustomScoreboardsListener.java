package org.cherrygods.listeners;

import com.avaje.ebeaninternal.server.persist.BindValues;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

/**
 * @author CherrGods
 * @since 2018-4-23 22:17:07
 */
public class CustomScoreboardsListener implements Listener {
    @EventHandler
    public void join(PlayerJoinEvent event){
        Player player = event.getPlayer();
//        创建一个计分板管理对象
        ScoreboardManager sm  = Bukkit.getScoreboardManager();
//        创建一个计分板
        Scoreboard s = sm.getNewScoreboard();
//        创建一个计分板对象
        Objective o = s.registerNewObjective("Gold","");
//        设置计分板样式为侧边栏
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName(ChatColor.DARK_AQUA+"CustomScoreboard");
        Score gold = o.getScore(ChatColor.WHITE+"Gold: "+ChatColor.GOLD+"10,000");
        gold.setScore(1);
        player.setScoreboard(s);
    }
}

package it.dbruni.commandwhitelist.listeners;

import ch.jalu.configme.Comment;
import ch.jalu.configme.SettingsManager;
import it.dbruni.commandwhitelist.CommandWhitelist;
import it.dbruni.commandwhitelist.settings.Configuration;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Arrays;
import java.util.List;

public class Listeners implements Listener {


    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {

        Player player = event.getPlayer();
        SettingsManager settingsManager = CommandWhitelist.getInstance().getSettingsManager();
        boolean allow = false;

        for (String allowedCommand : settingsManager.getProperty(Configuration.COMMANDS)) {
            if (event.getMessage().equals(allowedCommand)) {
                allow = true;
                break;
            }
        }
        String bypass = "commandwhitelist.bypass";
        if (player.hasPermission(bypass)) allow = true;
        if (!allow) {
            event.setCancelled(true);
            player.sendMessage(format(settingsManager.getProperty(Configuration.MESSAGE)));
        }

    }

    public String format(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}

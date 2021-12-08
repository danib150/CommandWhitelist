package it.dbruni.commandwhitelist.listeners;

import it.dbruni.commandwhitelist.CommandWhitelist;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Arrays;
import java.util.List;

public class Listeners implements Listener {

    private List<String> allowedCommands = CommandWhitelist.getInstance().getConfig().getStringList("");

    private final String bypass = "commandwhitelist.bypass";

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        boolean allow = false;
        for (String allowedCommand : allowedCommands) {
            if (StringUtils.startsWithIgnoreCase(event.getMessage(), allowedCommand)) {
                allow = true;
                break;
            }
        }
        if (event.getPlayer().hasPermission(bypass)) allow = true;
        if (!allow) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(format(CommandWhitelist.getInstance().getConfig().getString("message")));
        }

    }

    public String format(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}

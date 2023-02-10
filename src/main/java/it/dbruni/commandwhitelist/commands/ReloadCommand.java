package it.dbruni.commandwhitelist.commands;

import it.dbruni.commandwhitelist.CommandWhitelist;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        if (player.hasPermission("commandwhitelist.reload")) {
            player.sendMessage(ChatColor.YELLOW + "Plugin been reloaded");
            CommandWhitelist.getInstance().getSettingsManager().reload();
        }
        return true;
    }
}

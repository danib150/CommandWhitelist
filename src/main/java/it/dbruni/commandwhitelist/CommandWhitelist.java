package it.dbruni.commandwhitelist;

import it.dbruni.commandwhitelist.commands.ReloadCommand;
import it.dbruni.commandwhitelist.listeners.Listeners;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandWhitelist extends JavaPlugin {

    @Getter
    private static CommandWhitelist instance;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new Listeners(), this);

        getCommand("commandwhitelist").setExecutor(new ReloadCommand());

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[CommandWhitelist] " + "plugin abilitato versione 1.0-SNAPSHOT by dbruni");


    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[CommandWhitelist] " + "plugin disabilitato versione 1.0-SNAPSHOT by dbruni");
    }
}

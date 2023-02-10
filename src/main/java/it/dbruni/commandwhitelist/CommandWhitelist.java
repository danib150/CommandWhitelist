package it.dbruni.commandwhitelist;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import it.dbruni.commandwhitelist.commands.ReloadCommand;
import it.dbruni.commandwhitelist.listeners.Listeners;
import it.dbruni.commandwhitelist.settings.Configuration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;

public class CommandWhitelist extends JavaPlugin {
    @Getter
    private static CommandWhitelist instance;
    @Getter
    private SettingsManager settingsManager;


    @Override
    public void onEnable() {
        instance = this;

        File file = new File("plugins/" + this.getName(), "config.yml");
        settingsManager = SettingsManagerBuilder
                .withYamlFile(file)
                .configurationData(Configuration.class)
                .useDefaultMigrationService()
                .create();

        getServer().getPluginManager().registerEvents(new Listeners(), this);

        getCommand("commandwhitelist").setExecutor(new ReloadCommand());

        getLogger().log(Level.FINE, "Plugin enabled version " + this.getDescription().getVersion() + " by " + this.getDescription().getAuthors().get(0));

    }

    @Override
    public void onDisable() {
        getLogger().log(Level.FINE, "Plugin disabled.");
    }
}

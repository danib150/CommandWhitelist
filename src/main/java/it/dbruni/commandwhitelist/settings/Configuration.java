package it.dbruni.commandwhitelist.settings;

import ch.jalu.configme.Comment;
import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.properties.Property;
import it.dbruni.commandwhitelist.CommandWhitelist;

import java.util.List;

import static ch.jalu.configme.properties.PropertyInitializer.newProperty;
import static ch.jalu.configme.properties.PropertyInitializer.newListProperty;

public class Configuration implements SettingsHolder {

    @Comment("CommandWhitelist configuration by " + "dbruni")
    public static final Property<List<String>> COMMANDS = newListProperty("commands", "/butterfly", "/helloword", "/gmc");
    public static final Property<String> MESSAGE = newProperty("message", "&fUnknown Command, type /help.");

}

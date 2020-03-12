package me.pandaplugins.pandabows;

import me.pandaplugins.pandabows.commands.TeleportBowCommand;
import me.pandaplugins.pandabows.events.TeleportBowEvent;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class PandaBows extends JavaPlugin {
    public void onEnable() {
        getLogger().info("PandaBows has now loaded up!");
        getCommand("tpbow").setExecutor((CommandExecutor)new TeleportBowCommand((Plugin)this));
        getServer().getPluginManager().registerEvents((Listener)new TeleportBowEvent(), (Plugin)this);
    }

    public void onDisable() {}
}
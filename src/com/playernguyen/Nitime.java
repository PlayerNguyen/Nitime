package com.playernguyen;

import com.playernguyen.command.NitimeCommand;
import com.playernguyen.listener.PlayerListenerEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Caution! It's dangerously! You're absolutely wrong!
 * This plugin is protected! So you can't open this file!
 * Player Nguyen(c) 2017
 * <p>
 * Project name: - NitimeCommand -
 */
public class Nitime extends JavaPlugin {

    public void onEnable() {
        getLogger().info("[Nitime] Loading commands...");
        getCommand("nitime").setExecutor(new NitimeCommand());

        getLogger().info("[Nitime] Setting up files...");
        SettingsManager.getInstance().setup();
        NotificationManager.getInstance().setup();

        getLogger().info("[Nitime] Registering events...");
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerListenerEvent(), this);
        getLogger().info("[Nitime] Plugin enabled without error!");

        getLogger().info("[Nitime] Displaying enable notification...");
        NitimeAPI.createNotifications("SERVER", "NitimeCommand is enabled", SettingsManager.getInstance().getPosition(), 5);
    }

    public static Plugin thisPlugin()
    {
        return Bukkit.getServer().getPluginManager().getPlugin("Nitime");
    }


}

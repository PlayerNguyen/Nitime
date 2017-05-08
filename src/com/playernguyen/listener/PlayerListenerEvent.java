package com.playernguyen.listener;

import com.playernguyen.NitimeAPI;
import com.playernguyen.NotificationManager;
import com.playernguyen.SettingsManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Caution! It's dangerously! You're absolutely wrong!
 * This plugin is protected! So you can't open this file!
 * Player Nguyen(c) 2017
 * <p>
 * Project name: - NitimeCommand -
 */
public class PlayerListenerEvent implements Listener {

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        String title = (String) NotificationManager.getInstance().get("notification.on-join.title");
        String messages = (String) NotificationManager.getInstance().get("notification.on-join.contents");
        int seconds = (Integer) NotificationManager.getInstance().get("notification.on-join.second");
        NitimeAPI.createNotifications(
                title,
                messages.replace("%s%", player.getName()),
                SettingsManager.getInstance().getPosition(),
                seconds);
    }

    @EventHandler
    public void OnPlayerLeft(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        String title = (String) NotificationManager.getInstance().get("notification.on-leave.title");
        String messages = (String) NotificationManager.getInstance().get("notification.on-leave.contents");
        int seconds = (Integer) NotificationManager.getInstance().get("notification.on-leave.second");
        NitimeAPI.createNotifications(
                title,
                messages.replace("%s%", player.getName()),
                SettingsManager.getInstance().getPosition(),
                seconds);
    }

    @EventHandler
    public void OnCommandExecutor(PlayerCommandPreprocessEvent event)
    {
        for (String s : NotificationManager.getInstance().getList("notification.on-command.list")) {
            if (event.getMessage().contains(s)) {
                Player player = event.getPlayer();
                String title = (String) NotificationManager.getInstance().get("notification.on-command.title");
                String messages = (String) NotificationManager.getInstance().get("notification.on-command.contents");
                int seconds = (Integer) NotificationManager.getInstance().get("notification.on-command.second");
                NitimeAPI.createNotifications(
                        title,
                        messages.replace("%s%", player.getName()).replace("%command%", event.getMessage()),
                        SettingsManager.getInstance().getPosition(),
                        seconds);
            }
        }
    }


}

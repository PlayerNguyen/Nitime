package com.playernguyen.command;

import com.playernguyen.LanguageStatic;
import com.playernguyen.Nitime;
import com.playernguyen.NitimeAPI;
import com.playernguyen.SettingsManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Caution! It's dangerously! You're absolutely wrong!
 * This plugin is protected! So you can't open this file!
 * Player Nguyen(c) 2017
 * <p>
 * Project name: - NitimeCommand -
 */
public class NitimeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player)
        {
            Player player = (Player) commandSender;
            if (player.hasPermission("nitime.command") || player.isOp())
            {
                if (strings.length <= 0)
                {
                    player.sendMessage(ChatColor.GRAY + "--------------------------------------");
                    player.sendMessage(ChatColor.RED + "/nitime " + ChatColor.GOLD + "test" + ChatColor.RED + ": Display notifications to test");
                    player.sendMessage(ChatColor.RED + "/nitime " + ChatColor.GOLD + "reload" + ChatColor.RED + ": Reload command");
                    player.sendMessage(ChatColor.GRAY + "--------------------------------------");
                    return true;
                }
                if (strings[0].equalsIgnoreCase("test"))
                {
                    if (player.hasPermission("nitime.test") || player.isOp())
                    {
                        NitimeAPI.createNotifications("TEST", player.getName() + " using command /test", SettingsManager.getInstance().getPosition(), 5);
                        player.sendMessage(ChatColor.GREEN + "[Nitime] Displayed test notification.");
                    } else {
                        player.sendMessage(LanguageStatic.DONT_HAVE_PERMISSIONS);
                    }
                }
                if (strings[0].equalsIgnoreCase("reload"))
                {
                    if (player.hasPermission("nitime.reload") || player.isOp())
                    {
                        Nitime.thisPlugin().reloadConfig();
                        player.sendMessage(ChatColor.GREEN + "[Nitime] Reloading files of plugin.");
                    } else {
                        player.sendMessage(LanguageStatic.DONT_HAVE_PERMISSIONS);
                    }
                }
            } else {
                player.sendMessage(LanguageStatic.DONT_HAVE_PERMISSIONS);
            }
        } else {
            CommandSender sender = commandSender;
            if (strings.length <= 0)
            {
                sender.sendMessage(ChatColor.GRAY + "--------------------------------------");
                sender.sendMessage(ChatColor.RED + "/nitime " + ChatColor.GOLD + "test" + ChatColor.RED + ": Display notifications to test");
                sender.sendMessage(ChatColor.RED + "/nitime " + ChatColor.GOLD + "reload" + ChatColor.RED + ": Reload command");
                sender.sendMessage(ChatColor.GRAY + "--------------------------------------");
                return true;
            }
            if (strings[0].equalsIgnoreCase("test"))
            {
                NitimeAPI.createNotifications("TEST", "Console using test command :D", SettingsManager.getInstance().getPosition(), 5);
                sender.sendMessage(ChatColor.GREEN + "[Nitime] Displayed test notification...");
            }
            if (strings[0].equalsIgnoreCase("reload"))
            {
                Nitime.thisPlugin().reloadConfig();
                sender.sendMessage(ChatColor.GREEN + "[Nitime] Reloading files of plugin...");
            }
        }
        return true;
    }
}

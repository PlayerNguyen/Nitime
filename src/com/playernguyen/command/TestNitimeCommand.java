package com.playernguyen.command;

import com.playernguyen.NitimeAPI;
import com.playernguyen.gui.Position;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Caution! It's dangerously! You're absolutely wrong!
 * This plugin is protected! So you can't open this file!
 * Player Nguyen(c) 2017
 * <p>
 * Project name: - NitimeCommand -
 */
public class TestNitimeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        NitimeAPI.createNotifications("Command", "Testing command", Position.BOTTOM_RIGHT, 5);
        return true;
    }
}

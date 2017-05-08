package com.playernguyen;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Caution! It's dangerously! You're absolutely wrong!
 * This plugin is protected! So you can't open this file!
 * Player Nguyen(c) 2017
 * <p>
 * Project name: - NitimeCommand -
 */
public class NotificationManager {

    public File file = new File(Nitime.thisPlugin().getDataFolder(), "/notifications.yml");
    private YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

    public static NotificationManager getInstance()
    {
        return new NotificationManager();
    }

    void setup()
    {
        if (!file.exists())
        {
            yamlConfiguration.set("notification.on-join.title", "JOIN");
            yamlConfiguration.set("notification.on-join.contents", "Player %s% joined server");
            yamlConfiguration.set("notification.on-join.second", 5);

            yamlConfiguration.set("notification.on-leave.title", "LEAVE");
            yamlConfiguration.set("notification.on-leave.contents", "Player %s% left server");
            yamlConfiguration.set("notification.on-leave.second", 5);

            yamlConfiguration.set("notification.on-command.title", "COMMAND");
            yamlConfiguration.set("notification.on-command.contents", "%s% using %command% command");
            yamlConfiguration.set("notification.on-command.second", 5);
            yamlConfiguration.set("notification.on-command.list", new String[]{"/op","/ban","/stop"});

            yamlConfiguration.set("notification.version", Nitime.thisPlugin().getDescription().getVersion());
            save();
        }
        if (yamlConfiguration.get("notification.version") != Nitime.thisPlugin().getDescription().getVersion() || !yamlConfiguration.isSet("notification.version"))
        {

            yamlConfiguration.set("notification.version", Nitime.thisPlugin().getDescription().getVersion());
            save();
        }
    }
    public ArrayList<Object> getNotification(String path)
    {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(yamlConfiguration.getString("notification." + path + ".title"));
        arrayList.add(yamlConfiguration.getString("notification." + path + ".contents"));
        arrayList.add(yamlConfiguration.getInt("notification." + path + ".second"));
        return arrayList;
    }
    public Object get(String path)
    {
        return yamlConfiguration.get(path);
    }

    public List<String> getList(String path)
    {
        return yamlConfiguration.getStringList(path);
    }

    private void save()
    {
        try
        {
            yamlConfiguration.save(file);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}

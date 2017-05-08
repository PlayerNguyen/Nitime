package com.playernguyen;

import com.playernguyen.gui.Position;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Caution! It's dangerously! You're absolutely wrong!
 * This plugin is protected! So you can't open this file!
 * Player Nguyen(c) 2017
 * <p>
 * Project name: - NitimeCommand -
 */
public class SettingsManager {

    public File file = new File(Nitime.thisPlugin().getDataFolder(), "/config.yml");
    private YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

    public static SettingsManager getInstance() {
        return new SettingsManager();
    }

    public YamlConfiguration getConfig()
    {
        return yamlConfiguration;
    }

    public File getFile() {
        return file;
    }

    void setup()
    {
        if (!file.exists())
        {
            yamlConfiguration.set("config.default-location", Position.BOTTOM_RIGHT.toString());
            yamlConfiguration.set("config.direct", true);
            yamlConfiguration.set("config.direct.port", 952);
            yamlConfiguration.set("config.seconds-display", 5);
            yamlConfiguration.set("config.version", Nitime.thisPlugin().getDescription().getVersion());
            save();
        }
        if (!yamlConfiguration.getString("config.version").equals(Nitime.thisPlugin().getDescription().getVersion()) || !yamlConfiguration.isSet("config.version"))
        {
            yamlConfiguration.set("notification.version", Nitime.thisPlugin().getDescription().getVersion());
            save();
        }
    }

    public Position getPosition()
    {
       return Position.valueOf((String) yamlConfiguration.get("config.default-location"));
    }

    public int getPortDirect()
    {
        return yamlConfiguration.getInt("config.direct.port");
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

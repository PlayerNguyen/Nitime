package com.playernguyen;

import com.playernguyen.gui.Popup;
import com.playernguyen.gui.Position;

import java.awt.*;


/**
 * Caution! It's dangerously! You're absolutely wrong!
 * This plugin is protected! So you can't open this file!
 * Player Nguyen(c) 2017
 * <p>
 * Project name: - NitimeCommand -
 */
public class NitimeAPI {

    /**
     * Create notifications floating on top of desktop
     *
     * @param title String with using for title, will display first
     * @param text String with using for messages, will display after title, both time with title
     * @param position Position where notifications display
     * @param seconds Seconds to display
     *
     * @since 1.1
     */
    public static void createNotifications(String title, String text, Position position, int seconds)
    {
        new Popup(title, text, new Color(245, 245, 245), Color.BLACK, position, seconds);
    }

    /**
     * Info with yellow background, black text color notification
     *
     * @param texts Message of information
     * @param position Position where notifications display
     * @param seconds Seconds to display
     *
     * @since 1.1
     */
    public static void info(String texts, Position position, int seconds)
    {
        new Popup("INFO", texts, Color.YELLOW, Color.BLACK, position, seconds);
    }

    /**
     * Error with red background, white text color notification
     *
     * @param texts Message of information
     * @param position Position where notifications display
     * @param seconds Seconds to display
     *
     * @since 1.1
     */
    public static void error(String texts, Position position, int seconds)
    {
        new Popup("ERROR", texts, Color.RED, Color.WHITE, position, seconds);
    }

    /**
     * Create notifications floating on top of screen
     * @param title String with using for title, will display first
     * @param text String with using for messages, will display after title, both time with title
     * @param position Position where notifications display
     * @param seconds Seconds to display
     * @param background Background of notifications
     * @param textcolor Text color of notifications
     *
     * @since 1.1
     */
    public static void createNotifications(String title, String text, Color background, Color textcolor, Position position, int seconds)
    {
        new Popup(title, text, background, textcolor, position, seconds);
    }

}

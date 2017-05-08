package com.playernguyen.gui;

import java.util.ArrayList;

/**
 * Caution! It's dangerously! You're absolutely wrong!
 * This plugin is protected! So you can't open this file!
 * Player Nguyen(c) 2017
 * <p>
 * Project name: - NitimeCommand -
 */
public class DataID {

    public static ArrayList<Popup> datasID = new ArrayList<>();

    public static void add(Popup popup)
    {
        datasID.add(popup);
    }

    public static void remove(Popup popup)
    {
        datasID.remove(popup);
    }

    public static ArrayList<Popup> getDatasID() {
        return datasID;
    }

    public static Popup getByID(int id)
    {
        return datasID.get(id);
    }



}

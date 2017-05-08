package com.playernguyen.gui;

import com.playernguyen.util.ScreenUtil;

/**
 * Caution! It's dangerously! You're absolutely wrong!
 * This plugin is protected! So you can't open this file!
 * Player Nguyen(c) 2017
 * <p>
 * Project name: - NitimeCommand -
 */
public enum Position {


    TOP_LEFT        (0, 0),
    TOP_CENTER      (ScreenUtil.dimension.width/2, 0),
    TOP_RIGHT       (ScreenUtil.dimension.width, 0),

    MIDDLE_LEFT     (0,                                     ScreenUtil.dimension.height/2),
    MIDDLE_CENTER   (ScreenUtil.dimension.width/2,          ScreenUtil.dimension.height/2),
    MIDDLE_RIGHT    (ScreenUtil.dimension.width,            ScreenUtil.dimension.height/2),

    BOTTOM_LEFT     (0,                                     ScreenUtil.dimension.height),
    BOTTOM_CENTER   (ScreenUtil.dimension.width/2,          ScreenUtil.dimension.height),
    BOTTOM_RIGHT    (ScreenUtil.dimension.width,            ScreenUtil.dimension.height);

    private int x;
    private int y;

    Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

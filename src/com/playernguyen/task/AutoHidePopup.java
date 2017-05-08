package com.playernguyen.task;

import com.playernguyen.gui.Popup;

import java.util.TimerTask;

/**
 * Caution! It's dangerously! You're absolutely wrong!
 * This plugin is protected! So you can't open this file!
 * Player Nguyen(c) 2017
 * <p>
 * Project name: - NitimeCommand -
 */
public class AutoHidePopup extends TimerTask {

    private Popup popup;

    public AutoHidePopup(Popup popup)
    {
        this.popup = popup;
    }

    @Override
    public void run() {
        popup.hide();
        cancel();
    }
}

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
public class EffectHidePopup extends TimerTask {

    private Popup popup;

    public EffectHidePopup(Popup popup)
    {
        this.popup = popup;
        popup.setOpacity(1);
    }

    @Override
    public void run() {
        if (popup.getOpacity() <= 0.01f)
        {
            popup.setOpacity(0);
            cancel();
            return;
        }
        popup.setOpacity(popup.getOpacity() - 0.01f );
    }

}

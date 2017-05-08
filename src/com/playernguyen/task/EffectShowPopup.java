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
public class EffectShowPopup extends TimerTask {

    private Popup popup;

    /**
     * Effect when showing the popup, the effect it fade
     * @param popup Popup to show fade effect
     * @since 1.1
     */
    public EffectShowPopup(Popup popup)
    {
        this.popup = popup;
        popup.setOpacity(0);
    }

    @Override
    public void run() {
        if (popup.getOpacity() >= 1.0f || popup.getOpacity() >= 0.9f)
        {
            popup.setOpacity(1);
            cancel();
            return;
        }
        popup.setOpacity(popup.getOpacity() + 0.001f);
    }
}

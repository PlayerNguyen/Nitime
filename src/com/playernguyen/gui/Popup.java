package com.playernguyen.gui;

import com.playernguyen.listener.OnNotificationDisplay;
import com.playernguyen.task.AutoHidePopup;
import com.playernguyen.task.EffectHidePopup;
import com.playernguyen.task.EffectShowPopup;
import com.playernguyen.util.ScreenUtil;
import org.bukkit.Bukkit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;

/**
 * Caution! It's dangerously! You're absolutely wrong!
 * This plugin is protected! So you can't open this file!
 * Player Nguyen(c) 2017
 * <p>
 * Project name: - NitimeCommand -
 */
public class Popup extends JFrame {

    public String title;
    public String messages;

    public Popup(String title, String messages, Color backColor, Color textColor, Position position, int time)
    {
        // Validate.isTrue(time >= 10, "The seconds cannot be bigger than 10");
        this.title = title;
        if (messages.length() > 45)
        {
            Bukkit.getServer().getLogger().severe("Creating charset bigger than 45!");
        }
        this.messages = messages;

        OnNotificationDisplay notificationDisplay = new OnNotificationDisplay(title, messages, DataID.datasID.size(), time, position);
        Bukkit.getServer().getPluginManager().callEvent(notificationDisplay);

        if (notificationDisplay.isCancelled()) return;

        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        setAlwaysOnTop(true);
        setCursor(Cursor.HAND_CURSOR);

        setBackground(backColor);
        getContentPane().setBackground(backColor);

        setSize(new Dimension(350, 150));

        setLocation(position.getX()+15, position.getY()+15 + (DataID.datasID.size()*15*3));

        if (getLocation().x > ScreenUtil.dimension.width)
        {
            setLocation(position.getX()-getSize().width, position.getY()+15 + (DataID.datasID.size()*15*3));
        } else if (getLocation().y > ScreenUtil.dimension.height)
        {
            setLocation(position.getX()+15, (position.getY()+15 - (DataID.datasID.size()*15*3)) - getSize().height);
        }
        if (position==Position.BOTTOM_RIGHT)
        {
            setLocation(position.getX()-getSize().width, (position.getY()+15 - (DataID.datasID.size()*15*3)) - getSize().height);
        }

        setType(Type.UTILITY);

        JPanel panel = new JPanel();
        panel.setBackground(backColor);

        JLabel title1 = new JLabel(title);
        title1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        title1.setForeground(textColor);
        panel.add(title1);

        JLabel messages1 = new JLabel(messages);
        messages1.setLocation(15, 15);
        messages1.setForeground(textColor);
        panel.add(messages1);

        add(panel);
        setUndecorated(true);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hide();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        setOpacity(0);
        pack();

        Timer timer = new Timer();
        timer.schedule(new EffectShowPopup(this), 1, 1);
        timer.schedule(new AutoHidePopup(this), time * 1000, time*1000);

        setVisible(true);
        DataID.add(this);


    }

    @Override
    public void hide() {
        DataID.remove(this);
        Timer timer = new Timer();
        timer.schedule(new EffectHidePopup(this), 1, 1);
        super.hide();
    }
}

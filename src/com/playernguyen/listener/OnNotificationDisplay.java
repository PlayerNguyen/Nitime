package com.playernguyen.listener;

import com.playernguyen.gui.Position;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


/**
 * Caution! It's dangerously! You're absolutely wrong!
 * This plugin is protected! So you can't open this file!
 * Player Nguyen(c) 2017
 * <p>
 * Project name: - NitimeCommand -
 */
public class OnNotificationDisplay extends Event implements Cancellable  {

    private String title;
    private String text;
    private int id;
    private int second;
    private Position position;
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;


    public OnNotificationDisplay(String title, String text, int id, int second, Position position)
    {
        this.text = text;
        this.title = title;
        this.id = id;
        this.second = second;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public int getSecond() {
        return second;
    }

    public Position getPosition() {
        return position;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String getEventName() {
        return super.getEventName();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }


}

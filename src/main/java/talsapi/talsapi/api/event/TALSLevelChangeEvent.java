package talsapi.talsapi.api.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.entity.Player;

public class TALSLevelChangeEvent extends Event {

    private Player p;
    private int oldlevel;
    private int newlevel;

    public TALSLevelChangeEvent(Player p,int oldlevel,int newlevel) {
        this.p = p;
        this.newlevel = newlevel;
        this.oldlevel = oldlevel;
    }

    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Player getPlayer()
    {
        return p;
    }

    public int getOldLevel()
    {
        return oldlevel;
    }

    public int getNewlevel()
    {
        return newlevel;
    }
}

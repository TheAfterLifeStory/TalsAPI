package talsapi.talsapi.api.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TALSSkillPointChangeEvent extends Event{

    private Player p;

    private int sp;

    public TALSSkillPointChangeEvent(Player p,int sp) {
        this.p = p;
        this.sp = sp;
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

    public int getSp()
    {
        return sp;
    }

}

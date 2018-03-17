package talsapi.talsapi.api.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TALSGoldChangeEvent extends Event{

    private Player p;

    private double gold;

    public TALSGoldChangeEvent(Player p, double gold) {
        this.p = p;
        this.gold = gold;
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

    public double getGold()
    {
        return gold;
    }

}

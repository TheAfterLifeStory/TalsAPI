package talsapi.talsapi.api.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import talsapi.talsapi.api.manager.enums.Skill;
import talsapi.talsapi.api.manager.enums.Stats;

public class TALSStatsChangeEvent extends Event {

    private Player p;

    private Stats stats;

    private int sp;

    public TALSStatsChangeEvent(Player p, Stats stats,int sp) {
        this.p = p;
        this.sp = sp;
        this.stats = stats;
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

    public Stats getStats()
    {
        return stats;
    }

    public int getSP()
    {
        return sp;
    }
}

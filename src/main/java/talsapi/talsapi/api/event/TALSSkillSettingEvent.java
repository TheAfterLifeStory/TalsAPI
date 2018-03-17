package talsapi.talsapi.api.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import talsapi.talsapi.api.manager.enums.Skill;

public class TALSSkillSettingEvent extends Event{

    private Player p;

    private boolean get;

    private Skill skill;

    public TALSSkillSettingEvent(Player p,Skill skill,boolean get) {
        this.p = p;
        this.skill = skill;
        this.get = get;
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

    public Skill getSkill()
    {
        return skill;
    }

    public boolean getSkillSetting()
    {
        return get;
    }
}

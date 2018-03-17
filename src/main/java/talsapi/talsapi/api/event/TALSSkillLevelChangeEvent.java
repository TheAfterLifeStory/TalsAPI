package talsapi.talsapi.api.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import talsapi.talsapi.api.manager.enums.Skill;

public class TALSSkillLevelChangeEvent extends Event{
    private Player p;

    private int newLevel;

    private Skill skill;

    public TALSSkillLevelChangeEvent(Player p,int newLevel,Skill skill) {
        this.p = p;
        this.newLevel = newLevel;
        this.skill = skill;
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

    public int getNewSkillLevel()
    {
        return newLevel;
    }

    public Skill getSkill()
    {
        return skill;
    }

}

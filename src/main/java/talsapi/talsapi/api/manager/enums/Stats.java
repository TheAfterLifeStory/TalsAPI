package talsapi.talsapi.api.manager.enums;

public enum Stats {
    MaxMP("StatsMaxMP"),
    MaxHealth("StatsMaxHealth"),
    AttackDamage("StatsAttackDamage"),
    SkillDamage("StatsSkillDamage"),
    Speed("StatsSpeed");

    private String s;

    Stats(String name)
    {
        s=name;
    }

    public String getName()
    {
        return s;
    }
}

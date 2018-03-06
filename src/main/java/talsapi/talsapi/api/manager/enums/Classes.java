package talsapi.talsapi.api.manager.enums;

import talsapi.talsapi.mysql.Guardian;

public enum Classes {

    NONE(0,"none"),
    SOLDIER(1,"Soldier"),
    WIZARD(2,"Wizard"),
    GUARDIAN(3,"Guardian"),
    THIEF(4,"Thief"),
    HUNTER(5,"Hunter"),
    ASSASSIN(6,"Assassin"),
    NECROMANCER(7,"Necromancer"),
    PRIEST(8,"Priest");

    private int classes;
    private String name;

    Classes(int i,String name) {
        classes = i;
        this.name = name;
    }

    public int getClasses()
    {
        return classes;
    }
    public String getName()
    {
        return name;
    }
}

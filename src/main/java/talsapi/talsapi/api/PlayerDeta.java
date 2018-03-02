package talsapi.talsapi.api;

import org.bukkit.entity.Player;
import talsapi.talsapi.api.classes.ClassInfo;
import talsapi.talsapi.api.classes.MainClass;
import talsapi.talsapi.api.manager.PlayerManager;
import talsapi.talsapi.api.manager.enums.Classes;

public class PlayerDeta {

    private Player p;

    public PlayerDeta(Player p)
    {
        this.p = p;
    }

    public MainClass getMainClass() { return new MainClass(p); }

    public void setClasses(Classes change){ new PlayerManager(p).changeClasses(change.getClasses()); }

    public Classes getClasses() { return new PlayerManager(p).getClasses(); }

    public ClassInfo getClassInfo(Classes classes) { return new ClassInfo(p,classes);}
}

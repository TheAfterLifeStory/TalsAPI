package talsapi.talsapi.api.classes;

import org.bukkit.entity.Player;
import talsapi.talsapi.api.manager.ClassManager;
import talsapi.talsapi.api.manager.enums.Classes;
import talsapi.talsapi.api.manager.enums.Skill;
import talsapi.talsapi.api.manager.enums.Stats;

public class ClassInfo {

    private Player p;
    private Classes classes;

    public ClassInfo(Player p,Classes classes)
    {
        this.classes = classes;
        this.p = p;
    }

    //レベルを設定
    public void setLevel(int level) { new ClassManager(p).setLevel(classes, level); }

    //LEVELを取得
    public int getLevel() {return new ClassManager(p).getLevel(classes);}

    //EXP設定
    public void setExp(double exp){ new ClassManager(p).setExp(classes, exp); }

    //EXP取得
    public double getExp() {return new ClassManager(p).getEXP(classes);}

    //STATS
    public ClassInfoStats getStats(Stats stats) {return new ClassInfoStats(p,stats,classes);}

    //SKILL
    public ClassInfoSkills getSkill(Skill skill) {return new ClassInfoSkills(p,skill,classes);}

    //MPの設定
    public void setMaxMP(int mp){new ClassManager(p).setMaxMP(classes, mp);}

    //MP
    public int getMaxMP() {return new ClassManager(p).getMaxMP(classes);}

    //MAXヘルスの設定
    public void setMaxHealth(double health){new ClassManager(p).setMaxHealth(classes, health);}

    //MAXヘルスの取得
    public double getMaxHealth() {return new ClassManager(p).getMaxHealth(classes);}

    //SPの設定
    public void setSP(int SP){new ClassManager(p).setSP(classes, SP);}

    //SPの取得
    public int getSP() {return new ClassManager(p).getSP(classes);}

    //NEXTEXPの取得
    public double getNextExp() {return new ClassManager(p).getNextExp(classes);}

    //クラスの名前を取得
    public String getPrefix() {return new ClassManager(p).getPrefix(classes);}
}

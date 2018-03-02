package talsapi.talsapi.api.classes;

import org.bukkit.entity.Player;
import talsapi.talsapi.api.manager.ClassManager;
import talsapi.talsapi.api.manager.PlayerManager;
import talsapi.talsapi.api.manager.enums.Skill;
import talsapi.talsapi.api.manager.enums.Stats;

public class MainClass {

    private Player p;

    public MainClass(Player p)
    {
        this.p = p;
    }

    //レベルを設定
    public void setLevel(int level) { new ClassManager(p).setLevel(new PlayerManager(p).getClasses(), level); }

    //LEVELを取得
    public int getLevel() {return new ClassManager(p).getLevel(new PlayerManager(p).getClasses());}

    //EXP設定
    public void setExp(double exp){ new ClassManager(p).setExp(new PlayerManager(p).getClasses(), exp); }

    //EXP取得
    public double getExp() {return new ClassManager(p).getEXP(new PlayerManager(p).getClasses());}

    //STATS
    public MainClassStats getStats(Stats stats) {return new MainClassStats(p,stats,new PlayerManager(p).getClasses());}

    //SKILL
    public MainClassSkills getSkill(Skill skill) {return new MainClassSkills(p,skill,new PlayerManager(p).getClasses());}

    //MPの設定
    public void setMaxMP(int mp){new ClassManager(p).setMaxMP(new PlayerManager(p).getClasses(), mp);}

    //MP
    public int getMaxMP() {return new ClassManager(p).getMaxMP(new PlayerManager(p).getClasses());}

    //MAXヘルスの設定
    public void setMaxHealth(double health){new ClassManager(p).setMaxHealth(new PlayerManager(p).getClasses(), health);}

    //MAXヘルスの取得
    public double getMaxHealth() {return new ClassManager(p).getMaxHealth(new PlayerManager(p).getClasses());}

    //SPの設定
    public void setSP(int SP){new ClassManager(p).setSP(new PlayerManager(p).getClasses(), SP);}

    //SPの取得
    public int getSP() {return new ClassManager(p).getSP(new PlayerManager(p).getClasses());}

    //NEXTEXPの取得
    public double getNextExp() {return new ClassManager(p).getNextExp(new PlayerManager(p).getClasses());}

    //クラスの名前を取得
    public String getPrefix() {return new ClassManager(p).getPrefix(new PlayerManager(p).getClasses());}
}

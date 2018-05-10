package talsapi.talsapi.api.manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import talsapi.talsapi.MySQLs;
import talsapi.talsapi.api.event.TALSClassChangeEvent;
import talsapi.talsapi.api.manager.enums.Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerManager {
    private Player p;
    private String table = "PlayerDeta";

    public PlayerManager(Player p)
    {
        this.p = p;
    }

    public void changeClasses(int change)
    {
        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement(
                    "UPDATE "+table+" SET CLASS=? WHERE UUID=?");
            statment.setString(2,p.getUniqueId().toString());
            statment.setInt(1,change);
            statment.executeUpdate();
            Bukkit.getServer().getPluginManager().callEvent(new TALSClassChangeEvent(p));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Classes getClasses()
    {
        int classes = 0;
        //CLASSを入手
        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement(
                    "SELECT * FROM " + table + " WHERE UUID=?");
            statment.setString(1,p.getUniqueId().toString());
            ResultSet results = statment.executeQuery();
            results.next();
            classes = results.getInt("CLASS");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(classes == 0) return Classes.NONE;
        if(classes == 1) return Classes.SOLDIER;//ソルジャー
        if(classes == 2) return Classes.WIZARD;//ウィザード
        if(classes == 3) return Classes.GUARDIAN;//ガーディアン
        if(classes == 4) return Classes.THIEF;//チーフ
        if(classes == 5) return Classes.HUNTER;//ハンター
        if(classes == 6) return Classes.ASSASSIN;//アサシン
        if(classes == 7) return Classes.NECROMANCER;//ネクロマンサー
        if(classes == 8) return Classes.PRIEST;//プリ―ト

        return Classes.NONE;
    }

    public void setGold(double gold)
    {
        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement(
                    "UPDATE "+table+" SET GOLD=? WHERE UUID=?");
            statment.setString(2,p.getUniqueId().toString());
            statment.setDouble(1,gold);
            statment.executeUpdate();
            Bukkit.getServer().getPluginManager().callEvent(new TALSClassChangeEvent(p));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double getGold()
    {
        double gold = 0.0;
        //CLASSを入手
        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement(
                    "SELECT * FROM " + table + " WHERE UUID=?");
            statment.setString(1,p.getUniqueId().toString());
            ResultSet results = statment.executeQuery();
            results.next();
            gold = results.getDouble("GOLD");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gold;
    }
}

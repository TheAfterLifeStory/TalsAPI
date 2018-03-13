package talsapi.talsapi.api.manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import talsapi.talsapi.MySQLs;
import talsapi.talsapi.api.event.TALSExpChangeEvent;
import talsapi.talsapi.api.event.TALSLevelChangeEvent;
import talsapi.talsapi.api.manager.enums.Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassManager {
    private Player p;

    public ClassManager(Player p)
    {
        this.p = p;
    }

    public void setExp(Classes classes,double exp)
    {

        if(classes.getClasses() == 0)
        {
            return;
        }

        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement(
                    "UPDATE "+classes.getName()+" SET EXP=? WHERE UUID=?");
            statment.setString(2,p.getUniqueId().toString());
            statment.setDouble(1,exp);
            statment.executeUpdate();
            Bukkit.getServer().getPluginManager().callEvent(new TALSExpChangeEvent(p));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double getEXP(Classes classes)
    {

        if(classes.getClasses() ==0)
        {
            return 0;
        }

        //SPを取得
        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement(
                    "SELECT * FROM " + classes.getName() + " WHERE UUID=?");
            statment.setString(1,p.getUniqueId().toString());
            ResultSet results = statment.executeQuery();
            results.next();
            return results.getInt("EXP");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }


    public void setLevel(Classes classes,int level)
    {
        if(classes.getClasses() == 0)
        {
            return;
        }
        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement(
                    "UPDATE "+classes.getName()+" SET LEVEL=? WHERE UUID=?");
            statment.setString(2,p.getUniqueId().toString());
            statment.setInt(1,level);
            statment.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Bukkit.getServer().getPluginManager().callEvent(new TALSLevelChangeEvent(p));
    }

    public int getLevel(Classes classes)
    {

        if(classes.getClasses() ==0)
        {
            return 0;
        }

        //SPを取得
        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement(
                    "SELECT * FROM " + classes.getName() + " WHERE UUID=?");
            statment.setString(1,p.getUniqueId().toString());
            ResultSet results = statment.executeQuery();
            results.next();
            return results.getInt("LEVEL");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public void setMaxMP(Classes classes, int arg1)
    {
        if(classes.getClasses() == 0)
        {
            return;
        }
        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement(
                    "UPDATE "+classes.getName()+" SET MAXMP=? WHERE UUID=?");
            statment.setString(2,p.getUniqueId().toString());
            statment.setInt(1,arg1);
            statment.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getMaxMP(Classes classes)
    {

        if(classes.getClasses() ==0)
        {
            return 0;
        }

        //SPを取得
        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement(
                    "SELECT * FROM " + classes.getName() + " WHERE UUID=?");
            statment.setString(1,p.getUniqueId().toString());
            ResultSet results = statment.executeQuery();
            results.next();
            return results.getInt("MAXMP");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public void setMaxHealth(Classes classes, double arg1)
    {
        if(classes.getClasses() == 0)
        {
            return;
        }
        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement(
                    "UPDATE "+classes.getName()+" SET MAXHEALTH=? WHERE UUID=?");
            statment.setString(2,p.getUniqueId().toString());
            statment.setDouble(1,arg1);
            statment.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double getMaxHealth(Classes classes)
    {

        if(classes.getClasses() ==0)
        {
            return 0;
        }

        //SPを取得
        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement(
                    "SELECT * FROM " + classes.getName() + " WHERE UUID=?");
            statment.setString(1,p.getUniqueId().toString());
            ResultSet results = statment.executeQuery();
            results.next();
            return results.getInt("MAXHEALTH");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void setSP(Classes classes, int arg1)
    {
        if(classes.getClasses() == 0)
        {
            return;
        }
        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement(
                    "UPDATE "+classes.getName()+" SET SP=? WHERE UUID=?");
            statment.setString(2,p.getUniqueId().toString());
            statment.setInt(1,arg1);
            statment.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getSP(Classes classes)
    {

        if(classes.getClasses() ==0)
        {
            return 0;
        }

        //SPを取得
        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement(
                    "SELECT * FROM " + classes.getName() + " WHERE UUID=?");
            statment.setString(1,p.getUniqueId().toString());
            ResultSet results = statment.executeQuery();
            results.next();
            return results.getInt("SP");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double getNextExp(Classes classes)
    {
        if(classes.getClasses() ==0)
        {
            return 0;
        }

        return (double) (((getLevel(classes)+60)*2+(getLevel(classes)*getLevel(classes)))*2);
    }

    public String getPrefix(Classes classes)
    {
        if(classes.getClasses() == 1) return "§7§l⚔§f§lソルジャー";//ソルジャー
        if(classes.getClasses() == 2) return "§4§l۞§c§lウィザード";//ウィザード
        if(classes.getClasses() == 3) return "§1§l◆§3§lガーディアン";//ガーディアン
        if(classes.getClasses() == 4) return "§2§l⚷§a§lシーフ";//チーフ
        if(classes.getClasses() == 5) return "§6✛§e§lハンター";//ハンター
        if(classes.getClasses() == 6) return "§8§l§m━]§7§l§m━§f§l§m━ §4§lアサシン";//アサシン
        if(classes.getClasses() == 7) return "§5§l☪§d§lネクロマンサー";//ネクロマンサー
        if(classes.getClasses() == 8) return "§3§l✞§b§lプリースト";//プリースト

        return "§c§l⃠§6§lアドベンチャー";
    }
}

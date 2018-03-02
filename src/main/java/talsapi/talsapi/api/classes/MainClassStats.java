package talsapi.talsapi.api.classes;

import org.bukkit.entity.Player;
import talsapi.talsapi.MySQLs;
import talsapi.talsapi.api.manager.enums.Classes;
import talsapi.talsapi.api.manager.enums.Stats;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainClassStats {

    private Player p;
    private Stats stats;
    private Classes classes;

    MainClassStats(Player p, Stats stats, Classes classes)
    {
        this.p = p;
        this.stats = stats;
        this.classes = classes;
    }

    public void setStats(int sp)
    {
        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement(
                    "UPDATE "+classes.getName()+" SET "+stats.getName()+"=? WHERE UUID=?");
            statment.setString(2,p.getUniqueId().toString());
            statment.setInt(1,sp);
            statment.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getStats()
    {
        //CLASSを入手
        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement(
                    "SELECT * FROM " + classes.getName() + " WHERE UUID=?");
            statment.setString(1,p.getUniqueId().toString());
            ResultSet results = statment.executeQuery();
            results.next();
            return results.getInt(stats.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}

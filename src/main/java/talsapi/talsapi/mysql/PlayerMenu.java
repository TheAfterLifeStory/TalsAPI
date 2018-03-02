package talsapi.talsapi.mysql;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import talsapi.talsapi.MySQLs;
import talsapi.talsapi.TALSAPI;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PlayerMenu {
    TALSAPI plugin = TALSAPI.getPlugin(TALSAPI.class);
    String prefix = "§e≪§cT§6A§aL§bS §9API§e≫ ";
    private String table = "PlayerMenu";

    //テーブル
    public void setTable()
    {
        try {
            //Detabase設定をしていない場合の処理
            if(MySQLs.getConnection() == null)
            {
                return;
            }

            //テーブルを作る
            PreparedStatement statement = MySQLs.getConnection().prepareStatement("USE "+ MySQLs.getDetabase());
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `"+table+"` (" +
                    "`UUID` TEXT," +
                    "`Class` int," +
                    "`NickName` TEXT," +
                    "`FishingLevel` int," +
                    "`FishingEXP` double," +
                    "`Rank` TEXT"+
                    ")");

            Bukkit.getConsoleSender().sendMessage(prefix+"§aLoad "+table+" TABLE");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //プレイやデータが損座しているか
    public boolean playerExists(Player p)
    {

        UUID uuid = p.getUniqueId();

        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement("SELECT * FROM "+table+" WHERE UUID=?");
            statment.setString(1,uuid.toString());

            ResultSet results = statment.executeQuery();
            if(results.next())
            {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    //プレイヤーデータを作成
    public void createPlayerDeta(Player p)
    {
        UUID uuid = p.getUniqueId();

        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement(
                    "SELECT * FROM "+table+" WHERE UUID=?");
            statment.setString(1, uuid.toString());
            ResultSet results = statment.executeQuery();
            results.next();
            if(!playerExists(p))
            {
                //LOAD
                PreparedStatement insert = MySQLs.getConnection().prepareStatement(
                        "INSERT INTO " + table + "(UUID,Class,NickName,FishingLevel,FishingEXP,Rank) VALUE (?,?,?,?,?,?)");
                //セット
                insert.setString(1,uuid.toString());
                insert.setInt(2,0);
                insert.setString(3, p.getName());
                insert.setInt(4,1);
                insert.setDouble(5,0.0);
                insert.setString(6,"");

                insert.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

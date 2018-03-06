package talsapi.talsapi.mysql;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import talsapi.talsapi.MySQLs;
import talsapi.talsapi.TALSAPI;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Necromancer {
    TALSAPI plugin = TALSAPI.getPlugin(TALSAPI.class);
    String prefix = "§e≪§cT§6A§aL§bS §9API§e≫ ";
    private String table = "Necromancer";

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
                    "`Level` int," +
                    "`Exp` double," +
                    "`MaxHealth` double," +
                    "`MaxMP` int," +
                    "`SP` int," +
                    "`StatsMaxHealth` int," +
                    "`StatsMaxMP` int," +
                    "`StatsAttackDamage` int," +
                    "`StatsSkillDamage` int," +
                    "`StatsSpeed` int," +
                    "`skill1` boolean,"+
                    "`skillLevel1` int,"+
                    "`skill2` boolean,"+
                    "`skillLevel2` int,"+
                    "`skill3` boolean,"+
                    "`skillLevel3` int,"+
                    "`skill4` boolean,"+
                    "`skillLevel4` int,"+
                    "`skill5` boolean,"+
                    "`skillLevel5` int,"+
                    "`skill6` boolean,"+
                    "`skillLevel6` int,"+
                    "`skill7` boolean,"+
                    "`skillLevel7` int,"+
                    "`skill8` boolean,"+
                    "`skillLevel8` int,"+
                    "`skill9` boolean,"+
                    "`skillLevel9` int,"+
                    "`skill10` boolean,"+
                    "`skillLevel10` int"+
                    ")");

            Bukkit.getConsoleSender().sendMessage(prefix+"§aLoad "+table+" TABLE");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //プレイやデータが損座しているか
    private boolean playerExists(Player p)
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
                        "INSERT INTO " + table + "(UUID,Level,Exp,MaxHealth,MaxMP,SP," +
                                "StatsMaxHealth,StatsMaxMP,StatsSkillDamage,StatsAttackDamage,StatsSpeed,"+
                                "Skill1,SkillLevel1," +
                                "Skill2,SkillLevel2," +
                                "Skill3,SkillLevel3," +
                                "Skill4,SkillLevel4," +
                                "Skill5,SkillLevel5," +
                                "Skill6,SkillLevel6," +
                                "Skill7,SkillLevel7," +
                                "Skill8,SkillLevel8," +
                                "Skill9,SkillLevel9," +
                                "Skill10,SkillLevel10" +
                                ") " +
                                "VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                //セット
                insert.setString(1,uuid.toString());//UUID
                insert.setInt(2,1);//LEVEL
                insert.setDouble(3,0.0);//EXP
                insert.setDouble(4,20.0);//MAXHealth
                insert.setInt(5,10);//MAX MP
                insert.setInt(6,0);//SP
                insert.setInt(7,0);//ADD HP
                insert.setInt(8,0);//ADD MP
                insert.setInt(9,0);//ADD SKILL DAMAGE
                insert.setInt(10,0);//ADD ATTACK DAMAGE
                insert.setInt(11,0);//ADD SPEED

                insert.setBoolean(12,false);//1
                insert.setBoolean(14,false);//2
                insert.setBoolean(16,false);//3
                insert.setBoolean(18,false);//4
                insert.setBoolean(20,false);//5
                insert.setBoolean(22,false);//6
                insert.setBoolean(24,false);//7
                insert.setBoolean(26,false);//8
                insert.setBoolean(28,false);//9
                insert.setBoolean(30,false);//10

                insert.setInt(13,1);//1
                insert.setInt(15,1);//2
                insert.setInt(17,1);//3
                insert.setInt(19,1);//4
                insert.setInt(21,1);//5
                insert.setInt(23,1);//6
                insert.setInt(25,1);//7
                insert.setInt(27,1);//8
                insert.setInt(29,1);//9
                insert.setInt(31,1);//10

                insert.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

package talsapi.talsapi.api.classes;

import org.bukkit.entity.Player;
import talsapi.talsapi.MySQLs;
import talsapi.talsapi.api.manager.enums.Classes;
import talsapi.talsapi.api.manager.enums.Skill;
import talsapi.talsapi.api.manager.enums.Stats;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainClassSkills {
    private Skill skill;
    private Player p;
    private Classes classes;

    MainClassSkills(Player p, Skill skill, Classes classes)
    {
        this.p = p;
        this.skill = skill;
        this.classes = classes;
    }

    public void setSkillLevel(int level)
    {
        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement(
                    "UPDATE "+classes.getName()+" SET "+skill.getSkillLevelMySQL()+"=? WHERE UUID=?");
            statment.setString(2,p.getUniqueId().toString());
            statment.setInt(1,level);
            statment.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getSkillLevel()
    {
        if(classes.getClasses() == 0)
        {
            return 0;
        }

        //CLASSを入手
        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement(
                    "SELECT * FROM " + classes.getName() + " WHERE UUID=?");
            statment.setString(1,p.getUniqueId().toString());
            ResultSet results = statment.executeQuery();
            results.next();
            return results.getInt(skill.getSkillLevelMySQL());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public boolean hasSkill()
    {
        if(classes.getClasses() == 0)
        {
            return false;
        }

        //CLASSを入手
        try {
            PreparedStatement statment = MySQLs.getConnection().prepareStatement(
                    "SELECT * FROM " + classes.getName() + " WHERE UUID=?");
            statment.setString(1,p.getUniqueId().toString());
            ResultSet results = statment.executeQuery();
            results.next();
            return results.getBoolean(skill.getSkillMySQL());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}

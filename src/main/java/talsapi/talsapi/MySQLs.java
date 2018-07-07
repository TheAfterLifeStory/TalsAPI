package talsapi.talsapi;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import talsapi.talsapi.mysql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLs {

    private static TALSAPI plugin = TALSAPI.getPlugin(TALSAPI.class);
    private static String prefix = "§e≪§cT§6A§aL§bS §9API§e≫ ";

    private static Connection connection;
    private static String host, database, username, password, table;
    private static int port;

    public static void mysqlSetup()
    {
        //Configに書き込まれてない場合
        if(plugin.getConfig().getString("host") == null||
                plugin.getConfig().getInt("port") == 0||
                plugin.getConfig().getString("detabase") == null||
                plugin.getConfig().getString("username") == null||
                plugin.getConfig().getString("password") == null)
        {
            return;
        }

        host = plugin.getConfig().getString("host");
        port = plugin.getConfig().getInt("port");
        database = plugin.getConfig().getString("detabase");
        username = plugin.getConfig().getString("username");
        password = plugin.getConfig().getString("password");
        table = "talsapi";

        //Connectionを設定する
        try {
            synchronized (new MySQLs()) {
                if (getConnection() != null && !getConnection().isClosed()) {
                    return;
                }

                Class.forName("com.mysql.jdbc.Driver");
                setConnection(
                        DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database,
                                username, password));

                Bukkit.getConsoleSender().sendMessage(prefix+"§aCONNECTED");

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    private static void setConnection(Connection connection) {
        MySQLs.connection = connection;
    }

    public static String getDetabase()
    {
        return database;
    }

    //テーブルを作る関数
    public static void setTables()
    {
        new Assassin().setTable();
        new Guardian().setTable();
        new Hunter().setTable();
        new Necromancer().setTable();
        new Priest().setTable();
        new Soldier().setTable();
        new Thief().setTable();
        new Wizard().setTable();
        new MainDeta().setTable();
    }

    public static void PluginStop()
    {
        //Mysqlとつなげなかった場合プラグインをストップさせる
        if(getConnection() == null)
        {
            Bukkit.getConsoleSender().sendMessage(prefix+"§4NOT CONNECT");
            plugin.onDisable();
            plugin.getServer().getPluginManager().disablePlugin(plugin.getServer().getPluginManager().getPlugin(plugin.getName()));
        }
    }

    public static void createPlayreDetas(Player p)
    {
        //Mysqlとつなげなかった場合プラグインをストップさせる
        if(getConnection() == null)
        {
            Bukkit.getConsoleSender().sendMessage(prefix+"§4NOT CONNECT");
            plugin.onDisable();
        }
        new Assassin().createPlayerDeta(p);
        new Guardian().createPlayerDeta(p);
        new Hunter().createPlayerDeta(p);
        new Necromancer().createPlayerDeta(p);
        new Priest().createPlayerDeta(p);
        new Soldier().createPlayerDeta(p);
        new Thief().createPlayerDeta(p);
        new Wizard().createPlayerDeta(p);
        new MainDeta().createPlayerDeta(p);
    }
}

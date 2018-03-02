package talsapi.talsapi;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import talsapi.talsapi.api.MySQLAPI;
import talsapi.talsapi.api.PlayerDeta;
import talsapi.talsapi.listener.PlayerJoinSet;

public final class TALSAPI extends JavaPlugin implements Listener {

    private PlayerJoinSet pjs;
    public MySQLs mysql;
    private String prefix = "§e≪§cT§6A§aL§bS §9API§e≫ ";

    /*
    ソルジャー : 1
    ウィザード : 2
    ガーディアン : 3
    シーフ : 4
    ハンター : 5
    アサシン : 6
    ネクロマンサー : 7
    プリースト : 8
     */
    @Override
    public void onEnable() {

        //LOADメッセージ開始
        Bukkit.getConsoleSender().sendMessage(prefix+"§aLoading API");

        //getServer().getPluginManager().registerEvents(this,this);

        //Myqslの読み込み
        MySQLs.mysqlSetup();
        MySQLs.setTables();

        //コンフィグをロード
        saveDefaultConfig();

        //クラスを読み込む
        pjs = new PlayerJoinSet();

        //Mysql読み込み失敗時
        MySQLs.PluginStop();

        //LOADメッセージ終了
        Bukkit.getConsoleSender().sendMessage(prefix+"§aFinish loading API");

    }

    @Override
    public void onDisable() {
    }

    public static PlayerDeta getPlayerDeta(Player p){ return new PlayerDeta(p); }
    public static MySQLAPI getMySQL(Player p){ return new MySQLAPI(); }

}

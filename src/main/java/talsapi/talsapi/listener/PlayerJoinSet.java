package talsapi.talsapi.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import talsapi.talsapi.MySQLs;
import talsapi.talsapi.TALSAPI;
import talsapi.talsapi.api.PlayerDeta;
import talsapi.talsapi.api.classes.MainClass;
import talsapi.talsapi.api.manager.enums.Classes;
import org.bukkit.entity.Player;
import talsapi.talsapi.api.manager.enums.Stats;

public class PlayerJoinSet implements Listener{
    TALSAPI plugin = TALSAPI.getPlugin(TALSAPI.class);

    public PlayerJoinSet ()
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        Player p = e.getPlayer();
        MySQLs.createPlayreDetas(e.getPlayer());
    }
}

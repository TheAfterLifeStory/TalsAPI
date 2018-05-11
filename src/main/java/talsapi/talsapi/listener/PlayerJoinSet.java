package talsapi.talsapi.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import talsapi.talsapi.MySQLs;
import talsapi.talsapi.TALSAPI;
import org.bukkit.entity.Player;
import talsapi.talsapi.inter.CreateSkill;

public class PlayerJoinSet implements Listener{
    private TALSAPI plugin = TALSAPI.getPlugin(TALSAPI.class);

    public PlayerJoinSet ()
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        Player p = e.getPlayer();
        MySQLs.createPlayreDetas(e.getPlayer());
        p.getInventory().setItem(8,getSkill());
    }

    public static ItemStack getSkill()
    {
        ItemStack item = new ItemStack(Material.END_CRYSTAL);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§d§m§r§3§2§l§l§r§7§l未設定");

        item.setItemMeta(meta);

        return item;
    }
}

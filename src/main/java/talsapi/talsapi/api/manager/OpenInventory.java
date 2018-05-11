package talsapi.talsapi.api.manager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import talsapi.talsapi.TALSAPI;
import talsapi.talsapi.api.classes.MainClass;
import talsapi.talsapi.inter.CreateSkill;

public class OpenInventory {

    private TALSAPI plugin = TALSAPI.getPlugin(TALSAPI.class);

    public void oi(Player p)
    {
        MainClass mc = TALSAPI.getPlayerDeta(p).getMainClass();
        Inventory inv = Bukkit.createInventory(null,9,mc.getPrefix()+"§fの§b§lスキル");
        for (CreateSkill cs : plugin.cs)
        {
            if(cs.setClassses() != TALSAPI.getPlayerDeta(p).getClasses())
            {
                continue;
            }

            ItemStack item = cs.addItemStack();

            ItemMeta meta = item.getItemMeta();

            meta.setDisplayName("§d§m§r§3§2§l§l§r"+item.getItemMeta().getDisplayName());

            item.setItemMeta(meta);

            inv.addItem(item);
        }
        inv.addItem(new ItemStack(Material.BARRIER));

        p.openInventory(inv);
    }
}

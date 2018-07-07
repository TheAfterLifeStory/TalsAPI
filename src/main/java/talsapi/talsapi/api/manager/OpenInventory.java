package talsapi.talsapi.api.manager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import talsapi.talsapi.TALSAPI;
import talsapi.talsapi.api.classes.MainClass;
import talsapi.talsapi.api.manager.enums.Skill;

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

            inv.addItem(setItem(cs.addItemStack(),cs.setSkill(),p));
        }
        inv.addItem(new ItemStack(Material.BARRIER));

        p.openInventory(inv);
    }

    public static ItemStack setItem(ItemStack i2, Skill sk,Player p)
    {
        int l = TALSAPI.getPlayerDeta(p).getMainClass().getSkill(sk).getSkillLevel();

        ItemStack item = i2;

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§d§m§r§3§2§l§l§r"+item.getItemMeta().getDisplayName()+"§7(Lv."+l+")");

        item.setItemMeta(meta);

        return item;
    }
}

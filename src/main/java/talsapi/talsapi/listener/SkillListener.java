package talsapi.talsapi.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import talsapi.talsapi.TALSAPI;
import talsapi.talsapi.api.manager.OpenInventory;
import talsapi.talsapi.inter.CreateSkill;

public class SkillListener implements Listener {
    private TALSAPI plugin = TALSAPI.getPlugin(TALSAPI.class);

    @EventHandler
    public void onClick(PlayerInteractEvent e)
    {
        if(e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK)
        {
            return;
        }

        ItemStack item = e.getItem();

        if(item == null)
        {
            return;
        }

        if(item.getType() == Material.AIR)
        {
            return;
        }

        if(!item.getItemMeta().hasDisplayName())
        {
            return;
        }

        if(!item.getItemMeta().getDisplayName().startsWith("§d§m§r§3§2§l§l§r"))
        {
            return;
        }

        String skill = item.getItemMeta().getDisplayName().replaceFirst("§d§m§r§3§2§l§l§r","");

        if(skill.equals("§7§l未設定"))
        {
            return;
        }

        String levelstr = skill.substring(skill.length()-6,skill.length());
        String SkillName = skill.substring(0,skill.length()-6);
        int level = Integer.parseInt(levelstr.replace("(Lv.","").replace(")",""));

        for(CreateSkill cs : plugin.cs)
        {
            if(OpenInventory.setItem(cs.addItemStack()) == item)
            {
                cs.castSkill(e.getPlayer(), SkillName, level);
            }
        }
    }

    @EventHandler
    public void onSwap(PlayerSwapHandItemsEvent e)
    {

        if(!e.getPlayer().isSneaking())
        {
            return;
        }

        ItemStack item = e.getOffHandItem();

        if(item == null)
        {
            return;
        }

        if(item.getType() == Material.AIR)
        {
            return;
        }

        if(!item.getItemMeta().hasDisplayName())
        {
            return;
        }

        if(!item.getItemMeta().getDisplayName().startsWith("§d§m§r§3§2§l§l§r"))
        {
            return;
        }

        e.setCancelled(true);

        new OpenInventory().oi(e.getPlayer());
    }

    @EventHandler
    public void onClick(InventoryClickEvent e)
    {
        if(e.getAction() == InventoryAction.HOTBAR_SWAP)
        {
            e.setCancelled(true);
        }

        if(e.getCurrentItem().getType() == Material.BARRIER)
        {
            e.setCancelled(true);
            if(e.getInventory().getTitle().equals("§c§l設定しない"))
            {
                e.getWhoClicked().closeInventory();
                return;
            }
        }

        ItemStack item = e.getCurrentItem();

        for(CreateSkill cs : plugin.cs)
        {
            if(item == OpenInventory.setItem(cs.addItemStack()))
            {
                e.getWhoClicked().getInventory().setItem(8,cs.addItemStack());
                e.getWhoClicked().closeInventory();
                return;
            }
        }
    }
}

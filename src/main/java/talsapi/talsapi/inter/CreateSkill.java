package talsapi.talsapi.inter;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface CreateSkill {

    void castSkill(Player player,String name,int level);

    ItemStack addItemStack();

    talsapi.talsapi.api.manager.enums.Classes setClassses();
}

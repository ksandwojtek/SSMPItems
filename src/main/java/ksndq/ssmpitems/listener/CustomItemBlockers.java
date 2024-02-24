package ksndq.ssmpitems.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static ksndq.ssmpitems.utils.Common.isCustomItem;

public class CustomItemBlockers implements Listener {

    @EventHandler
    private void onFurnaceSmelt(FurnaceSmeltEvent event) {
        ItemStack smeltedItem = event.getSource();
        if(!isCustomItem(smeltedItem)) return;
        event.setCancelled(true);
    }

    @EventHandler
    private void onAnvilResult(PrepareAnvilEvent event) {
        ItemStack item = event.getInventory().getItem(0);
        if(item == null) return;
        if(!isCustomItem(item)) return;
        event.setResult(null);
    }

    @EventHandler
    private void onItemUse(PlayerInteractEvent event) {
        if(event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        ItemStack item = event.getItem();
        if(item == null) return;
        if(!isCustomItem(item)) return;
        event.setCancelled(true);
    }

    @EventHandler
    private void onEnchant(PrepareItemEnchantEvent event) {
        ItemStack item = event.getItem();
        if(!isCustomItem(item)) return;
        event.setCancelled(true);
    }
}


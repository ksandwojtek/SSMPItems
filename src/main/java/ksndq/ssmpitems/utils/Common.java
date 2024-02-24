package ksndq.ssmpitems.utils;

import ksndq.ssmpitems.SSMPItems;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public final class Common {

    private Common() {}

    public static String colorize(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static boolean isCustomItem(ItemStack itemStack) {
        return (itemStack.hasItemMeta() && itemStack.getItemMeta().getPersistentDataContainer().has(SSMPItems.ssmpItemKey, PersistentDataType.STRING));
    }
}

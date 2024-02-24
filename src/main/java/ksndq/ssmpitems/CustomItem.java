package ksndq.ssmpitems;

import ksndq.ssmpitems.utils.Common;
import org.bukkit.Material;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.Repairable;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Attribute;

public abstract class CustomItem {
    public abstract String getName();

    public abstract Material getMaterial();

    public abstract List<String> getLore();

    public String getId() {
        return getClass().getSimpleName();
    }

    public ItemStack getItem() {
        ItemStack itemStack = new ItemStack(getMaterial(), 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        PersistentDataContainer container = itemMeta.getPersistentDataContainer();

        itemMeta.setDisplayName(Common.colorize(getName()));
        List<String> lore = new ArrayList<>();
        getLore().forEach(s -> lore.add(Common.colorize(s)));
        itemMeta.setLore(lore);

        container.set(SSMPItems.ssmpItemKey, PersistentDataType.STRING, getId());
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}

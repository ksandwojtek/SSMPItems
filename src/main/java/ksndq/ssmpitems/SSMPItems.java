package ksndq.ssmpitems;

import ksndq.ssmpitems.comand.CustomItemCommand;
import ksndq.ssmpitems.item.GardenScythe;
import ksndq.ssmpitems.listener.CustomItemBlockers;
import ksndq.ssmpitems.listener.GardenScytheHandler;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class SSMPItems extends JavaPlugin {

    public static NamespacedKey ssmpItemKey;
    public static Map<String, CustomItem> customItemMap;

    @Override
    public void onEnable() {
        ssmpItemKey = new NamespacedKey(this, "ssmp-item-key");
        customItemMap = new HashMap<>();
        registerItems(new GardenScythe());
        registerListeners(new GardenScytheHandler(), new CustomItemBlockers());
        getCommand("givesmpitem").setExecutor(new CustomItemCommand());

    }

    private void registerItems(CustomItem... customItems) {
        Arrays.asList(customItems).forEach(ci -> customItemMap.put(ci.getId(), ci));
    }

    private void registerListeners(Listener... listeners) {
        Arrays.asList(listeners).forEach(l -> Bukkit.getPluginManager().registerEvents(l, this));
    }
}

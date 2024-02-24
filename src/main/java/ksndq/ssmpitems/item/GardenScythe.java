package ksndq.ssmpitems.item;

import ksndq.ssmpitems.CustomItem;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class GardenScythe extends CustomItem {
    @Override
    public String getName() {
        return "&9Garden Scythe";
    }

    @Override
    public Material getMaterial() {
        return Material.IRON_HOE;
    }

    @Override
    public List<String> getLore() {
        return Arrays.asList("&7Cleans a &94x4 &7area of grass, leaves",
                "&7and flowers.",
                "",
                "&9&lRARE");
    }
}

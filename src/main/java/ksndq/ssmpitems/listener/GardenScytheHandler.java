package ksndq.ssmpitems.listener;

import ksndq.ssmpitems.SSMPItems;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static ksndq.ssmpitems.utils.Common.isCustomItem;

public class GardenScytheHandler implements Listener {

    List<Material> foliageList = Arrays.asList(Material.TALL_SEAGRASS, Material.SEAGRASS, Material.FERN, Material.DANDELION, Material.POPPY, Material.BLUE_ORCHID, Material.ALLIUM, Material.AZURE_BLUET, Material.RED_TULIP, Material.PINK_TULIP, Material.ORANGE_TULIP, Material.WHITE_TULIP, Material.OXEYE_DAISY, Material.CORNFLOWER, Material.LILY_OF_THE_VALLEY, Material.TORCHFLOWER, Material.WITHER_ROSE, Material.SUNFLOWER, Material.LILAC, Material.ROSE_BUSH, Material.PEONY, Material.PITCHER_PLANT, Material.LILY_PAD, Material.VINE, Material.SHORT_GRASS, Material.TALL_GRASS, Material.ACACIA_LEAVES, Material.AZALEA_LEAVES, Material.DARK_OAK_LEAVES, Material.BIRCH_LEAVES, Material.OAK_LEAVES, Material.CHERRY_LEAVES, Material.JUNGLE_LEAVES, Material.FLOWERING_AZALEA_LEAVES, Material.SPRUCE_LEAVES, Material.MANGROVE_LEAVES, Material.AZALEA_LEAVES);

    @EventHandler
    private void onBlockBreak(BlockBreakEvent event) {
        ItemStack itemUsed = event.getPlayer().getInventory().getItemInMainHand();
        if (!isCustomItem(itemUsed)) return;
        PersistentDataContainer container = itemUsed.getItemMeta().getPersistentDataContainer();
        String itemID = container.get(SSMPItems.ssmpItemKey, PersistentDataType.STRING);
        if (!Objects.equals(itemID, "GardenScythe")) return;
        Material blockType = event.getBlock().getType();
        if (!foliageList.contains(blockType)) return;
        Location center = event.getBlock().getLocation();
        for (int x = -3; x <= 3; x++) {
            for (int y = -3; y <= 3; y++) {
                for (int z = -3; z <= 3; z++) {
                    Location loc = center.clone().add(x, y, z);
                    Block block = loc.getBlock();
                    if (!foliageList.contains(block.getType())) continue;
                    block.setType(Material.AIR);
                }
            }
        }
    }
}

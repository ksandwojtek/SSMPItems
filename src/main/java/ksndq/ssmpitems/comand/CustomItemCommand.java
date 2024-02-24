package ksndq.ssmpitems.comand;

import ksndq.ssmpitems.SSMPItems;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CustomItemCommand implements CommandExecutor, TabExecutor {

    private static final String[] args0 = {"GardenScythe"};
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        if(args.length != 1) return false;

        Player p = (Player) sender;
        ItemStack item = SSMPItems.customItemMap.get(args[0]).getItem();

        p.getInventory().addItem(item);
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        final List<String> completions = new ArrayList<>();
        StringUtil.copyPartialMatches(args[0], Arrays.asList(args0), completions);
        Collections.sort(completions);
        return completions;
    }
}

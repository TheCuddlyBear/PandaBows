package me.pandaplugins.pandabows.commands;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class TeleportBowCommand implements CommandExecutor {
    private Plugin plugin;

    public TeleportBowCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (player.hasPermission("pandabows.tpbow")) {
                ItemStack teleport_bow = new ItemStack(Material.BOW);
                teleport_bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
                ItemMeta meta = teleport_bow.getItemMeta();
                meta.setDisplayName(ChatColor.RED + "Teleporting Bow");
                meta.setUnbreakable(true);
                ArrayList<String> lore = new ArrayList<>();
                lore.add("This bow teleports you to where the arrow lands");
                meta.setLore(lore);
                teleport_bow.setItemMeta(meta);
                player.getInventory().addItem(new ItemStack[] { teleport_bow });
            } else {
                player.sendMessage(ChatColor.RED + "Invalid permissions!");
            }
        } else {
            this.plugin.getLogger().severe("You need to be a player to run this command!");
        }
        return true;
    }
}

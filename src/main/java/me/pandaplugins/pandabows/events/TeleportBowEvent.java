package me.pandaplugins.pandabows.events;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TeleportBowEvent implements Listener {
    @EventHandler
    public void onProtectileHit(ProjectileHitEvent e) {
        if (e.getEntity() instanceof org.bukkit.entity.Arrow) {
            ItemStack teleport_bow = new ItemStack(Material.BOW);
            teleport_bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
            
            ItemMeta meta = teleport_bow.getItemMeta();
            meta.setDisplayName(ChatColor.RED + "Teleporting Bow");
            meta.setUnbreakable(true);
            ArrayList<String> lore = new ArrayList<>();
            lore.add("This bow teleports you to where the arrow lands");
            meta.setLore(lore);
            teleport_bow.setItemMeta(meta);
            Player player = (Player)e.getEntity().getShooter();

            if (player.getInventory().getItemInMainHand().isSimilar(teleport_bow)) {
                Location location = e.getEntity().getLocation();
                Location playerLocation = ((Player)e.getEntity().getShooter()).getLocation();
                player.playSound(playerLocation, Sound.ITEM_CHORUS_FRUIT_TELEPORT, 10.0F, 1.0F);
                player.teleport(location);
            }
        }
    }
}

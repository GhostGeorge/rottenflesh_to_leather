package me.ghostgeorge.rottenflesh;

import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class Rottenflesh extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        createCraftingRecipe();
        Bukkit.getLogger().info("RottenFleshToLeather has been enabled!");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("RottenFleshToLeather has been disabled!");
    }

    private void createCraftingRecipe() {
        ItemStack leather = new ItemStack(Material.LEATHER);
        NamespacedKey key = new NamespacedKey(this, "rotten_flesh_to_leather");
        if (Bukkit.getRecipe(key) == null) {
            ShapedRecipe recipe = new ShapedRecipe(key, leather);
            recipe.shape("R R", "RRR", "R R");
            recipe.setIngredient('R', Material.ROTTEN_FLESH);
            Bukkit.addRecipe(recipe);
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        NamespacedKey key = new NamespacedKey(this, "rotten_flesh_to_leather");
        event.getPlayer().discoverRecipe(key);
    }
}
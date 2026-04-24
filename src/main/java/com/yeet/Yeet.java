package com.yeet;

import org.bukkit.plugin.java.JavaPlugin;

public class Yeet extends JavaPlugin {

    @Override
    public void onEnable() {
        // Save default config if it doesn't exist
        saveDefaultConfig();

        // Register the death listener
        getServer().getPluginManager().registerEvents(new DeathListener(this), this);

        getLogger().info("Yeet plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Yeet plugin has been disabled!");
    }
}

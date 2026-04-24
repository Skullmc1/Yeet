package com.yeet;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.BanList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Calendar;
import java.util.Date;

public class DeathListener implements Listener {

    private final Yeet plugin;

    public DeathListener(Yeet plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        
        int banMinutes = plugin.getConfig().getInt("ban-time", 15);
        String banMessageTemplate = plugin.getConfig().getString("ban-message", "You died! You have been banned for {time} minutes.");
        String banMessage = banMessageTemplate.replace("{time}", String.valueOf(banMinutes));

        // Calculate expiration date
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, banMinutes);
        Date expiry = calendar.getTime();

        // Ban the player
        plugin.getServer().getBanList(BanList.Type.NAME).addBan(player.getName(), banMessage, expiry, "Death Ban");

        // Kick the player using modern Paper API
        Component kickReason = LegacyComponentSerializer.legacyAmpersand().deserialize(banMessage);
        player.kick(kickReason);
    }
}

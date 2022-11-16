package net.azisaba.yellowchat;

import net.azisaba.yellowchat.command.YellowChatCommand;
import net.azisaba.yellowchat.listener.ChatListener;
import net.azisaba.yellowchat.listener.JoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public final class YellowChat extends JavaPlugin {
    private final Set<UUID> excludedPlayers = new HashSet<>();

    @Override
    public void onEnable() {
        getConfig().getStringList("excluded-players").forEach(uuid -> excludedPlayers.add(UUID.fromString(uuid)));
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Objects.requireNonNull(Bukkit.getPluginCommand("yellowchat")).setExecutor(new YellowChatCommand());
    }

    @Override
    public void onDisable() {
        getConfig().set("excluded-players", excludedPlayers.stream().map(UUID::toString).collect(Collectors.toList()));
        saveConfig();
    }

    public static YellowChat getInstance() {
        return JavaPlugin.getPlugin(YellowChat.class);
    }

    public Set<UUID> getExcludedPlayers() {
        return excludedPlayers;
    }
}

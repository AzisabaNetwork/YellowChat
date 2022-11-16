package net.azisaba.yellowchat.listener;

import net.azisaba.yellowchat.YellowChat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class JoinListener implements Listener {
    private final Set<UUID> loggedInPlayers = new HashSet<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (loggedInPlayers.contains(e.getPlayer().getUniqueId())) {
            return;
        }
        loggedInPlayers.add(e.getPlayer().getUniqueId());
        if (e.getPlayer().hasPermission("yellowchat.default_off")) {
            YellowChat.getInstance().getExcludedPlayers().add(e.getPlayer().getUniqueId());
        }
    }
}

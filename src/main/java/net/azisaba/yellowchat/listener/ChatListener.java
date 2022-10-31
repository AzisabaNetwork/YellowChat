package net.azisaba.yellowchat.listener;

import net.azisaba.yellowchat.YellowChat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onChat(AsyncPlayerChatEvent e) {
        if (!YellowChat.getInstance().getExcludedPlayers().contains(e.getPlayer().getUniqueId()) &&
                e.getPlayer().hasPermission("yellowchat.use")) {
            e.setMessage("\u00a7e" + e.getMessage());
        }
    }
}

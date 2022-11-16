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
            int end = Math.min(5, e.getMessage().length());
            int index = 0;
            for (char c : e.getMessage().substring(0, end).toCharArray()) {
                if (c == '!' || c == '#') {
                    index++;
                } else {
                    break;
                }
            }
            String prefix = e.getMessage().substring(0, index);
            String message = e.getMessage().substring(index);
            e.setMessage(prefix + "\u00a7e" + message);
        }
    }
}

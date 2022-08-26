package net.azisaba.yellowchat.command;

import net.azisaba.yellowchat.YellowChat;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class YellowChatCommand implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;
        Set<UUID> excludedPlayers = YellowChat.getInstance().getExcludedPlayers();
        if (excludedPlayers.contains(player.getUniqueId())) {
            excludedPlayers.remove(player.getUniqueId());
            sender.sendMessage(ChatColor.GREEN + "チャットの色を黄色に変更しました。");
        } else {
            excludedPlayers.add(player.getUniqueId());
            sender.sendMessage(ChatColor.GREEN + "チャットの色をデフォルトに変更しました。");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return Collections.emptyList();
    }
}

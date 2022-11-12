package me.bruno.privatechats.listener;

import me.bruno.privatechats.ChatManager;
import me.bruno.privatechats.ConfigManager;
import net.zeeraa.novacore.spigot.teams.TeamManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Listeners implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onChat(AsyncPlayerChatEvent e) {

		if (ChatManager.getTeamChat().containsKey(e.getPlayer())) {
			if (ChatManager.hasTeamChatEnabled(e.getPlayer())) {
				if (!ChatManager.hasStaffChatToggled(e.getPlayer())) {
					ChatManager.toggleTeamChat(e.getPlayer());
				}
				ChatManager.sendMessageToTeam(e.getPlayer(), e.getMessage());
				e.setCancelled(true);
				return;
			}
		}
		if (ChatManager.getStaffChat().containsKey(e.getPlayer())) {
			if (ChatManager.hasStaffChatEnabled(e.getPlayer())) {
				if (!ChatManager.hasStaffChatToggled(e.getPlayer())) {
					ChatManager.toggleStaffChat(e.getPlayer());
				}
				ChatManager.sendMessageToStaff(e.getPlayer(), e.getMessage());
				e.setCancelled(true);
				return;
			}

		}
		if (e.getMessage().startsWith(ConfigManager.getStaffMessagePrefix())) {
			if (e.getPlayer().isOp() || e.getPlayer().hasPermission("privatechats.chat.staff")) {
				if (!ChatManager.hasStaffChatToggled(e.getPlayer())) {
					ChatManager.toggleStaffChat(e.getPlayer());
				}

				ChatManager.sendMessageToStaff(e.getPlayer(), e.getMessage().substring(ConfigManager.getStaffMessagePrefix().length()));
				e.setCancelled(true);
				return;
			}
		}
		if (e.getMessage().startsWith(ConfigManager.getTeamMessagePrefix())) {
			if (TeamManager.getTeamManager().getPlayerTeam(e.getPlayer()) != null) {
				if (!ChatManager.hasTeamChatToggled(e.getPlayer())) {
					ChatManager.toggleTeamChat(e.getPlayer());
				}

				ChatManager.sendMessageToTeam(e.getPlayer(), e.getMessage().substring(ConfigManager.getTeamMessagePrefix().length()));
				e.setCancelled(true);
				return;
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onJoin(PlayerJoinEvent e) {
		ChatManager.getStaffChatToggled().putIfAbsent(e.getPlayer(), true);
		ChatManager.getTeamChatToggled().putIfAbsent(e.getPlayer(), true);
		if (e.getPlayer().hasPermission("privatechats.chat.staff")) {
			ChatManager.getTeamSpyEnabled().putIfAbsent(e.getPlayer(), true);
		}
	}

}

package me.bruno.privatechats.commands.sub;

import me.bruno.privatechats.ChatManager;
import me.bruno.privatechats.ConfigManager;
import net.zeeraa.novacore.spigot.command.AllowedSenders;
import net.zeeraa.novacore.spigot.command.NovaSubCommand;
import net.zeeraa.novacore.spigot.teams.TeamManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeamChatToggle extends NovaSubCommand {
	public TeamChatToggle() {
		super("toggle");

		this.setDescription("Toggle/Untoggle team chat");

		this.setFilterAutocomplete(true);
		this.setEmptyTabMode(true);
		this.setAllowedSenders(AllowedSenders.PLAYERS);
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {
		Player player = (Player) sender;
		if (TeamManager.getTeamManager().getPlayerTeam(player) == null) {
			player.sendMessage("[" + ConfigManager.getTeamPrefix() + ChatColor.RESET + "] " + ChatColor.RED + "You are not in a team.");
			return false;
		}
		if (ChatManager.hasTeamChatToggled(player)) {
			ChatManager.untoggleTeamChat(player);
			if (ChatManager.hasTeamChatEnabled(player)) {
				ChatManager.disableTeamChat(player);
			}
		} else {
			ChatManager.toggleTeamChat(player);
		}
		return true;
	}
}

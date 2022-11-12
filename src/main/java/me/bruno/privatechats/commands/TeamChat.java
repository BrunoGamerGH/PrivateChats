package me.bruno.privatechats.commands;

import me.bruno.privatechats.ChatManager;
import me.bruno.privatechats.ConfigManager;
import me.bruno.privatechats.PrivateChats;
import me.bruno.privatechats.commands.sub.TeamChatToggle;
import net.zeeraa.novacore.spigot.command.AllowedSenders;
import net.zeeraa.novacore.spigot.command.NovaCommand;
import net.zeeraa.novacore.spigot.teams.TeamManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeamChat extends NovaCommand {

	public TeamChat() {
		super("teamchat", PrivateChats.getInstance());

		this.setAliases(NovaCommand.generateAliasList("tc", "teamc", "tchat"));

		this.setDescription("Toggles teamchat or sends a message to it");

		this.setFilterAutocomplete(true);
		this.setEmptyTabMode(true);
		this.setAllowedSenders(AllowedSenders.PLAYERS);

		this.addSubCommand(new TeamChatToggle());
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {
		Player player = (Player) sender;
		if (TeamManager.getTeamManager().getPlayerTeam(player) == null) {
			player.sendMessage("[" + ConfigManager.getTeamPrefix() + ChatColor.RESET + "] " + ChatColor.RED + "You are not in a team.");
			return false;
		}
		if (args.length == 0) {

			if (ChatManager.hasTeamChatEnabled(player)) {
				ChatManager.disableTeamChat(player);
			} else {
				ChatManager.enableTeamChat(player);
				if (ChatManager.hasStaffChatEnabled(player)) {
					ChatManager.disableStaffChat(player);
				}
			}

			if (!ChatManager.hasTeamChatToggled(player) && ChatManager.hasTeamChatEnabled(player)) {
				ChatManager.toggleTeamChat(player);
			}
		} else {
			StringBuilder builder = new StringBuilder();
			for (String arg : args) {
				if (builder.length() == 0) {
					builder.append(arg);
				} else {
					builder.append(" ").append(arg);
				}
			}
			ChatManager.sendMessageToTeam(player, builder.toString());
		}
		return true;
	}
}

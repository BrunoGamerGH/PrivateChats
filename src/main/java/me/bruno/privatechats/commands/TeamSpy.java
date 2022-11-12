package me.bruno.privatechats.commands;

import me.bruno.privatechats.ChatManager;
import me.bruno.privatechats.PrivateChats;
import net.zeeraa.novacore.spigot.command.AllowedSenders;
import net.zeeraa.novacore.spigot.command.NovaCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionDefault;

public class TeamSpy extends NovaCommand {
	public TeamSpy() {
		super("teamspy", PrivateChats.getInstance());
		setAliases(generateAliasList("ts", "tspy"));

		this.setDescription("Toggles visibility to TeamSpy");

		this.setPermission("privatechats.chat.staff");
		this.setFilterAutocomplete(true);
		this.setEmptyTabMode(true);
		this.setAllowedSenders(AllowedSenders.PLAYERS);
		this.setPermissionDefaultValue(PermissionDefault.OP);
	}

	@Override
	public boolean execute(CommandSender commandSender, String s, String[] strings) {
		Player player = (Player) commandSender;
		if (!player.hasPermission("privatechats.chat.staff") && !player.isOp()) {
			player.sendMessage(ChatColor.RED + "You dont have permission to run this command");
			return false;
		} else {
			if (ChatManager.getTeamSpyEnabled().get(player)) {
				ChatManager.untoggleTeamSpy(player);
			} else {
				ChatManager.toggleTeamSpy(player);
			}
		}

		return false;
	}
}

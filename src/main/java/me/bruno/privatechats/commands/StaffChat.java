package me.bruno.privatechats.commands;

import me.bruno.privatechats.ChatManager;
import me.bruno.privatechats.PrivateChats;
import me.bruno.privatechats.commands.sub.StaffChatToggle;
import net.zeeraa.novacore.spigot.command.AllowedSenders;
import net.zeeraa.novacore.spigot.command.NovaCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionDefault;

public class StaffChat extends NovaCommand {

	public StaffChat() {
		super("staffchat", PrivateChats.getInstance());

		this.setAliases(NovaCommand.generateAliasList("sc", "staffc", "schat"));

		this.setDescription("Toggles staffchat or sends a message to it");

		this.setPermission("privatechats.chat.staff");
		this.setFilterAutocomplete(true);
		this.setEmptyTabMode(true);
		this.setAllowedSenders(AllowedSenders.PLAYERS);
		this.setPermissionDefaultValue(PermissionDefault.OP);

		this.addSubCommand(new StaffChatToggle());
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {
		Player player = (Player) sender;

		// you can delete this if its unnecessary
		if (!player.hasPermission("privatechats.chat.staff") && !player.isOp()) {
			player.sendMessage(ChatColor.RED + "You dont have permission to run this command");
			return false;
		}
		if (args.length == 0) {
			if (ChatManager.hasStaffChatEnabled(player)) {
				ChatManager.disableStaffChat(player);
			} else {
				ChatManager.enableStaffChat(player);
				if (ChatManager.hasTeamChatEnabled(player)) {
					ChatManager.disableTeamChat(player);
				}
			}

			if (!ChatManager.hasStaffChatToggled(player) && ChatManager.hasStaffChatEnabled(player)) {
				ChatManager.toggleStaffChat(player);
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
			ChatManager.sendMessageToStaff(player, builder.toString());
		}
		return true;
	}
}

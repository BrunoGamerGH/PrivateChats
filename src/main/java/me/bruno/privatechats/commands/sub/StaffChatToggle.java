package me.bruno.privatechats.commands.sub;

import me.bruno.privatechats.ChatManager;
import net.zeeraa.novacore.spigot.command.AllowedSenders;
import net.zeeraa.novacore.spigot.command.NovaSubCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionDefault;

public class StaffChatToggle extends NovaSubCommand {

	public StaffChatToggle() {
		super("toggle");

		this.setDescription("Toggle/Untoggle staff chat");

		this.setPermission("privatechats.chat.staff");
		this.setFilterAutocomplete(true);
		this.setEmptyTabMode(true);
		this.setAllowedSenders(AllowedSenders.PLAYERS);
		this.setPermissionDefaultValue(PermissionDefault.OP);
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {
		Player player = (Player) sender;
		// you can delete this if its unnecessary
		if (!player.hasPermission("privatechats.chat.staffchat") || !player.isOp()) {
			player.sendMessage(ChatColor.RED + "You dont have permission to run this command");
			return false;
		}
		if (ChatManager.hasStaffChatToggled(player)) {
			ChatManager.untoggleStaffChat(player);
			if (ChatManager.hasStaffChatEnabled(player)) {
				ChatManager.disableStaffChat(player);
			}
		} else {
			ChatManager.toggleStaffChat(player);
		}
		return true;
	}
}

package me.bruno.privatechats;

import me.bruno.privatechats.commands.StaffChat;
import me.bruno.privatechats.commands.TeamChat;
import me.bruno.privatechats.listener.Listeners;
import net.zeeraa.novacore.commons.log.Log;
import net.zeeraa.novacore.spigot.abstraction.VersionIndependentUtils;
import net.zeeraa.novacore.spigot.command.CommandRegistry;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class PrivateChats extends JavaPlugin {

    private static PrivateChats instance;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        instance = this;
        Log.info("PrivateChats", "PrivateChats has been enabled. Run /staffchat or send a message starting with * to send a message to all staff.");
        CommandRegistry.registerCommand(new StaffChat());
        CommandRegistry.registerCommand(new TeamChat());
        Bukkit.getPluginManager().registerEvents(new Listeners(), this);
        ConfigManager.setStaffPrefix(getConfig().getString("staff_prefix"));
        ConfigManager.setTeamPrefix(getConfig().getString("team_prefix"));

        ConfigManager.setStaffMessagePrefix(getConfig().getString("staff_message_prefix"));

        ConfigManager.setStaffEnableMessage(getConfig().getString("staff_enable"));
        ConfigManager.setStaffDisableMessage(getConfig().getString("staff_disable"));
        ConfigManager.setStaffToggleMessage(getConfig().getString("staff_toggle"));
        ConfigManager.setStaffUntoggleMessage(getConfig().getString("staff_untoggle"));

        ConfigManager.setTeamEnableMessage(getConfig().getString("team_enable"));
        ConfigManager.setTeamDisableMessage(getConfig().getString("team_disable"));
        ConfigManager.setTeamToggleMessage(getConfig().getString("team_toggle"));
        ConfigManager.setTeamUntoggleMessage(getConfig().getString("team_untoggle"));

        ConfigManager.setStaffMessageSent(getConfig().getString("staff_message"));
        ConfigManager.setTeamMessageSent(getConfig().getString("team_message"));

        Bukkit.getOnlinePlayers().forEach(player -> {
            ChatManager.setStaffChatToggled(player, true);
            ChatManager.setTeamChatToggled(player, true);
        });
    }
    public static PrivateChats getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        Log.info("PrivateChats", "Disabling PrivateChats.");
    }

}

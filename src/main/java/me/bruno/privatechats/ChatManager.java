package me.bruno.privatechats;

import net.zeeraa.novacore.spigot.teams.Team;
import net.zeeraa.novacore.spigot.teams.TeamManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class ChatManager {

    private static final HashMap<Player, Boolean> teamChatEnabled;
    private static final HashMap<Player, Boolean> staffChatEnabled;
    private static final HashMap<Player, Boolean> teamChatToggled;
    private static final HashMap<Player, Boolean> staffChatToggled;





    static {
        teamChatEnabled = new HashMap<>();
        staffChatEnabled = new HashMap<>();
        teamChatToggled = new HashMap<>();
        staffChatToggled = new HashMap<>();
    }
    public static boolean hasTeamChatEnabled(Player player) {
        if (!teamChatEnabled.containsKey(player)) {
            teamChatEnabled.putIfAbsent(player, false);
        }
        return teamChatEnabled.get(player);
    }
    public static void setTeamChatEnabled(Player player, boolean b) {
        teamChatEnabled.put(player, b);
    }

    public static HashMap<Player, Boolean> getTeamChat() {
        return teamChatEnabled;
    }

    public static void disableTeamChat(Player player) {
        teamChatEnabled.putIfAbsent(player, false);
        teamChatEnabled.put(player, false);

        player.sendMessage(ChatColor.translateAlternateColorCodes('&',ConfigManager.getTeamDisableMessage().replace("%prefix%", ConfigManager.getTeamPrefix())));
    }

    public static void enableTeamChat(Player player) {
        teamChatEnabled.putIfAbsent(player, true);
        teamChatEnabled.put(player, true);
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getTeamEnableMessage().replace("%prefix%", ConfigManager.getTeamPrefix())));
    }


    public static boolean hasStaffChatEnabled(Player player) {
        if (!staffChatEnabled.containsKey(player)) {
            staffChatEnabled.putIfAbsent(player, false);
        }
        return staffChatEnabled.get(player);
    }
    public static void setStaffChatEnabled(Player player, boolean b) {
        staffChatEnabled.put(player, b);
    }

    public static HashMap<Player, Boolean> getStaffChat() {
        return staffChatEnabled;
    }

    public static void disableStaffChat(Player player) {
        staffChatEnabled.putIfAbsent(player, false);
        staffChatEnabled.put(player, false);
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getStaffDisableMessage().replace("%prefix%", ConfigManager.getStaffPrefix())));
    }

    public static void enableStaffChat(Player player) {
        staffChatEnabled.putIfAbsent(player, true);
        staffChatEnabled.put(player, true);
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getStaffEnableMessage().replace("%prefix%", ConfigManager.getStaffPrefix())));
    }

    public static void sendMessageToTeam(Player player, String message) {
        Team senderTeam = TeamManager.getTeamManager().getPlayerTeam(player);
        Bukkit.getOnlinePlayers().forEach(onlinePlayer -> {
            if (TeamManager.getTeamManager().getPlayerTeam(player) != null) {
                Team team = TeamManager.getTeamManager().getPlayerTeam(player);
                if (team.getTeamUuid().equals(senderTeam.getTeamUuid())) {
                    if (ChatManager.hasTeamChatToggled(onlinePlayer)) {
                        onlinePlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getTeamMessageSent().replace("%prefix%", ConfigManager.getTeamPrefix())
                                .replace("%teamcolor%", senderTeam.getTeamColor().toString()).replace("%player%", player.getName())
                                ).replace("%message%", message));
                    }
                }
            }
        });
    }

    public static void sendMessageToStaff(Player player, String message) {
        Bukkit.getOnlinePlayers().forEach(onlinePlayer -> {
            if (onlinePlayer.hasPermission("privatechats.chat.staffchat") || onlinePlayer.isOp()) {
                if (ChatManager.hasStaffChatToggled(onlinePlayer)) {
                    onlinePlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getStaffMessageSent().replace("%prefix%", ConfigManager.getStaffPrefix())
                            .replace("%player%", player.getName())).replace("%message%", message));
                }

            }
        });
    }

    public static boolean hasTeamChatToggled(Player player) {
        return teamChatToggled.get(player);
    }
    public static void setTeamChatToggled(Player player, boolean b) {
        teamChatToggled.put(player, b);
    }

    public static void untoggleTeamChat(Player player) {
        teamChatToggled.put(player, false);
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getTeamUntoggleMessage().replace("%prefix%", ConfigManager.getTeamPrefix())));
    }

    public static void toggleTeamChat(Player player) {
        teamChatToggled.put(player, true);
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getTeamToggleMessage().replace("%prefix%", ConfigManager.getTeamPrefix())));
    }

    public static HashMap<Player, Boolean> getTeamChatToggled() {
        return teamChatToggled;
    }

    public static boolean hasStaffChatToggled(Player player) {
        return staffChatToggled.get(player);
    }
    public static void setStaffChatToggled(Player player, boolean b) {
        staffChatToggled.put(player, b);
    }
    public static void untoggleStaffChat(Player player) {
        staffChatToggled.put(player, false);
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getStaffUntoggleMessage().replace("%prefix%", ConfigManager.getTeamPrefix())));
    }

    public static void toggleStaffChat(Player player) {
        staffChatToggled.put(player, true);
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getTeamUntoggleMessage().replace("%prefix%", ConfigManager.getTeamPrefix())));
    }

    public static HashMap<Player, Boolean> getStaffChatToggled() {
        return staffChatToggled;
    }







}

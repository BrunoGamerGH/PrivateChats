package me.bruno.privatechats;

import org.bukkit.ChatColor;

public class ConfigManager {

    private static String staffPrefix;
    private static String teamPrefix;

    private static String staffMessagePrefix;

    private static String staffEnableMessage;
    private static String staffDisableMessage;
    private static String staffToggleMessage;
    private static String staffUntoggleMessage;

    private static String teamEnableMessage;
    private static String teamDisableMessage;
    private static String teamToggleMessage;
    private static String teamUntoggleMessage;

    private static String staffMessageSent;
    private static String teamMessageSent;

    private static final String DEFAULT_STAFF_PREFIX = ChatColor.translateAlternateColorCodes('&', "&d&lSTAFF&r");
    private static final String DEFAULT_TEAM_PREFIX = ChatColor.translateAlternateColorCodes('&', "&6&lTEAM&r");
    private static final String DEFAULT_STAFF_MESSAGE_PREFIX = "**";

    private static final String DEFAULT_STAFF_ENABLE_MESSAGE = "[%prefix%] &aStaff Chat has been &lEnabled";
    private static final String DEFAULT_STAFF_DISABLE_MESSAGE = "[%prefix%] &cStaff Chat has been &lDisabled";
    private static final String DEFAULT_STAFF_TOGGLE_MESSAGE = "[%prefix%] &aVision for Staff Chat has been &lToggled";
    private static final String DEFAULT_STAFF_UNTOGGLE_MESSAGE = "[%prefix%] &cVision for Staff Chat has been &lUntoggled";

    private static final String DEFAULT_TEAM_ENABLE_MESSAGE = "[%prefix%] &aTeam Chat has been &lEnabled";
    private static final String DEFAULT_TEAM_DISABLE_MESSAGE = "[%prefix%] &cTeam Chat has been &lDisabled";
    private static final String DEFAULT_TEAM_TOGGLE_MESSAGE = "[%prefix%] &aVision for Team Chat has been &lToggled";
    private static final String DEFAULT_TEAM_UNTOGGLE_MESSAGE = "[%prefix%] &cVision for Team Chat has been &lUntoggled";

    private static final String DEFAULT_STAFF_MESSAGE_SENT = "%prefix%: &6%player%&d -> &r%message%";
    private static final String DEFAULT_TEAM_MESSAGE_SENT = "%prefix%: %teamcolor%%player%&6 -> &r%message%";


    public static void setStaffPrefix(String s) {
        staffPrefix = s;
    }

    public static String getStaffPrefix() {
        if (staffPrefix == null || staffPrefix.equals(""))
            return DEFAULT_STAFF_PREFIX;
        return staffPrefix;
    }

    public static void setTeamPrefix(String s) {
        teamPrefix = s;
    }
    public static String getTeamPrefix() {
        if (teamPrefix == null || staffPrefix.equals(""))
            return DEFAULT_TEAM_PREFIX;
        return teamPrefix;
    }



    public static void setStaffMessagePrefix(String s) {
        staffMessagePrefix = s;
    }
    public static String getStaffMessagePrefix() {
        if (staffMessagePrefix == null || staffMessagePrefix.equals(""))
            return DEFAULT_STAFF_MESSAGE_PREFIX;
        return staffMessagePrefix;
    }



    public static void setStaffEnableMessage(String s) {
        staffEnableMessage = s;
    }
    public static String getStaffEnableMessage() {
        if (staffEnableMessage == null || staffEnableMessage.equals(""))
            return DEFAULT_STAFF_ENABLE_MESSAGE;
        return staffEnableMessage;
    }

    public static void setStaffDisableMessage(String s) {
        staffDisableMessage = s;
    }
    public static String getStaffDisableMessage() {
        if (staffDisableMessage == null || staffDisableMessage.equals(""))
            return DEFAULT_STAFF_DISABLE_MESSAGE;
        return staffDisableMessage;
    }

    public static void setStaffToggleMessage(String s) {
        staffToggleMessage = s;
    }
    public static String getStaffToggleMessage() {
        if (staffToggleMessage == null || staffToggleMessage.equals(""))
            return DEFAULT_STAFF_TOGGLE_MESSAGE;
        return staffToggleMessage;
    }

    public static void setStaffUntoggleMessage(String s) {
        staffUntoggleMessage = s;
    }
    public static String getStaffUntoggleMessage() {
        if (staffUntoggleMessage == null || staffUntoggleMessage.equals(""))
            return DEFAULT_STAFF_UNTOGGLE_MESSAGE;
        return staffUntoggleMessage;
    }


    public static void setTeamEnableMessage(String s) {
        teamEnableMessage = s;
    }
    public static String getTeamEnableMessage() {
        if (teamEnableMessage == null || teamEnableMessage.equals(""))
            return DEFAULT_TEAM_ENABLE_MESSAGE;
        return teamEnableMessage;
    }

    public static void setTeamDisableMessage(String s) {
        teamDisableMessage = s;
    }
    public static String getTeamDisableMessage() {
        if (teamDisableMessage == null || teamDisableMessage.equals(""))
            return DEFAULT_TEAM_DISABLE_MESSAGE;
        return teamDisableMessage;
    }

    public static void setTeamToggleMessage(String s) {
        teamToggleMessage = s;
    }
    public static String getTeamToggleMessage() {
        if (teamToggleMessage == null || teamToggleMessage.equals(""))
            return DEFAULT_TEAM_TOGGLE_MESSAGE;
        return teamToggleMessage;
    }

    public static void setTeamUntoggleMessage(String s) {
        teamUntoggleMessage = s;
    }
    public static String getTeamUntoggleMessage() {
        if (teamUntoggleMessage == null || teamUntoggleMessage.equals(""))
            return DEFAULT_TEAM_UNTOGGLE_MESSAGE;
        return teamUntoggleMessage;
    }
    public static void setTeamMessageSent(String s) {
        teamMessageSent = s;
    }
    public static String getTeamMessageSent() {
        if (teamMessageSent == null || teamMessageSent.equals(""))
            return DEFAULT_TEAM_MESSAGE_SENT;
        return teamMessageSent;
    }
    public static void setStaffMessageSent(String s) {
        staffMessageSent = s;
    }
    public static String getStaffMessageSent() {
        if (staffMessageSent == null || staffMessageSent.equals(""))
            return DEFAULT_STAFF_MESSAGE_SENT;
        return staffMessageSent;
    }
}
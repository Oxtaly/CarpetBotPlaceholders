package com.oxtaly.carpetbotplaceholders.config;
// Stole a lot from https://github.com/Reimnop/Discord4Fabric & https://github.com/Patbox/StyledChat as an example, this being my first mod :>

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ConfigData implements Cloneable {
    public static ConfigData DEFAULT = createDefault();

    @SerializedName("config_version_DO_NOT_TOUCH")
    public String configVersion;

    @SerializedName("carpet_bot_prefix")
    public String carpetBotPrefix;

    @SerializedName("shadowed_player_prefix")
    public String shadowedPlayerPrefix;

    public static @NotNull ConfigData createDefault() {
        ConfigData configData = new ConfigData();

        configData.configVersion = "1.0.0";
        configData.carpetBotPrefix = "<dark_gray>[<red>Bot</red>]</dark_gray> ";
        configData.shadowedPlayerPrefix = "<dark_gray>[<aqua>AFK</aqua>]</dark_gray> ";

        return configData;
    }

    public void fillMissing() {
        this.configVersion = Objects.requireNonNullElse(this.configVersion, DEFAULT.configVersion);
        this.carpetBotPrefix = Objects.requireNonNullElse(this.carpetBotPrefix, DEFAULT.carpetBotPrefix);
        this.shadowedPlayerPrefix = Objects.requireNonNullElse(this.shadowedPlayerPrefix, DEFAULT.shadowedPlayerPrefix);
    }

    public ConfigData clone() {
        try {
            return (ConfigData) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
